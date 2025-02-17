package com.example.principalApp

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeightTotal = displayMetrics.heightPixels
        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
        val textTittle = findViewById<TextView>(R.id.textViewRegister1)
        val textInitInf = findViewById<TextView>(R.id.textViewRegister2)
        val textInformation1 = findViewById<TextView>(R.id.textViewRegister3)
        val textInformation2 = findViewById<TextView>(R.id.textViewRegister4)
        val textInformation3 = findViewById<TextView>(R.id.textViewRegister5)
        val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
        val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
        // val logoRegister = findViewById<ImageView>(R.id.logoRegister)
        // Set Height Views
        UtilsFunctions.setViewHeightPercentageLayout(
                parentLayoutWave,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 20f
                else if (screenHeightTotal > 1500) 15f
                else if (screenHeightTotal > 1000) 20f else 10f
        )
        UtilsFunctions.setViewHeightPercentageFrame(
                frameLayoutAnimation,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 30f
                else if (screenHeightTotal > 1500) 25f
                else if (screenHeightTotal > 1000) 20f else 20f
        )
        UtilsFunctions.setViewHeightPercentageImage(
                buttonExit,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 3f
                else if (screenHeightTotal > 1500) 3.5f
                else if (screenHeightTotal > 1000) 4.5f else 4.5f
        )
        buttonExit.translationY =
                if (screenHeightTotal > 2000) 50f
                else if (screenHeightTotal > 1500) 0f
                else if (screenHeightTotal > 1000) -10f else -10f
        buttonContinue.translationY = 
                if (screenHeightTotal > 2000) -140f
                else if (screenHeightTotal > 1500) -20f
                else if (screenHeightTotal > 1000) -40f else -40f
        textTittle.translationY = 
                if (screenHeightTotal > 2000) 50f
                else if (screenHeightTotal > 1500) 10f
                else if (screenHeightTotal > 1000) -10f else -10f
        UtilsFunctions.setViewFontPercentageTextView(
                textTittle,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 7f
                else if (screenHeightTotal > 1500) 7f
                else if (screenHeightTotal > 1000) 6.5f else 6.5f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textInitInf,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 5.5f
                else if (screenHeightTotal > 1500) 4.5f
                else if (screenHeightTotal > 1000) 4f else 4f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textInformation1,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 4f
                else if (screenHeightTotal > 1500) 4.5f
                else if (screenHeightTotal > 1000) 4f else 4f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textInformation2,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 4f
                else if (screenHeightTotal > 1500) 4.5f
                else if (screenHeightTotal > 1000) 4f else 4f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textInformation3,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 4f
                else if (screenHeightTotal > 1500) 4.5f
                else if (screenHeightTotal > 1000) 4f else 4f
        )
        // Set Width Views
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)
        // UtilsFunctions.setViewWidthPercentageImage(logoRegister,parentLayoutPrincipal,70f)
        buttonContinue.setOnClickListener {
            val intent = Intent(this, RegisterActivity2::class.java)
            startActivity(intent)
            overridePendingTransition(
                    R.drawable.animate_activity_right,
                    R.drawable.animate_activity_left
            )
        }
        buttonExit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(
                    R.drawable.animate_activity_out_left,
                    R.drawable.animate_activity_out_right
            )
            finish()
        }
    }
}
