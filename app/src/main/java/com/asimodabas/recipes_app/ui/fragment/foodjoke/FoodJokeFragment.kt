package com.asimodabas.recipes_app.ui.fragment.foodjoke

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.asimodabas.recipes_app.R
import com.asimodabas.recipes_app.databinding.FragmentFoodJokeBinding
import com.asimodabas.recipes_app.util.viewBinding

class FoodJokeFragment : Fragment(R.layout.fragment_food_joke) {

    private val binding by viewBinding(FragmentFoodJokeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}