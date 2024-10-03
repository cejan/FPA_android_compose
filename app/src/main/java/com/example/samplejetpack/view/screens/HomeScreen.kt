package com.example.samplejetpack.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplejetpack.fertilizer.FertilizerViewModel
import com.example.samplejetpack.view.ButtomScafold2
import com.example.samplejetpack.view.SimpleBottomSheetScaffoldSample
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

//import com.example.samplejetpack.MyViewModel

@Composable
fun HomeScreen(
    //viewModel: FertilizerViewModel = hiltViewModel()
)
{
    //val cardsGreeting by viewModel..observeAsState(null)

    /*LaunchedEffect(Unit) {
        viewModel.makeApiCall()
    }*/

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Transparent)
    ) {
        //Text(text = "Home Screen", fontSize = 20.sp)
        //SimpleBottomSheetScaffoldSample()
        ButtomScafold2()
    }
}