package com.application.vietlotteryfifteen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ItemViewerPage : AppCompatActivity() {

    private var back : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_viewer_page)

        back = findViewById(R.id.back)
        back?.setOnClickListener{
            onBackPressed()
        }
    }
}