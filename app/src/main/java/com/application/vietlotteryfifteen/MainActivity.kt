package com.application.vietlotteryfifteen

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var exit = 0
    private var btnM : TextView? = null
    private var btnP : TextView? = null

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Detail>

    private lateinit var title: Array<String>
    private lateinit var descriptions: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnM = findViewById(R.id.btnM)
        btnM?.setOnClickListener{
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        btnP = findViewById(R.id.btnP)
        btnP?.setOnClickListener{
            val intent = Intent(this, TermsAndPolicy::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        title = arrayOf(getString(R.string.about_title1),
            getString(R.string.about_title2),
            getString(R.string.about_title3))

        descriptions = arrayOf(getString(R.string.about1),
            getString(R.string.about2),
            getString(R.string.about3))

        newRecyclerView = findViewById(R.id.recyclerItems)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Detail>()
        getUserdata()
    }
    private fun getUserdata() {

        for (i in title.indices) {

            val news = Detail( title[i], descriptions[i])
            newArrayList.add(news)
        }
        val adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
    }
    override fun onBackPressed() {
        if (exit==0){
            exit = 1
            Toast.makeText(this, "Nhấp lại để thoát!", Toast.LENGTH_SHORT).show()
        }else{
            super.finishAffinity()
        }
    }
}