package de.amanidunia.apps.navigationbartest

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import de.amanidunia.apps.navigationbartest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragement(Home())

        val homeView = findViewById<ConstraintLayout>(R.id.main)

        val drawable : AnimationDrawable = homeView.background as AnimationDrawable

        drawable.setEnterFadeDuration(2222)
        drawable.setExitFadeDuration(2222)
        drawable.start()

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFragement(Home())
                R.id.drink -> replaceFragement(Drink())
                R.id.eat -> replaceFragement(Eat())
                R.id.cart -> replaceFragement(Cart())

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


