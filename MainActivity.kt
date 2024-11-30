package com.example.snowflakes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.snowflakes.SnowFlakes
import android.graphics.Paint



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // заменим разметку на нашу View
        //setContentView(R.layout.activity_main)
        setContentView(SnowFlakes(this))
    }
}

