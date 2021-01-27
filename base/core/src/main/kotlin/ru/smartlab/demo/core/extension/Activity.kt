package ru.smartlab.demo.core.extension

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val focus = this.currentFocus
    focus?.let {
        (getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
            focus.windowToken,
            0
        )
    }
}

fun Activity.isKeyboardOpen(): Boolean {
    val rootView = findViewById<View>(android.R.id.content)
    val visibleBounds = Rect()
    rootView.getWindowVisibleDisplayFrame(visibleBounds)
    val heightDiff = rootView.height - visibleBounds.height()
    val marginOfError = convertDpToPx(this, 50)

    return heightDiff > marginOfError
}

fun Activity.isKeyboardClosed(): Boolean {
    return this.isKeyboardOpen().not()
}


fun convertPxToDp(context: Context, px: Int): Int {
    val scale = context.resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}

fun convertDpToPx(context: Context, dp: Int): Int {
    val scale = context.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun convertSpToPx(context: Context, sp: Int): Int {
    return sp * context.resources.displayMetrics.scaledDensity.toInt()
}