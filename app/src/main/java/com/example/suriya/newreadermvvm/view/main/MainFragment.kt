package com.example.suriya.newreadermvvm.view.main

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
import com.example.suriya.newreadermvvm.databinding.FragmentMainBinding
import com.example.suriya.newreadermvvm.repositories.NewsRepository
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModel
import com.example.suriya.newreadermvvm.viewmodel.news.NewsViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val newsViewModel: NewsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
                .get(NewsViewModel::class.java)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        lifecycle.addObserver(newsViewModel)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(this)

        binding.viewModel = newsViewModel

        initInstance()
        return binding.root
    }

    private fun initInstance() {
        binding.recyclerListNews.layoutManager = LinearLayoutManager(activity,
                LinearLayout.VERTICAL, false)

    }
}

