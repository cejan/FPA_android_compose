package com.example.samplejetpack.view.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.samplejetpack.ui.theme.SampleJetpackTheme

class ProfileView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val profileName = intent.getStringExtra("name")
        setContent {
            SampleJetpackTheme {
                Text(text = "Welcome to second activity ${profileName}")
            }
        }
    }
}