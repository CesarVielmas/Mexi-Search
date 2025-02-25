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
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_six)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeightTotal = displayMetrics.heightPixels
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")
        val birthdate = sharedPreferences.getString("birthdate", "")
        val password = sharedPreferences.getString("password", "")
        val userRegister = sharedPreferences.getString("userRegister", "")

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
        val textTittle = findViewById<TextView>(R.id.textViewRegister1)
        val textRegisterTittle = findViewById<TextView>(R.id.textViewRegister2)
        val layoutRegister = findViewById<LinearLayout>(R.id.linearLayoutRegister)
        val valueInDp =
                TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                0.91f,
                                resources.displayMetrics
                        )
                        .toInt()
        var background = textViewUserName.background as GradientDrawable
        background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
        textViewUserName.setTextColor(Color.parseColor("#939393"))
        background = textViewBirthDate.background as GradientDrawable
        background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
        textViewBirthDate.setTextColor(Color.parseColor("#939393"))
        background = textViewPassword.background as GradientDrawable
        background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
        textViewPassword.setTextColor(Color.parseColor("#939393"))
        background = textViewRegister.background as GradientDrawable
        background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
        textViewRegister.setTextColor(Color.parseColor("#939393"))
        if (userRegister.toString().trim().matches(Regex("^\\d+$"))) {
            textViewRegister.text = "NUMERO TELEFONICO"
        }
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
                textRegisterTittle,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2000) 6f
                else if (screenHeightTotal > 2500) 6f
                else if (screenHeightTotal > 1500) 5.5f
                else if (screenHeightTotal > 1000) 5f else 5f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textViewUserName,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 3.5f
                else if (screenHeightTotal > 2000) 3.3f
                else if (screenHeightTotal > 1500) 3.2f
                else if (screenHeightTotal > 1000) 3f else 3f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textViewBirthDate,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 3.5f
                else if (screenHeightTotal > 2000) 3.3f
                else if (screenHeightTotal > 1500) 3.2f
                else if (screenHeightTotal > 1000) 3f else 3f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textViewPassword,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 3.5f
                else if (screenHeightTotal > 2000) 3.3f
                else if (screenHeightTotal > 1500) 3.2f
                else if (screenHeightTotal > 1000) 3f else 3f
        )
        UtilsFunctions.setViewFontPercentageTextView(
                textViewRegister,
                parentLayoutPrincipal,
                if (screenHeightTotal > 2500) 3.5f
                else if (screenHeightTotal > 2000) 3.3f
                else if (screenHeightTotal > 1500) 3.2f
                else if (screenHeightTotal > 1000) 3f else 3f
        )
        UtilsFunctions.setViewWidthPercentageEditText(editTextUserName, layoutUserName, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewUserName, layoutUserName, 53f)
        UtilsFunctions.setViewWidthPercentageEditText(editTextBirthDate, layoutBirthDate, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewBirthDate, layoutBirthDate, 53f)
        UtilsFunctions.setViewWidthPercentageEditText(editTextPassword, layoutPassword, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewPassword, layoutPassword, 53f)
        UtilsFunctions.setViewWidthPercentageEditText(editTextUserRegister, layoutRegister, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewRegister, layoutRegister, 53f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)
        // mandarlo al menu principal pero despues de un aviso de que si desea regresar y perder los
        // datos guardados
        buttonExit.setOnClickListener {
            val dialog = ModalWindowExit { variableBoolean ->
                if (variableBoolean) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                            R.drawable.animate_activity_out_left,
                            R.drawable.animate_activity_out_right
                    )
                    finish()
                }
            }
            dialog.show(supportFragmentManager, "ModalWindowExit")
        }
        // Mandarlo a la aplicacion pantalla de inicio pero con el aviso de que si desea confirmar y
        // si es asi entonces ahora otra nueva pestana para el codigo de verificacion al correo o
        // telefono SMS dependiendo de lo elegido , el cual va a poder saltar pero lo pedira dentro
        // de la app si desea proseguir
        buttonContinue.setOnClickListener {
            val dialog = ModalWindowConfirm { variableBoolean ->
                if (variableBoolean) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            dialog.show(supportFragmentManager, "ModalWindowConfirm")
        }
    }
}
