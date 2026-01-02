package com.asimodabas.recipes_app.data

import com.asimodabas.recipes_app.data.database.RecipesDao
import com.asimodabas.recipes_app.data.database.entities.RecipesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {

    fun readRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        withContext(Dispatchers.IO) {
            recipesDao.insertRecipes(recipesEntity)
        }
    }
}