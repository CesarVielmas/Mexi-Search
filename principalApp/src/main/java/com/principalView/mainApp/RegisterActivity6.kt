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

class RegisterActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_six)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("username","")
        val birthdate = sharedPreferences.getString("birthdate","")
        val password = sharedPreferences.getString("password","")
        val userRegister = sharedPreferences.getString("userRegister","")
        
        val editTextUserName = findViewById<EditText>(R.id.editTextUserName)
        val textViewUserName = findViewById<TextView>(R.id.textViewName)
        val layoutUserName = findViewById<LinearLayout>(R.id.linearLayoutName)
        val editTextBirthDate = findViewById<EditText>(R.id.editTextBirthDate)
        val textViewBirthDate = findViewById<TextView>(R.id.textViewDate)
        val layoutBirthDate = findViewById<LinearLayout>(R.id.linearLayoutDate)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val textViewPassword = findViewById<TextView>(R.id.textViewPassword)
        val layoutPassword = findViewById<LinearLayout>(R.id.linearLayoutPassword)
        val editTextUserRegister = findViewById<EditText>(R.id.editTextUserRegister)
        val textViewRegister = findViewById<TextView>(R.id.textViewRegister)
        val layoutRegister = findViewById<LinearLayout>(R.id.linearLayoutRegister)

        editTextUserName.setText(username)
        editTextBirthDate.setText(birthdate)
        editTextPassword.setText(password)
        editTextUserRegister.setText(userRegister)

        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
        val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
        val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
        val layoutContinue = findViewById<LinearLayout>(R.id.layoutButtonContinue)
        UtilsFunctions.setViewWidthPercentageEditText(editTextUserName,layoutUserName,90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewUserName, layoutUserName, 53f)
        UtilsFunctions.setViewWidthPercentageEditText(editTextBirthDate,layoutBirthDate,90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewBirthDate, layoutBirthDate, 53f)
        UtilsFunctions.setViewWidthPercentageEditText(editTextPassword,layoutPassword,90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewPassword, layoutPassword, 53f)
        UtilsFunctions.setViewWidthPercentageEditText(editTextUserRegister,layoutRegister,90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewRegister, layoutRegister, 53f)
        UtilsFunctions.setViewHeightPercentageLayout(parentLayoutWave, parentLayoutPrincipal, 15f)
        UtilsFunctions.setViewHeightPercentageFrame(frameLayoutAnimation, parentLayoutPrincipal, 25f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)
        //mandarlo al menu principal pero despues de un aviso de que si desea regresar y perder los datos guardados
        buttonExit.setOnClickListener {
            val dialog = ModalWindowExit { variableBoolean ->
               if(variableBoolean){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.drawable.animate_activity_out_left, R.drawable.animate_activity_out_right)
                finish()
               }
            }
            dialog.show(supportFragmentManager, "ModalWindowExit")
        }
        //Mandarlo a la aplicacion pantalla de inicio pero con el aviso de que si desea confirmar y si es asi entonces ahora otra nueva pestana para el codigo de verificacion al correo o telefono SMS dependiendo de lo elegido , el cual va a poder saltar pero lo pedira dentro de la app si desea proseguir
        buttonContinue.setOnClickListener {
            val dialog = ModalWindowConfirm { variableBoolean ->
                if(variableBoolean){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
             }
             dialog.show(supportFragmentManager, "ModalWindowConfirm")
        }
    }
}
