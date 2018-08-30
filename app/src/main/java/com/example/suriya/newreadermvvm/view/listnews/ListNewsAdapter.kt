package com.example.suriya.newreadermvvm.view.listnews

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.suriya.newreadermvvm.R
import com.example.suriya.newreadermvvm.databinding.NewsItemBinding
import com.example.suriya.newreadermvvm.model.listnews.ArticleModel
import com.example.suriya.newreadermvvm.viewmodel.listnews.ListNewsItemViewModel

class ListNewsAdapter : RecyclerView.Adapter<ListNewsAdapter.ListNewsViewHolder>() {

    private lateinit var newsList: ArrayList<ArticleModel>
    private lateinit var binding: NewsItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ListNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_news_item, parent, false)
        return ListNewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::newsList.isInitialized) newsList.size else 0
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {

        holder.bind(newsList[position])

    }

    fun setDataNewsList(articlesList: ArrayList<ArticleModel>) {
        this.newsList = articlesList
        notifyDataSetChanged()
    }

    class ListNewsViewHolder(private val binding: NewsItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        val viewModel = ListNewsItemViewModel()

        fun bind(articleModel: ArticleModel) {
            binding.viewModel = viewModel
            viewModel.bind(itemView.context, articleModel)
            binding.executePendingBindings()
        }

    }

}