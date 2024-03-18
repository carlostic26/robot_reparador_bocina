package com.example.myapplication.screens

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat


class LoadingScreenActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        progressBar = findViewById(R.id.progressBar)
        loadingText = findViewById(R.id.loadingText)
        continueButton = findViewById(R.id.button)

        // Inicializa la barra de progreso
        progressBar.max = 100

        val seconds = 3000L // Duración en milisegundos (3 segundos)

        object : CountDownTimer(seconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = ((seconds - millisUntilFinished) / seconds.toFloat() * 100).toInt()
                progressBar.progress = progress
            }

            override fun onFinish() {
                loadingText.text = ""
                continueButton.isEnabled = true
                continueButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this@LoadingScreenActivity, R.color.colorButtonEnabled))
 }

        }.start()
    }
}


