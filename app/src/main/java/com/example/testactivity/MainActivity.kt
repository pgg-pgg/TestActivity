package com.example.testactivity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            var systemUiVisibility = window.decorView.systemUiVisibility
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = systemUiVisibility
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        val contentView = window.decorView.findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup
        val rootView = contentView.getChildAt(0)
        val statusBarHeight: Int = 75
        if (rootView != null) {
            val lp = rootView.layoutParams as FrameLayout.LayoutParams
            ViewCompat.setFitsSystemWindows(rootView, true)
            lp.topMargin = -statusBarHeight
            rootView.layoutParams = lp
        }
        var visibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        visibility = visibility or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        visibility = visibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        if (Build.VERSION.SDK_INT >= 19) {
            visibility = visibility or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
        val targetFlag = window.decorView.systemUiVisibility or visibility
        window.decorView.systemUiVisibility = targetFlag
        setContentView(R.layout.activity_main)
        findViewById<CenterFlowLayout>(R.id.center_flow).apply {
            for (i in 0..4) {
                val textView = TextView(context)
                textView.text = "这是一个$i"
                textView.textSize = 20f
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
                addView(textView)
            }

        }
    }
}