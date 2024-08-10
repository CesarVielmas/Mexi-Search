package com.example.principalApp

import android.os.Bundle
import android.graphics.Rect
import android.view.ViewTreeObserver
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
import android.text.Editable
import android.text.TextWatcher
import android.text.InputType

class RegisterActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_fourth)
        var viewPassword = false
        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
        val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
        val linearLayoutName = findViewById<LinearLayout>(R.id.linearLayoutName)
        val editTextName = findViewById<EditText>(R.id.inputTextName)
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
        val layoutContinue = findViewById<LinearLayout>(R.id.layoutButtonContinue)
        val layoutWarning = findViewById<LinearLayout>(R.id.layoutWarning)
        val imageViewPassword = findViewById<ImageView>(R.id.imageViewPassword)
        val textViewPassword = findViewById<TextView>(R.id.textViewPassword)
        val imageViewEye = findViewById <ImageView>(R.id.imageViewEye)
        UtilsFunctions.setViewWidthPercentageEditText(editTextName,linearLayoutName,90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewName, linearLayoutName, 53f)
        UtilsFunctions.setViewHeightPercentageLayout(parentLayoutWave, parentLayoutPrincipal, 15f)
        UtilsFunctions.setViewWidthPercentageLayout(layoutWarning, parentLayoutPrincipal, 90f)
        UtilsFunctions.setViewHeightPercentageFrame(frameLayoutAnimation, parentLayoutPrincipal, 25f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)
        buttonExit.setOnClickListener {
            val intent = Intent(this, RegisterActivity3::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.animate_activity_out_left, R.drawable.animate_activity_out_right)
            finish()
        }
        buttonContinue.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("password", editTextName.text.toString())
            editor.apply()
            val intent = Intent(this, RegisterActivity5::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.animate_activity_right, R.drawable.animate_activity_left)
        }
        imageViewEye.setOnClickListener {
            if(!viewPassword){
                editTextName.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                imageViewEye.setImageResource(R.mipmap.password_view)
            }
            else{
                editTextName.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                imageViewEye.setImageResource(R.mipmap.password_not_view)
            }
           viewPassword = !viewPassword
        }
        editTextName.setOnFocusChangeListener { _, hasFocus ->
            val valueInDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                0.91f,
                resources.displayMetrics
            ).toInt()
            val background = textViewName.background as GradientDrawable
            if (hasFocus) {
                background.setStroke(valueInDp, Color.parseColor("#576F92"))
                textViewName.setTextColor(Color.parseColor("#576F92"))
            } else {
                background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
                textViewName.setTextColor(Color.parseColor("#939393"))
            }
        }
        parentLayoutPrincipal.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val rect = Rect()
                parentLayoutPrincipal.getWindowVisibleDisplayFrame(rect)
                val screenHeight = parentLayoutPrincipal.rootView.height
                val keypadHeight = screenHeight - rect.bottom

                if (keypadHeight > screenHeight * 0.15) {
                    val params = layoutContinue.layoutParams as LinearLayout.LayoutParams
                    params.topMargin = UtilsFunctions.dpToPx(84,parentLayoutPrincipal.context) 
                    layoutContinue.layoutParams = params
                } else {
                    val params = layoutContinue.layoutParams as LinearLayout.LayoutParams
                    params.topMargin = UtilsFunctions.dpToPx(340,parentLayoutPrincipal.context) 
                    layoutContinue.layoutParams = params
                }
            }
        })
        editTextName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
                if (inputText.length == 0) {
                    imageViewPassword.setImageResource(R.mipmap.check_password_empty)
                    textViewPassword.text = getString(R.string.register_warning_password_empty)
                }
                else if(inputText.length <= 7){
                    imageViewPassword.setImageResource(R.mipmap.check_password_incorrect)
                    textViewPassword.text = getString(R.string.register_warning_password_incorrect)
                }
                else{
                    imageViewPassword.setImageResource(R.mipmap.check_password_correct)
                    textViewPassword.text = getString(R.string.register_warning_password_correct)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Esta función se llama justo antes de que el texto cambie
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Esta función se llama mientras el texto está cambiando
            }
        })

    }
}