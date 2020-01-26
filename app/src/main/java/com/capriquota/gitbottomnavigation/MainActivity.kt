package com.capriquota.gitbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.capriquota.fragment.FirstFragment
import com.capriquota.fragment.SecondFragment
import com.capriquota.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title=resources.getString(R.string.menu_1)
        loadFragment(FirstFragment())
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_appoint-> {
                    title=resources.getString(R.string.menu_1)
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_new_appoint-> {
                    title=resources.getString(R.string.second_menu)
                    loadFragment(SecondFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_settings-> {
                    title=resources.getString(R.string.third_menu)
                    loadFragment(ThirdFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}