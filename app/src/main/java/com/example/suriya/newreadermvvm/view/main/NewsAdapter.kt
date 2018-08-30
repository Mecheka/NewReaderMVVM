package com.example.suriya.newreadermvvm.view.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.suriya.newreadermvvm.R
import com.example.suriya.newreadermvvm.databinding.SourceItemBinding
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.viewmodel.news.NewsItemViewModel

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private lateinit var sourceList: ArrayList<Sources>
    private lateinit var binding: SourceItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.custom_source_item, parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::sourceList.isInitialized) sourceList.size else 0
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.bind(sourceList[position])

    }

    fun setSourceData(sourcesList: ArrayList<Sources>) {
        this.sourceList = sourcesList
        notifyDataSetChanged()
    }

    class NewsViewHolder(private val binding: SourceItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        val viewModel = NewsItemViewModel()

        fun bind(sources: Sources) {
            binding.viewModel = viewModel
            viewModel.bind(itemView.context, sources)
            viewModel.setAdapterPosition(adapterPosition)
            binding.executePendingBindings()
        }

    }
}