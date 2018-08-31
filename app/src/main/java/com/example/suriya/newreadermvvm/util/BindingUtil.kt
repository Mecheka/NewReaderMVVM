package com.example.suriya.newreadermvvm.util

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.flaviofaria.kenburnsview.KenBurnsView
import com.github.curioustechizen.ago.RelativeTimeTextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

@BindingAdapter("setAdapter")
fun setAdapterList(view: RecyclerView, adater: RecyclerView.Adapter<*>) {
    view.adapter = adater
}

@BindingAdapter("mutableText")
fun setTextLiveData(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value ->
            view.text = value ?: ""
        })
    }
}

@BindingAdapter("setImageUrlKVB")
fun setImageUrlKBV(view: KenBurnsView, url: MutableLiveData<String>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && view != null) {
        url.observe(parentActivity, Observer { value ->
            Picasso.with(view.context)
                    .load(value)
                    .into(view)
        })
    }

}

@BindingAdapter("setImageUrlCir")
fun setImageUtlCir(view: CircleImageView, url: MutableLiveData<String>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && view != null) {
        url.observe(parentActivity, Observer { value ->
            Picasso.with(view.context)
                    .load(value)
                    .into(view)
        })
    }
}

@BindingAdapter("setTextTime")
fun setTextTime(view: RelativeTimeTextView, text: MutableLiveData<Date>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && view != null) {
        text.observe(parentActivity, Observer { date ->
            date?.time?.let { view.setReferenceTime(it) }
        })
    }
}

@SuppressLint("SetJavaScriptEnabled")
@BindingAdapter("loadWebsite")
fun loadWebsite(view: WebView, url: String?) {
    view.settings.javaScriptEnabled = true
    view.webChromeClient = WebChromeClient()
    view.webViewClient = WebViewClient()
    url?.let {
        view.loadUrl(it)
    }
}



