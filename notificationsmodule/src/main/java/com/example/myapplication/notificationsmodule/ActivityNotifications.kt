package com.example.myapplication.notificationsmodule

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.notificationsmodule.R
import kotlinx.android.synthetic.main.activity_notifications.*

class ActivityNotifications : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        Log.d("==ActivityNotifications", "onCreate")
        val navigation =
            findViewById<View>(R.id.nav_view) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val launchIntent =
                        packageManager.getLaunchIntentForPackage("com.example.myapplication")
                    launchIntent?.let {
                        it.addFlags(
                            Intent.FLAG_ACTIVITY_NO_ANIMATION
                                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                        )
                        startActivity(it)
                    }
                }
                R.id.navigation_dashboard -> {
                    val launchIntent =
                        packageManager.getLaunchIntentForPackage("com.example.dashboardmodule")
                    launchIntent?.let {
                        it.addFlags(
                            Intent.FLAG_ACTIVITY_NO_ANIMATION
                                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                        )
                        startActivity(it)
                    }
                }
                R.id.navigation_notifications -> {

                }
            }
            true
        }
        navigation.selectedItemId =
            R.id.navigation_notifications
    }

    override fun onResume() {
        super.onResume()
        Log.d("==ActivityNotifications", "onResume")

        nav_view.selectedItemId =
            R.id.navigation_notifications
    }
}
