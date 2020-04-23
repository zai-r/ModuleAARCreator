package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("==MainActivity", "onCreate")
        // startActivities時ちらつき問題仮対応
        val intentDashboard = Intent(this, com.example.myapplication.dashboardmodule.ActivityDashboard::class.java).addFlags(
            Intent.FLAG_ACTIVITY_NO_ANIMATION
                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
        )

        val intentNotifications =  Intent(this, com.example.myapplication.notificationsmodule.ActivityNotifications::class.java).addFlags(
            Intent.FLAG_ACTIVITY_NO_ANIMATION
                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
        )
        val intents = arrayOf(intentDashboard, intentNotifications, this.intent)
        this.startActivities(intents)

        setContentView(R.layout.activity_main)
        val title = findViewById<View>(R.id.homeTitle1) as TextView
        title.text = "Home"

        val navigation =
            findViewById<View>(R.id.nav_view) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.d("==MainActivity", "navigation_home")
                }
                R.id.navigation_dashboard -> {
                    Log.d("==MainActivity", "navigation_dashboard")
                    this.startActivity(intentDashboard)
//                    overridePendingTransition(R.anim.slideinleft, R.anim.slideinright)
                }
                R.id.navigation_notifications -> {
                    Log.d("==MainActivity", "navigation_notifications")
                    this.startActivity(intentNotifications)
                }
            }
            true
        }


    }

    override fun onResume() {
        super.onResume()
        Log.d("==MainActivity", "onResume")

        nav_view.selectedItemId = R.id.navigation_home
    }
}