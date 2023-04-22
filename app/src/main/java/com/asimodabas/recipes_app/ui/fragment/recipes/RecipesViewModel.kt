package com.asimodabas.recipes_app.ui.fragment.recipes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.asimodabas.recipes_app.model.MealAndDietType
import com.asimodabas.recipes_app.util.Constants.API_KEY
import com.asimodabas.recipes_app.util.Constants.DEFAULT_DIET_TYPE
import com.asimodabas.recipes_app.util.Constants.DEFAULT_MEAL_TYPE
import com.asimodabas.recipes_app.util.Constants.DEFAULT_RECIPES_NUMBER
import com.asimodabas.recipes_app.util.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.asimodabas.recipes_app.util.Constants.QUERY_API_KEY
import com.asimodabas.recipes_app.util.Constants.QUERY_DIET
import com.asimodabas.recipes_app.util.Constants.QUERY_FILL_INGREDIENTS
import com.asimodabas.recipes_app.util.Constants.QUERY_NUMBER
import com.asimodabas.recipes_app.util.Constants.QUERY_TYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {

    private lateinit var mealAndDiet: MealAndDietType

    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        if (this@RecipesViewModel::mealAndDiet.isInitialized) {
            queries[QUERY_TYPE] = mealAndDiet.selectedMealType
            queries[QUERY_DIET] = mealAndDiet.selectedDietType
        } else {
            queries[QUERY_TYPE] = DEFAULT_MEAL_TYPE
            queries[QUERY_DIET] = DEFAULT_DIET_TYPE
        }

        return queries
    }
}