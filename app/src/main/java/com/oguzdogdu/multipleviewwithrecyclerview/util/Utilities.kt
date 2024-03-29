package com.oguzdogdu.multipleviewwithrecyclerview.util

import android.app.Activity
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.snackbar.Snackbar
import com.oguzdogdu.multipleviewwithrecyclerview.R

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun SimpleDraweeView.loadImage(url: String?) {
    setImageURI(url)
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