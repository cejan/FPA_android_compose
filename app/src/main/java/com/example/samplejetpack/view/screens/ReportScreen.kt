package com.example.samplejetpack.view.screens

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.samplejetpack.R
import com.example.samplejetpack.dashboard.LineGraph

@Composable
fun ReportScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val x = mutableListOf<Float>()
        x.add(1.5f)
        x.add(1f)
        x.add(2f)
        x.add(5f)
        val y = mutableListOf<Float>()
        y.add(1.5f)
        y.add(1f)
        y.add(2f)
        y.add(5f)
        LineGraph(x,y,"asdasd")
    }

}