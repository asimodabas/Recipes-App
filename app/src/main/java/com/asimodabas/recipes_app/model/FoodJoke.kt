package com.asimodabas.recipes_app.model

import com.google.gson.annotations.SerializedName

data class FoodJoke(
    @SerializedName("text") val text: String
)