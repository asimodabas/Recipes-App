package com.asimodabas.recipes_app.ui.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.asimodabas.recipes_app.R
import com.asimodabas.recipes_app.databinding.FragmentFavoriteRecipesBinding
import com.asimodabas.recipes_app.util.viewBinding

class FavoriteRecipesFragment : Fragment(R.layout.fragment_favorite_recipes) {

    private val binding by viewBinding(FragmentFavoriteRecipesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}