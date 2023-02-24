package com.asimodabas.recipes_app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.asimodabas.recipes_app.R
import com.asimodabas.recipes_app.databinding.FragmentRecipesBinding
import com.asimodabas.recipes_app.viewBinding

class RecipesFragment : Fragment(R.layout.fragment_recipes) {

    private val binding by viewBinding(FragmentRecipesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}