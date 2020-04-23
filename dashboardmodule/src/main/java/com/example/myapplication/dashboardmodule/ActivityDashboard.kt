package com.example.myapplication.dashboardmodule

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.View
import com.example.dashboardmodule.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class ActivityDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Log.d("==ActivityDashboard", "onCreate")
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

                }
                R.id.navigation_notifications -> {
//                    this.startActivity(
//                        Intent(this, com.example.notificationsmodule.ActivityNotifications::class.java).addFlags(
//                            Intent.FLAG_ACTIVITY_NO_ANIMATION
//                                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
//                        )
//                    )
                    val launchIntent =
                        packageManager.getLaunchIntentForPackage("com.example.notificationsmodule")
                    launchIntent?.let {
                        it.addFlags(
                            Intent.FLAG_ACTIVITY_NO_ANIMATION
                                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                        )
                        startActivity(it)
                    }
                }
            }
            true
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d("==ActivityDashboard", "onResume")

        nav_view.selectedItemId =
            R.id.navigation_dashboard
    }
}
