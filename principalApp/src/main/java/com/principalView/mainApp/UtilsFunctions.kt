package com.example.principalApp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.util.DisplayMetrics
import android.widget.EditText
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.FrameLayout
import android.widget.Button
import android.widget.ImageView
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import androidx.core.content.ContextCompat
import android.os.Handler
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.content.Intent

object UtilsFunctions {
    fun getScreenWidth(context: Context): Int {
    val displayMetrics = DisplayMetrics()
    (context as AppCompatActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}
fun dpToPx(dp: Int,context:Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics).toInt()
}
fun getScreenHeight(context: Context): Int {
    val displayMetrics = DisplayMetrics()
    (context as AppCompatActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}

fun convertPixelsToDp(px: Float, context: Context): Float {
    return px / context.resources.displayMetrics.density
}

fun setViewWidthPercentageEditText(view: EditText, parentLayout: LinearLayout, percentage: Float) {
    val screenWidth = getScreenWidth(view.context)
    val widthInPx = (screenWidth * (percentage / 100)).toInt()
    val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.width = widthInPx
    view.layoutParams = params
}

fun setViewWidthPercentageTextView(view: TextView, parentLayout: LinearLayout, percentage: Float) {
    val screenWidth = getScreenWidth(view.context)
    val widthInPx = (screenWidth * (percentage / 100)).toInt()
    val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.width = widthInPx
    view.layoutParams = params
}

fun setViewWidthPercentageButton(view: Button, parentLayout: LinearLayout, percentage: Float) {
    val screenWidth = getScreenWidth(view.context)
    val widthInPx = (screenWidth * (percentage / 100)).toInt()
    val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.width = widthInPx
    view.layoutParams = params
}

fun setViewWidthPercentageImage(view: ImageView, parentLayout: LinearLayout, percentage: Float) {
    val screenWidth = getScreenWidth(view.context)
    val widthInPx = (screenWidth * (percentage / 100)).toInt()
    val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.width = widthInPx
    view.layoutParams = params
}

fun setViewWidthPercentageLayout(view: LinearLayout, parentLayout: LinearLayout, percentage: Float) {
    val screenWidth = getScreenWidth(view.context)
    val widthInPx = (screenWidth * (percentage / 100)).toInt()
    val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.width = widthInPx
    view.layoutParams = params
}

fun setViewHeightPercentageLayout(view: LinearLayout, parentLayout: LinearLayout, percentage: Float) {
    val screenHeight = getScreenHeight(view.context)
    val heightInPx = (screenHeight * (percentage / 100)).toInt()
    val heightInDp = convertPixelsToDp(heightInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.height = heightInPx
    view.layoutParams = params
}

fun setViewHeightPercentageFrame(view: FrameLayout, parentLayout: LinearLayout, percentage: Float) {
    val screenHeight = getScreenHeight(view.context)
    val heightInPx = (screenHeight * (percentage / 100)).toInt()
    val heightInDp = convertPixelsToDp(heightInPx.toFloat(), view.context)
    val params = view.layoutParams
    params.height = heightInPx
    view.layoutParams = params
}
}