package com.example.quis6animasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    private lateinit var textView: TextView
    private lateinit var buttonZoom: Button
    private lateinit var buttonBlink: Button
    private lateinit var zoom: Animation
    private lateinit var blink: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "KotlinApp"
        textView = findViewById(R.id.textView)
        buttonZoom = findViewById(R.id.buttonZoom)
        buttonBlink = findViewById(R.id.buttonBlink)
        blink = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        blink.setAnimationListener(this)
        zoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom)
        zoom.setAnimationListener(this)
        buttonZoom.setOnClickListener {
            textView.visibility = View.VISIBLE
            textView.startAnimation(zoom)
        }
        buttonBlink.setOnClickListener {
            textView.visibility = View.VISIBLE
            textView.startAnimation(blink)
        }
    }
    override fun onAnimationStart(animation: Animation) {}
    override fun onAnimationEnd(animation1: Animation) {}
    override fun onAnimationRepeat(animation: Animation) {}
}