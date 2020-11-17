package com.latihan.schedule_reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.latihan.schedule_reminder.fragments.ScheduleFragment
import com.latihan.schedule_reminder.fragments.SettingsFragment
import com.latihan.schedule_reminder.fragments.TaskFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scheduleFragment = ScheduleFragment()
        val taskFragment = TaskFragment()
        val settingsFragment = SettingsFragment()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        makeCurrentFragment(scheduleFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_schedule -> makeCurrentFragment(scheduleFragment)
                R.id.ic_task -> makeCurrentFragment(taskFragment)
                R.id.ic_settings -> makeCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}