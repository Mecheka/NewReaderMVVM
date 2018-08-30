package com.example.suriya.newreadermvvm.viewmodel.listnews

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.suriya.newreadermvvm.base.BaseViewModel
import com.example.suriya.newreadermvvm.model.listnews.ArticleModel
import com.example.suriya.newreadermvvm.model.news.Sources
import com.example.suriya.newreadermvvm.repositories.ListNewsRepositories
import com.example.suriya.newreadermvvm.view.listnews.ListNewsAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import retrofit2.HttpException
import javax.inject.Inject

class ListNewsViewModel(val repository: ListNewsRepositories, sources: Sources)
    : BaseViewModel() {

    private var compositeDisposable = CompositeDisposable()
    var urlImage = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var author = MutableLiveData<String>()
    @Inject
    lateinit var listNewsAdapter: ListNewsAdapter
    val showDialogLoading: PublishSubject<Boolean> = PublishSubject.create()

    init {
        setSourceData(sources)
    }

    fun setSourceData(sources: Sources) {
        repository.loadNews(sources).subscribe({ news ->
            urlImage.value = news.articles?.get(0)?.urlToImage
            title.value = news.articles?.get(0)?.title
            author.value = news.articles?.get(0)?.author
            setDataToRecyclerView(news.articles!!)
            showDialogLoading.onNext(true)
        }, { error ->
            showDialogLoading.onNext(false)
            if (error is HttpException) {
                if (error.code() == 401) {
                    // We've got HTTP 401 Unauthorized
                } else {

                    Log.e("HTTP Error: ", " "
                            + error.response().code() + " "
                            + error.response().message() + " "
                            + error.response().errorBody().toString())
                }

            } else {
                // something really wrong happened
                // e.g.: invalid json or something else
                Log.e("Error: ", error.message)
            }
        }, {
            showDialogLoading.onNext(false)
        }).addTo(compositeDisposable)
    }

    private fun setDataToRecyclerView(articlesList: ArrayList<ArticleModel>) {
        listNewsAdapter.setDataNewsList(articlesList)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}