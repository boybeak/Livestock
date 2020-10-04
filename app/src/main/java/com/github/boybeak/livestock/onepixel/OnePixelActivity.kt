package com.github.boybeak.livestock.onepixel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.github.boybeak.livestock.R

class OnePixelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setGravity(Gravity.START or Gravity.TOP)

        val lp = window.attributes
        lp.apply {
            width = 1
            height = 1
            x = 0
            y = 0
        }
        window.attributes = lp
        setContentView(R.layout.activity_one_pixel)

        OnePixelManager.onOnePixelWorked(this)
    }
}