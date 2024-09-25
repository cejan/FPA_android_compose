package com.example.samplejetpack.view.screens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity


@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    val intent1 = Intent(context.getActivityOrNull(), ProfileView::class.java)

    intent1.putExtra("name", "Mr. Jay")
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {  Toast.makeText(context,"Toast text ", Toast.LENGTH_SHORT).show()}) {
            Text("Filled")
        }
        Button(onClick = {
            context.startActivity(intent1)
        }) {
            Text("intent")

        }
    }

}

fun Context.getActivityOrNull(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}
