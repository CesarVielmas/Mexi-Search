package com.example.principalApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.TypedValue
import android.widget.EditText
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.FrameLayout
import android.widget.Button
import android.widget.ImageView
import android.graphics.drawable.TransitionDrawable
import androidx.core.content.ContextCompat
import android.os.Handler
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.content.Intent

private val drawableIds = intArrayOf(
    R.mipmap.gift1,
    R.mipmap.gift2,
    R.mipmap.gift3,
    R.mipmap.gift4,
    R.mipmap.gift5
)
private val textIds = arrayOf(
    R.string.principal_tittle_login1,
    R.string.principal_tittle_login2,
    R.string.principal_tittle_login3,
    R.string.principal_tittle_login4,
    R.string.principal_tittle_login5
)

private var currentIndexText = 0
private lateinit var textViewTittle: TextView
private lateinit var imageAnimation: ImageView
private lateinit var textHandler: Handler
private lateinit var imageHandler: Handler

class MainActivity : AppCompatActivity() {
    private var isTextAnimating = false
    private var isImageAnimating = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        textViewTittle = findViewById(R.id.textView1)
        imageAnimation = findViewById(R.id.backgroundAnimation)
        textHandler = Handler()
        imageHandler = Handler()

        // Configuración de otros componentes
        val editText1 = findViewById<EditText>(R.id.inputText1)
        val editText2 = findViewById<EditText>(R.id.inputText2)
        val buttonSesion = findViewById<Button>(R.id.buttonView1)
        val buttonSesionGoogle = findViewById<Button>(R.id.buttonView2)
        val textView1 = findViewById<TextView>(R.id.textView3)
        val textView2 = findViewById<TextView>(R.id.textView4)
        val textRegister = findViewById<TextView>(R.id.textView5)
        val parentLayout = findViewById<LinearLayout>(R.id.linearLayout2)
        val parentLayoutImages = findViewById<LinearLayout>(R.id.linearLayoutImages)
        val parentLayoutPrincipal = findViewById<LinearLayout>(R.id.linearLayoutPrincipalParent)
        val parentLayoutWave = findViewById<LinearLayout>(R.id.linearLayoutWave)
        val frameLayoutAnimation = findViewById<FrameLayout>(R.id.frameLayoutContainer)

        textView1.translationY = 41f
        textView1.bringToFront()
        textView2.translationY = 245f
        textView2.bringToFront()

        UtilsFunctions.setViewWidthPercentageLayout(parentLayoutImages, parentLayout, 70f)
        UtilsFunctions.setViewWidthPercentageButton(buttonSesion, parentLayout, 70f)
        UtilsFunctions.setViewWidthPercentageButton(buttonSesionGoogle, parentLayout, 70f)
        UtilsFunctions.setViewWidthPercentageEditText(editText1, parentLayout, 90f)
        UtilsFunctions.setViewWidthPercentageEditText(editText2, parentLayout, 90f)
        UtilsFunctions.setViewWidthPercentageTextView(textView1, parentLayout, 42f)
        UtilsFunctions.setViewWidthPercentageTextView(textView2, parentLayout, 42f)
        UtilsFunctions.setViewHeightPercentageLayout(parentLayoutWave, parentLayoutPrincipal, 44f)
        UtilsFunctions.setViewHeightPercentageFrame(frameLayoutAnimation, parentLayoutPrincipal, 44f)

        editText1.setOnFocusChangeListener { _, hasFocus ->
            val valueInDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                0.91f,
                resources.displayMetrics
            ).toInt()
            val background = textView1.background as GradientDrawable
            if (hasFocus) {
                background.setStroke(valueInDp, Color.parseColor("#576F92"))
                textView1.setTextColor(Color.parseColor("#576F92"))
            } else {
                background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
                textView1.setTextColor(Color.parseColor("#939393"))
            }
        }
        editText2.setOnFocusChangeListener { _, hasFocus ->
            val valueInDp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                0.91f,
                resources.displayMetrics
            ).toInt()
            val background = textView2.background as GradientDrawable
            if (hasFocus) {
                background.setStroke(valueInDp, Color.parseColor("#576F92"))
                textView2.setTextColor(Color.parseColor("#576F92"))
            } else {
                background.setStroke(valueInDp, Color.parseColor("#D7D7D7"))
                textView2.setTextColor(Color.parseColor("#939393"))
            }
        }

        textRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.drawable.animate_activity_right, R.drawable.animate_activity_left)
        }
    }

    override fun onPause() {
        super.onPause()
        textHandler.removeCallbacksAndMessages(null)
        imageHandler.removeCallbacksAndMessages(null)
        isTextAnimating = false
        isImageAnimating = false
    }

    override fun onResume() {
        super.onResume()
        currentIndexText = 0
        textViewTittle.text = ""
        if (!isTextAnimating) {
            animateText()
        }
        if (!isImageAnimating) {
            animateImages()
        }
    }

    private fun animateText() {
        isTextAnimating = true
        val text = getString(textIds[currentIndexText])
        animateTyping(text, 0)
    }

    private fun animateTyping(text: String, index: Int) {
        if (index <= text.length) {
            val partialText = text.substring(0, index)
            textViewTittle.text = partialText
            val delay = 100L // Delay between each character typing
            textHandler.postDelayed({
                animateTyping(text, index + 1)
            }, delay)
        } else {
            // Text fully typed, wait before deleting
            textHandler.postDelayed({
                animateDeleting(text)
            }, 3000L) // Wait 3 seconds before deleting
        }
    }

    private fun animateDeleting(text: String) {
        animateDeletingInternal(text, text.length)
    }

    private fun animateDeletingInternal(text: String, index: Int) {
        if (index >= 0) {
            val partialText = text.substring(0, index)
            textViewTittle.text = partialText
            val delay = 100L // Delay between each character deletion
            textHandler.postDelayed({
                animateDeletingInternal(text, index - 1)
            }, delay)
        } else {
            // Text fully deleted, proceed to next text
            currentIndexText = (currentIndexText + 1) % textIds.size
            textHandler.postDelayed({
                animateText()
            }, 2000L) // Wait 2 seconds before starting next text animation
        }
    }

    private fun animateImages() {
        isImageAnimating = true
        imageHandler.post(object : Runnable {
            override fun run() {
                val transitionDrawable = TransitionDrawable(
                    arrayOf(
                        ContextCompat.getDrawable(this@MainActivity, drawableIds[currentIndexText])!!,
                        ContextCompat.getDrawable(this@MainActivity, drawableIds[(currentIndexText + 1) % drawableIds.size])!!
                    )
                )
                imageAnimation.setImageDrawable(transitionDrawable)
                transitionDrawable.startTransition(8000)

                currentIndexText = (currentIndexText + 1) % drawableIds.size

                imageHandler.postDelayed(this, 6000L) // Wait 6 seconds before next image animation
            }
        })
    }
}
