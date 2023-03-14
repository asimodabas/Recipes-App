package com.asimodabas.recipes_app.ui.activity.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asimodabas.recipes_app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}