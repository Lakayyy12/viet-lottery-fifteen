package com.application.vietlotteryfifteen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TermsAndPolicy : AppCompatActivity() {

    private var bck  : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_policy)

        bck = findViewById(R.id.bck)
        bck?.setOnClickListener{
            onBackPressed()
        }
    }
}