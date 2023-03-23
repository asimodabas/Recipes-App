package com.asimodabas.recipes_app.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.asimodabas.recipes_app.model.FoodRecipe
import com.asimodabas.recipes_app.util.Constants.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}