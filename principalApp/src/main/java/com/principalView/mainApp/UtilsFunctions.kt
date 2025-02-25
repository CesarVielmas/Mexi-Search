package com.example.principalApp

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView

object UtilsFunctions {
    fun getScreenWidth(context: Context): Int {
        val displayMetrics = DisplayMetrics()
        (context as AppCompatActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
    fun dpToPx(dp: Int, context: Context): Int {
        return TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        dp.toFloat(),
                        context.resources.displayMetrics
                )
                .toInt()
    }
    fun getScreenHeight(context: Context): Int {
        val displayMetrics = DisplayMetrics()
        (context as AppCompatActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / context.resources.displayMetrics.density
    }

    fun setViewWidthPercentageEditText(
            view: EditText,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenWidth = getScreenWidth(view.context)
        val widthInPx = (screenWidth * (percentage / 100)).toInt()
        val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.width = widthInPx
        view.layoutParams = params
    }

    fun setViewWidthPercentageTextView(
            view: TextView,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenWidth = getScreenWidth(view.context)
        val widthInPx = (screenWidth * (percentage / 100)).toInt()
        val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.width = widthInPx
        view.layoutParams = params
    }
    fun setViewFontPercentageTextView(
            view: TextView,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenWidth = getScreenWidth(view.context)
        val fontInSp =
                (screenWidth * (percentage / 100)) / view.resources.displayMetrics.scaledDensity
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontInSp)
    }
    fun setViewWidthPercentageButton(view: Button, parentLayout: LinearLayout, percentage: Float) {
        val screenWidth = getScreenWidth(view.context)
        val widthInPx = (screenWidth * (percentage / 100)).toInt()
        val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.width = widthInPx
        view.layoutParams = params
    }
    fun setViewHeightPercentageButton(view: Button, parentLayout: LinearLayout, percentage: Float) {
        val screenHeight = getScreenHeight(view.context)
        val heightInPx = (screenHeight * (percentage / 100)).toInt()
        val params = view.layoutParams
        params.height = heightInPx
        view.layoutParams = params
    }
    fun setViewWidthPercentageImage(
            view: ImageView,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenWidth = getScreenWidth(view.context)
        val widthInPx = (screenWidth * (percentage / 100)).toInt()
        val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.width = widthInPx
        view.layoutParams = params
    }
    fun setViewHeightPercentageImage(
            view: ImageView,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenHeight = getScreenHeight(view.context)
        val heightInPx = (screenHeight * (percentage / 100)).toInt()
        val params = view.layoutParams
        params.height = heightInPx
        view.layoutParams = params
    }
    fun setViewWidthPercentageLayout(
            view: LinearLayout,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenWidth = getScreenWidth(view.context)
        val widthInPx = (screenWidth * (percentage / 100)).toInt()
        val widthInDp = convertPixelsToDp(widthInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.width = widthInPx
        view.layoutParams = params
    }

    fun setViewHeightPercentageLayout(
            view: LinearLayout,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenHeight = getScreenHeight(view.context)
        val heightInPx = (screenHeight * (percentage / 100)).toInt()
        val heightInDp = convertPixelsToDp(heightInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.height = heightInPx
        view.layoutParams = params
    }

    fun setViewHeightPercentageFrame(
            view: FrameLayout,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenHeight = getScreenHeight(view.context)
        val heightInPx = (screenHeight * (percentage / 100)).toInt()
        val heightInDp = convertPixelsToDp(heightInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.height = heightInPx
        view.layoutParams = params
    }
    fun setViewHeightPercentageComposeView(
            view: ComposeView,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenHeight = getScreenHeight(view.context)
        val heightInPx = (screenHeight * (percentage / 100)).toInt()
        val params = view.layoutParams
        params.height = heightInPx
        view.layoutParams = params
    }
    fun setViewHeightPercentageRelativeLayout(
            view: RelativeLayout,
            parentLayout: LinearLayout,
            percentage: Float
    ) {
        val screenHeight = getScreenHeight(view.context)
        val heightInPx = (screenHeight * (percentage / 100)).toInt()
        val heightInDp = convertPixelsToDp(heightInPx.toFloat(), view.context)
        val params = view.layoutParams
        params.height = heightInPx
        view.layoutParams = params
    }
}
