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

class RegisterActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_fifth)
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
        val imageViewCorrect = findViewById<ImageView>(R.id.imageViewCorrect)
        UtilsFunctions.setViewWidthPercentageEditText(editTextName,linearLayoutName,90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewName, linearLayoutName, 53f)
        UtilsFunctions.setViewHeightPercentageLayout(parentLayoutWave, parentLayoutPrincipal, 15f)
        UtilsFunctions.setViewWidthPercentageLayout(layoutChangePhone, parentLayoutPrincipal, 90f)
        UtilsFunctions.setViewHeightPercentageFrame(frameLayoutAnimation, parentLayoutPrincipal, 25f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)
        buttonExit.setOnClickListener {
            val intent = Intent(this, RegisterActivity4::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.animate_activity_out_left, R.drawable.animate_activity_out_right)
            finish()
        }
        buttonContinue.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("userRegister", editTextName.text.toString())
            editor.apply()
            val intent = Intent(this, RegisterActivity6::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.animate_activity_right, R.drawable.animate_activity_left)
        }
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        val phoneRegex = "^[+]?[(]?[0-9]{1,4}[)]?[-\\s./0-9]*$".toRegex()
        textViewChangePhone.setOnClickListener {
            if(!changeToPhone){
                textViewName.text = getString(R.string.register_tittle_phone)
                editTextName.hint = getString(R.string.register_holder_phone)
                textViewChangePhone.text = getString(R.string.register_change_mail)
            }
            else{
                textViewName.text = getString(R.string.register_tittle_mail)
                editTextName.hint = getString(R.string.register_holder_mail)
                textViewChangePhone.text = getString(R.string.register_change_phone)
            }
            changeToPhone = !changeToPhone
            if(editTextName.text.length == 0){
                imageViewCorrect.setImageResource(R.mipmap.check_password_empty)
            }
            else if(changeToPhone && phoneRegex.matches(editTextName.text)){
                imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
            }
            else if(!changeToPhone && emailRegex.matches(editTextName.text)){
                imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
            }
            else{
                imageViewCorrect.setImageResource(R.mipmap.check_password_incorrect)
            }
        }
        editTextName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
                if(inputText.length == 0){
                    imageViewCorrect.setImageResource(R.mipmap.check_password_empty)
                }
                else if(changeToPhone && phoneRegex.matches(inputText)){
                    imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
                }
                else if(!changeToPhone && emailRegex.matches(inputText)){
                    imageViewCorrect.setImageResource(R.mipmap.check_password_correct)
                }
                else{
                    imageViewCorrect.setImageResource(R.mipmap.check_password_incorrect)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Esta función se llama justo antes de que el texto cambie
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Esta función se llama mientras el texto está cambiando
            }
        })
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
                    params.topMargin = UtilsFunctions.dpToPx(110,parentLayoutPrincipal.context) 
                    layoutContinue.layoutParams = params
                } else {
                    val params = layoutContinue.layoutParams as LinearLayout.LayoutParams
                    params.topMargin = UtilsFunctions.dpToPx(362,parentLayoutPrincipal.context) 
                    layoutContinue.layoutParams = params
                }
            }
        })
    }
}