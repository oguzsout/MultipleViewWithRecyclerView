package com.oguzdogdu.multipleviewwithrecyclerview.util

import android.app.Activity
import android.view.View
import androidx.annotation.Nullable
import com.google.android.material.snackbar.Snackbar
import com.oguzdogdu.multipleviewwithrecyclerview.R

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun setImageURI(@Nullable uriString: String?) {
    setImageURI(uriString)
}

fun Activity.snackbar(msg: String, action: (() -> Unit)? = null) {
    Snackbar.make(
        findViewById(android.R.id.content),
        msg,
        Snackbar.LENGTH_LONG
    ).also {
        it.setAction(
            getString(R.string.ok)
        ) { action?.invoke() }
    }.show()
}