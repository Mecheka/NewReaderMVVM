package com.example.suriya.newreadermvvm.view.listnews

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
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
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class ListNewsFragment : Fragment() {

    private lateinit var binding: ListNewsFragmentBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    val listNewsViewModel: ListNewsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
                .get(ListNewsViewModel::class.java)
    }
    private val compositeDisposable = CompositeDisposable()

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        lifecycle.addObserver(listNewsViewModel)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_news, container, false)
        binding.setLifecycleOwner(this)

        val sources = activity?.intent?.extras?.getSerializable("sources") as Sources

        listNewsViewModel.setSourceData(sources)
        binding.viewModel = listNewsViewModel

        initInstnce()

        return binding.root
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


