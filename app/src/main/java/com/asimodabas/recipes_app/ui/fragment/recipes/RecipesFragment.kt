package com.asimodabas.recipes_app.ui.fragment.recipes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asimodabas.recipes_app.R
import com.asimodabas.recipes_app.adapter.RecipesAdapter
import com.asimodabas.recipes_app.databinding.FragmentRecipesBinding
import com.asimodabas.recipes_app.util.viewBinding

class RecipesFragment : Fragment(R.layout.fragment_recipes) {

    private val binding by viewBinding(FragmentRecipesBinding::bind)
    private val mAdapter by lazy { RecipesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect() {
        binding.shimmerFrameLayout.startShimmer()
        binding.shimmerFrameLayout.visibility = View.VISIBLE
        binding.recyclerview.visibility = View.GONE
    }

    private fun hideShimmerEffect() {
        binding.shimmerFrameLayout.stopShimmer()
        binding.shimmerFrameLayout.visibility = View.GONE
        binding.recyclerview.visibility = View.VISIBLE
    }
}