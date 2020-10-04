package com.github.boybeak.livestock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.boybeak.livestock.onepixel.OnePixelActivity
import com.github.boybeak.livestock.onepixel.OnePixelManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startOnePixel(v: View) {
        Toast.makeText(this, "startOnePixel", Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this, OnePixelActivity::class.java))
        OnePixelManager.install(this)
    }

}