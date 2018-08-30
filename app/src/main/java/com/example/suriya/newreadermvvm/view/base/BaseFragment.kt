package com.example.suriya.newreadermvvm.view.base

import android.app.ProgressDialog
import android.support.v4.app.Fragment

open class BaseFragment : Fragment() {

    private var dialog: ProgressDialog? = null

    fun showDialog(message: String) {
        dialog?.dismiss()

        dialog = ProgressDialog(context)
        dialog?.let {
            it.setMessage(message)
            it.show()
        }
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }
}