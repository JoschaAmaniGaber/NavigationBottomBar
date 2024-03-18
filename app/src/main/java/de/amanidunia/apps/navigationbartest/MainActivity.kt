package de.amanidunia.apps.navigationbartest

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import de.amanidunia.apps.navigationbartest.databinding.ActivityMainBinding
import de.amanidunia.apps.navigationbartest.fragment.tabView.MainView_Cart
import de.amanidunia.apps.navigationbartest.fragment.tabView.MainView_Drink
import de.amanidunia.apps.navigationbartest.fragment.tabView.MainView_Eat
import de.amanidunia.apps.navigationbartest.fragment.tabView.MainView_Home

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragement(MainView_Home())

        val homeView = findViewById<ConstraintLayout>(R.id.main)

        val drawable : AnimationDrawable = homeView.background as AnimationDrawable

        drawable.setEnterFadeDuration(8888)
        drawable.setExitFadeDuration(8888)
        drawable.start()

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFragement(MainView_Home())
                R.id.drink -> replaceFragement(MainView_Drink())
                R.id.eat -> replaceFragement(MainView_Eat())
                R.id.cart -> replaceFragement(MainView_Cart())

                else -> {

                }
            }
            true


        }
    }

    private fun replaceFragement(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }
}


