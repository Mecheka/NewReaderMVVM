package com.example.suriya.newreadermvvm.view.listnews

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.suriya.newreadermvvm.R
import com.example.suriya.newreadermvvm.databinding.ListNewsFragmentBinding
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.repositories.ListNewsRepositories
import com.example.suriya.newreadermvvm.view.base.BaseFragment
import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsViewModel
import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsViewModelFactory
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class ListNewsFragment : BaseFragment() {

    private lateinit var binding: ListNewsFragmentBinding
    private val compositeDisposable = CompositeDisposable()
   // @Inject lateinit var listNewsRepo: ListNewsRepositories

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_news, container, false)
        binding.setLifecycleOwner(this)

        val sources = activity?.intent?.extras?.getSerializable("sources") as Sources

        val listNewsViewModel: ListNewsViewModel = ViewModelProviders.of(this,
                ListNewsViewModelFactory(ListNewsRepositories(), sources))
                .get(ListNewsViewModel::class.java)

        binding.viewControl = this
        binding.viewModel = listNewsViewModel

        initInstnce()
        subscribePublishSubject()

        return binding.root
    }

    private fun subscribePublishSubject() {
        binding.viewModel?.showDialogLoading?.subscribe {
            when(it){
                true -> showDialog("Loading")
                else -> dismissDialog()
            }
        }?.addTo(compositeDisposable)
    }

    private fun initInstnce() {
        binding.listNews.layoutManager = LinearLayoutManager(activity,
                LinearLayout.VERTICAL, false)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}


