package com.example.principalApp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import java.time.LocalDate
import java.time.Period

class RegisterActivity3 : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                supportActionBar?.hide()
                setContentView(R.layout.register_activity_third)
                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)
                val screenHeightTotal = displayMetrics.heightPixels
                val parentLayoutPrincipal =
                        findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
                val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
                val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
                val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
                val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
                val linearLayoutName = findViewById<LinearLayout>(R.id.linearLayoutName)
                val relativeLayoutPicker = findViewById<RelativeLayout>(R.id.relativeDatePicker)
                val editTextName = findViewById<EditText>(R.id.inputTextName)
                val textTittle = findViewById<TextView>(R.id.textViewRegister1)
                val textViewName = findViewById<TextView>(R.id.textViewName)
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
                UtilsFunctions.setViewHeightPercentageRelativeLayout(
                        relativeLayoutPicker,
                        parentLayoutPrincipal,
                        if (screenHeightTotal > 2500) 65f
                        else if (screenHeightTotal > 2000) 65f
                        else if (screenHeightTotal > 1500) 60f
                        else if (screenHeightTotal > 1000) 55f else 50f
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
                        if (screenHeightTotal > 2500) -35f
                        else if (screenHeightTotal > 2000) -20f
                        else if (screenHeightTotal > 1500) -30f
                        else if (screenHeightTotal > 1000) -25f else -20f
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
                UtilsFunctions.setViewWidthPercentageEditText(editTextName, linearLayoutName, 90f)
                UtilsFunctions.setViewWidthPercentageTextView(textViewName, linearLayoutName, 64f)
                UtilsFunctions.setViewWidthPercentageButton(
                        buttonContinue,
                        parentLayoutPrincipal,
                        65f
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
                        val intent = Intent(this, RegisterActivity2::class.java)
                        startActivity(intent)
                        overridePendingTransition(
                                R.drawable.animate_activity_out_left,
                                R.drawable.animate_activity_out_right
                        )
                        finish()
                }
                buttonContinue.setOnClickListener {
                        if (editTextName.text.toString().isNotEmpty()) {
                                val fechaNac =
                                        editTextName
                                                .text
                                                .toString()
                                                .split("/")
                                                .last()
                                                .trim()
                                                .toInt()
                                val age =
                                        Period.between(
                                                        LocalDate.of(fechaNac, 1, 1),
                                                        LocalDate.now()
                                                )
                                                .years
                                if (age <= 17 || age >= 100) {
                                        val dialog = ModalWindow2()
                                        dialog.show(supportFragmentManager, "ModelWindow2")
                                } else {
                                        val sharedPreferences =
                                                getSharedPreferences("MyPrefs", MODE_PRIVATE)
                                        val editor = sharedPreferences.edit()
                                        editor.putString("birthdate", editTextName.text.toString())
                                        editor.apply()
                                        val intent = Intent(this, RegisterActivity4::class.java)
                                        startActivity(intent)
                                        overridePendingTransition(
                                                R.drawable.animate_activity_right,
                                                R.drawable.animate_activity_left
                                        )
                                }
                        }
                }

                val composeView: ComposeView = findViewById(R.id.composeDatePicker)
                composeView.setContent {
                        DatePickerComponent(
                                onDateSelected = { selectedDate ->
                                        editTextName.setText(selectedDate)
                                },
                                screenHeightTotal = screenHeightTotal
                        )
                }
        }
}
