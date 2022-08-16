package com.application.vietlotteryfifteen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity(), ViewPagerAdapter.AdapterInterface {

    private val intefaces by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val detail = listOf(R.string.desc1, R.string.desc2,
        R.string.desc3, R.string.desc4, R.string.desc5,
        R.string.desc6, R.string.desc7, R.string.desc8)

        val images = listOf(R.drawable.banner15, R.drawable.banner15, R.drawable.banner15, R.drawable.banner15, R.drawable.banner15, R.drawable.banner15, R.drawable.banner15, R.drawable.banner15)

        val adapter = ViewPagerAdapter(this, images, detail, intefaces)
        viewPager2.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}