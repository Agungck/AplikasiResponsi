package com.example.aplikasiresponsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aplikasiresponsi.fragment.HistoryFragment
import com.example.aplikasiresponsi.fragment.HomeFragment
import com.example.aplikasiresponsi.fragment.PaymentFragment
import com.example.aplikasiresponsi.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val paymentFragment = PaymentFragment()
        val historyFragment = HistoryFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.buttomnav)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.payment -> makeCurrentFragment(paymentFragment)
                R.id.history -> makeCurrentFragment(historyFragment)
                R.id.settings -> makeCurrentFragment(settingsFragment)
            }
        }
    }

    private fun makeCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.framnav, fragment)
            commit()
        }
    }

}