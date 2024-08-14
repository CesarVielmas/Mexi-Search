package com.example.principalApp

import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.FrameLayout
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.ComposeView
import android.content.Intent
import android.widget.TextView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale
import java.time.Period


class RegisterActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.register_activity_third)

        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutRegisterParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWaveRegister)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)
        val buttonExit = findViewById<ImageView>(R.id.myImageViewExit)
        val buttonContinue = findViewById<Button>(R.id.buttonRegisterContinue)
        val linearLayoutName = findViewById<LinearLayout>(R.id.linearLayoutName)
        val editTextName = findViewById<EditText>(R.id.inputTextName)
        val textViewName = findViewById<TextView>(R.id.textViewName)

        UtilsFunctions.setViewWidthPercentageEditText(editTextName, linearLayoutName, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textViewName, linearLayoutName, 64f)
        UtilsFunctions.setViewHeightPercentageLayout(parentLayoutWave, parentLayoutPrincipal, 15f)
        UtilsFunctions.setViewHeightPercentageFrame(frameLayoutAnimation, parentLayoutPrincipal, 25f)
        UtilsFunctions.setViewWidthPercentageButton(buttonContinue, parentLayoutPrincipal, 65f)

        buttonExit.setOnClickListener {
            val intent = Intent(this, RegisterActivity2::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.animate_activity_out_left, R.drawable.animate_activity_out_right)
            finish()
        }
        buttonContinue.setOnClickListener {
            if(editTextName.text.toString().isNotEmpty()){
                val fechaNac = editTextName.text.toString().split("/").last().trim().toInt()
                val age = Period.between(LocalDate.of(fechaNac, 1, 1),LocalDate.now()).years
                if(age <= 17 || age >=100){
                    val dialog = ModalWindow2()
                    dialog.show(supportFragmentManager, "ModelWindow2")
                }
                else{
                    val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("birthdate", editTextName.text.toString())
                    editor.apply()
                    val intent = Intent(this, RegisterActivity4::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.animate_activity_right, R.drawable.animate_activity_left)
                }
            }
        }

        val composeView: ComposeView = findViewById(R.id.composeDatePicker)
        composeView.setContent {
            DatePickerComponent { selectedDate ->
                editTextName.setText(selectedDate)
            }
        }
    }
}
