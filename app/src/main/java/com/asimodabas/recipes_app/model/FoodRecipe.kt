package com.asimodabas.recipes_app.model

import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results") val results: List<Result>
)