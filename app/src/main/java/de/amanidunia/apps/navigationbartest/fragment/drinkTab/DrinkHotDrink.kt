package de.amanidunia.apps.navigationbartest.fragment.drinkTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.amanidunia.apps.navigationbartest.R

/**
 * A simple [Fragment] subclass.
 * Use the [DrinkHotDrink.newInstance] factory method to
 * create an instance of this fragment.
 */
class DrinkHotDrink : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_hotdrink, container, false)
    }

}