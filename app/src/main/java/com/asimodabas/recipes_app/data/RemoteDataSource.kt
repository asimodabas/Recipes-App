package com.asimodabas.recipes_app.data

import com.asimodabas.recipes_app.data.network.FoodRecipesApi
import com.asimodabas.recipes_app.model.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}