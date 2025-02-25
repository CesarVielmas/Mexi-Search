package com.example.principalApp

import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_second)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeightTotal = displayMetrics.heightPixels
        val textTittle = findViewById<TextView>(R.id.textViewRegister1)
        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
        val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
        val linearLayoutName = findViewById<LinearLayout>(R.id.linearLayoutName)
        val editTextName = findViewById<EditText>(R.id.inputTextName)
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
        val layoutContinue = findViewById<LinearLayout>(R.id.layoutButtonContinue)
        UtilsFunctions.setViewWidthPercentageEditText(editTextName, linearLayoutName, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewName, linearLayoutName, 42f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)
        // Set Height Views
        UtilsFunctions.setViewHeightPercentageLayout(
                parentLayoutWave,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 20f
                else if (screenHeightTotal > 2000) 20f
                else if (screenHeightTotal > 1500) 20f
                else if (screenHeightTotal > 1000) 20f else 10f
        )
        UtilsFunctions.setViewHeightPercentageFrame(
                frameLayoutAnimation,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 20f
                else if (screenHeightTotal > 2000) 20f
                else if (screenHeightTotal > 1500) 25f
                else if (screenHeightTotal > 1000) 20f else 20f
        )
        UtilsFunctions.setViewHeightPercentageImage(
                buttonExit,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 3.3f
                else if (screenHeightTotal > 2000) 3.3f
                else if (screenHeightTotal > 1500) 3.8f
                else if (screenHeightTotal > 1000) 4.5f else 4.5f
        )
        buttonExit.translationY =
                if (screenHeightTotal > 2500) 75f
                else if (screenHeightTotal > 2000) 60f
                else if (screenHeightTotal > 1500) 70f
                else if (screenHeightTotal > 1000) -10f else -10f
        buttonContinue.translationY =
                if (screenHeightTotal > 2500) -100f
                else if (screenHeightTotal > 2000) -160f
                else if (screenHeightTotal > 1500) -30f
                else if (screenHeightTotal > 1000) -80f else -60f
        textTittle.translationY =
                if (screenHeightTotal > 2500) 75f
                else if (screenHeightTotal > 2000) 60f
                else if (screenHeightTotal > 1500) 80f
                else if (screenHeightTotal > 1000) 0f else -10f
        UtilsFunctions.setViewFontPercentageTextView(
                textTittle,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 7f
                else if (screenHeightTotal > 2000) 7f
                else if (screenHeightTotal > 1500) 7f
                else if (screenHeightTotal > 1000) 6.5f else 6.5f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textViewName,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 3.5f
                else if (screenHeightTotal > 2000) 3.3f
                else if (screenHeightTotal > 1500) 3.2f
                else if (screenHeightTotal > 1000) 3f else 3f
        )
        val valueInDp =
                TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                0.91f,
                                resources.displayMetrics
                        )
                        .toInt()
        var background = textViewName.background as GradientDrawable
        background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
        textViewName.setTextColor(Color.parseColor("#939393"))

        buttonExit.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(
                    R.drawable.animate_activity_out_left,
                    R.drawable.animate_activity_out_right
            )
            finish()
        }
        buttonContinue.setOnClickListener {
            if (editTextName.text.toString() == "") {
                val dialog = ModalWindow1()
                dialog.show(supportFragmentManager, "ModelWindow1")
            } else {
                val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("username", editTextName.text.toString())
                editor.apply()
                val intent = Intent(this, RegisterActivity3::class.java)
                startActivity(intent)
                overridePendingTransition(
                        R.drawable.animate_activity_right,
                        R.drawable.animate_activity_left
                )
            }
        }
        editTextName.setOnFocusChangeListener { _, hasFocus ->
            val valueInDp =
                    TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_DIP,
                                    0.91f,
                                    resources.displayMetrics
                            )
                            .toInt()
            val background = textViewName.background as GradientDrawable
            if (hasFocus) {
                background.setStroke(valueInDp, Color.parseColor("#576F92"))
                textViewName.setTextColor(Color.parseColor("#576F92"))
            } else {
                background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
                textViewName.setTextColor(Color.parseColor("#939393"))
            }
        }
        parentLayoutPrincipal.viewTreeObserver.addOnGlobalLayoutListener(
                object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        val rect = Rect()
                        parentLayoutPrincipal.getWindowVisibleDisplayFrame(rect)
                        val screenHeight = parentLayoutPrincipal.rootView.height
                        val keypadHeight = screenHeight - rect.bottom

                        if (keypadHeight > screenHeight * 0.15) {
                            val params = layoutContinue.layoutParams as LinearLayout.LayoutParams
                            params.topMargin =
                                    UtilsFunctions.dpToPx(
                                            if (screenHeightTotal > 2500) 165
                                            else if (screenHeightTotal > 2000) 190
                                            else if (screenHeightTotal > 1500) 110
                                            else if (screenHeightTotal > 1000) 20 else 15,
                                            parentLayoutPrincipal.context
                                    )
                            layoutContinue.layoutParams = params
                        } else {
                            val params = layoutContinue.layoutParams as LinearLayout.LayoutParams
                            params.topMargin =
                                    UtilsFunctions.dpToPx(
                                            if (screenHeightTotal > 2500) 425
                                            else if (screenHeightTotal > 2000) 450
                                            else if (screenHeightTotal > 1500) 362
                                            else if (screenHeightTotal > 1000) 270 else 250,
                                            parentLayoutPrincipal.context
                                    )
                            layoutContinue.layoutParams = params
                        }
                    }
                }
        )
    }
}
