package com.asimodabas.recipes_app.ui.fragment.recipes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.asimodabas.recipes_app.util.Constants.API_KEY
import com.asimodabas.recipes_app.util.Constants.DEFAULT_RECIPES_NUMBER
import com.asimodabas.recipes_app.util.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.asimodabas.recipes_app.util.Constants.QUERY_API_KEY
import com.asimodabas.recipes_app.util.Constants.QUERY_FILL_INGREDIENTS
import com.asimodabas.recipes_app.util.Constants.QUERY_NUMBER
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {

    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }
}