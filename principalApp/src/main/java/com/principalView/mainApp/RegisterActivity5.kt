package com.example.principalApp

import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

class RegisterActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_fifth)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeightTotal = displayMetrics.heightPixels
        var changeToPhone = false
        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
        val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
        val linearLayoutName = findViewById<LinearLayout>(R.id.linearLayoutName)
        val editTextName = findViewById<EditText>(R.id.inputTextName)
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
        val layoutContinue = findViewById<LinearLayout>(R.id.layoutButtonContinue)
        val layoutChangePhone = findViewById<LinearLayout>(R.id.linearLayouPhone)
        val textViewChangePhone = findViewById<TextView>(R.id.textViewChangePhone)
        val textTittle = findViewById<TextView>(R.id.textViewRegister1)
        val imageViewCorrect = findViewById<ImageView>(R.id.imageViewCorrect)
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
        UtilsFunctions.setViewWidthPercentageImage(
                imageViewCorrect,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 7f
                else if (screenHeightTotal > 2000) 6.5f
                else if (screenHeightTotal > 1500) 4.5f
                else if (screenHeightTotal > 1000) 6f else 6f
        )
        imageViewCorrect.translationX =
                if (screenHeightTotal > 2500) 50f
                else if (screenHeightTotal > 2000) 35f
                else if (screenHeightTotal > 1500) 0f
                else if (screenHeightTotal > 1000) -35f else -35f
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
        UtilsFunctions.setViewWidthPercentageTextView(textViewName, linearLayoutName, 53f)
        UtilsFunctions.setViewWidthPercentageLayout(layoutChangePhone, parentLayoutPrincipal, 90f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)

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

        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        val phoneRegex = "^[+]?[(]?[0-9]{1,4}[)]?[-\\s./0-9]*$".toRegex()
        buttonExit.setOnClickListener {
            val intent = Intent(this, RegisterActivity4::class.java)
            startActivity(intent)
            overridePendingTransition(
                    R.drawable.animate_activity_out_left,
                    R.drawable.animate_activity_out_right
            )
            finish()
        }
        buttonContinue.setOnClickListener {
            if (changeToPhone) {
                if (editTextName.text.toString().length == 0) {
                    val dialog = ModalWindow4()
                    dialog.setVariable(0)
                    dialog.show(supportFragmentManager, "ModelWindow4")
                } else if (phoneRegex.matches(editTextName.text.toString())) {
                    val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("userRegister", editTextName.text.toString())
                    editor.apply()
                    val intent = Intent(this, RegisterActivity6::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                            R.drawable.animate_activity_right,
                            R.drawable.animate_activity_left
                    )
                } else {
                    val dialog = ModalWindow4()
                    dialog.setVariable(1)
                    dialog.show(supportFragmentManager, "ModelWindow4")
                }
            } else {
                if (editTextName.text.toString().length == 0) {
                    val dialog = ModalWindow4()
                    dialog.setVariable(2)
                    dialog.show(supportFragmentManager, "ModelWindow4")
                } else if (emailRegex.matches(editTextName.text.toString())) {
                    val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("userRegister", editTextName.text.toString())
                    editor.apply()
                    val intent = Intent(this, RegisterActivity6::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                            R.drawable.animate_activity_right,
                            R.drawable.animate_activity_left
                    )
                } else {
                    val dialog = ModalWindow4()
                    dialog.setVariable(3)
                    dialog.show(supportFragmentManager, "ModelWindow4")
                }
            }
        }
        textViewChangePhone.setOnClickListener {
            if (!changeToPhone) {
                textViewName.text = getString(R.string.register_tittle_phone)
                editTextName.hint = getString(R.string.register_holder_phone)
                textViewChangePhone.text = getString(R.string.register_change_mail)
            } else {
                textViewName.text = getString(R.string.register_tittle_mail)
                editTextName.hint = getString(R.string.register_holder_mail)
                textViewChangePhone.text = getString(R.string.register_change_phone)
            }
            changeToPhone = !changeToPhone
            if (editTextName.text.length == 0) {
                imageViewCorrect.setImageResource(R.mipmap.check_password_empty)
            } else if (changeToPhone && phoneRegex.matches(editTextName.text)) {
                imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
            } else if (!changeToPhone && emailRegex.matches(editTextName.text)) {
                imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
            } else {
                imageViewCorrect.setImageResource(R.mipmap.check_password_incorrect)
            }
        }
        editTextName.addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        val inputText = s.toString()
                        if (inputText.length == 0) {
                            imageViewCorrect.setImageResource(R.mipmap.check_password_empty)
                        } else if (changeToPhone && phoneRegex.matches(inputText)) {
                            imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
                        } else if (!changeToPhone && emailRegex.matches(inputText)) {
                            imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
                        } else {
                            imageViewCorrect.setImageResource(R.mipmap.check_password_incorrect)
                        }
                    }
                    override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                    ) {
                        // Esta función se llama justo antes de que el texto cambie
                    }

                    override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                    ) {
                        // Esta función se llama mientras el texto está cambiando
                    }
                }
        )
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
                                            if (screenHeightTotal > 2500) 110
                                            else if (screenHeightTotal > 2000) 100
                                            else if (screenHeightTotal > 1500) 110
                                            else if (screenHeightTotal > 1000) -30 else -30,
                                            parentLayoutPrincipal.context
                                    )
                            layoutContinue.layoutParams = params
                        } else {
                            val params = layoutContinue.layoutParams as LinearLayout.LayoutParams
                            params.topMargin =
                                    UtilsFunctions.dpToPx(
                                            if (screenHeightTotal > 2500) 370
                                            else if (screenHeightTotal > 2000) 400
                                            else if (screenHeightTotal > 1500) 362
                                            else if (screenHeightTotal > 1000) 240 else 220,
                                            parentLayoutPrincipal.context
                                    )
                            layoutContinue.layoutParams = params
                        }
                    }
                }
        )
    }
}
