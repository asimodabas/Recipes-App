package com.asimodabas.recipes_app.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.asimodabas.recipes_app.model.MealAndDietType
import com.asimodabas.recipes_app.util.Constants.DEFAULT_DIET_TYPE
import com.asimodabas.recipes_app.util.Constants.DEFAULT_MEAL_TYPE
import com.asimodabas.recipes_app.util.Constants.PREFERENCES_BACK_ONLINE
import com.asimodabas.recipes_app.util.Constants.PREFERENCES_DIET_TYPE
import com.asimodabas.recipes_app.util.Constants.PREFERENCES_DIET_TYPE_ID
import com.asimodabas.recipes_app.util.Constants.PREFERENCES_MEAL_TYPE
import com.asimodabas.recipes_app.util.Constants.PREFERENCES_MEAL_TYPE_ID
import com.asimodabas.recipes_app.util.Constants.PREFERENCES_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(PREFERENCES_NAME)

@ViewModelScoped
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object PreferenceKeys {
        val selectedMealType = stringPreferencesKey(PREFERENCES_MEAL_TYPE)
        val selectedMealTypeId = intPreferencesKey(PREFERENCES_MEAL_TYPE_ID)
        val selectedDietType = stringPreferencesKey(PREFERENCES_DIET_TYPE)
        val selectedDietTypeId = intPreferencesKey(PREFERENCES_DIET_TYPE_ID)
        val backOnline = booleanPreferencesKey(PREFERENCES_BACK_ONLINE)
    }

    private val dataStore: DataStore<Preferences> = context.dataStore

    suspend fun saveMealAndDietType(
        mealType: String, mealTypeId: Int, dietType: String, dietTypeId: Int
    ) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.selectedMealType] = mealType
            preferences[PreferenceKeys.selectedMealTypeId] = mealTypeId
            preferences[PreferenceKeys.selectedDietType] = dietType
            preferences[PreferenceKeys.selectedDietTypeId] = dietTypeId
        }
    }

    suspend fun saveBackOnline(backOnline: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.backOnline] = backOnline
        }
    }

    val readMealAndDietType: Flow<MealAndDietType> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        val selectedMealType = preferences[PreferenceKeys.selectedMealType] ?: DEFAULT_MEAL_TYPE
        val selectedMealTypeId = preferences[PreferenceKeys.selectedMealTypeId] ?: 0
        val selectedDietType = preferences[PreferenceKeys.selectedDietType] ?: DEFAULT_DIET_TYPE
        val selectedDietTypeId = preferences[PreferenceKeys.selectedDietTypeId] ?: 0
        MealAndDietType(
            selectedMealType, selectedMealTypeId, selectedDietType, selectedDietTypeId
        )
    }

    val readBackOnline: Flow<Boolean> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        val backOnline = preferences[PreferenceKeys.backOnline] ?: false
        backOnline
    }
}