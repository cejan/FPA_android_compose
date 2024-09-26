package com.example.samplejetpack.view.fertilizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.samplejetpack.ui.theme.SampleJetpackTheme
import com.example.samplejetpack.view.AllQoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FertilizerView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleJetpackTheme {
                AllQoutes()
                //Text(text = "Welcome to second activity")
            }
        }
    }
}