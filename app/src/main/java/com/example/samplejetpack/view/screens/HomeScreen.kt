package com.example.samplejetpack.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplejetpack.dashboard.LineGraph
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

    }

    Column(modifier = Modifier.padding(top = 60.dp)) {
        //ButtomScafold2()
        Text(text = "Average Weekly Prices", modifier = Modifier.padding(10.dp, 10.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.
        ) {
            items(1){
                GraphCard("Urea")
                GraphCard("Complete")
                GraphCard("DAP")
                Card(
                    modifier = Modifier.background(Color.Transparent).padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth().height(50.dp),

                    ) {  }
            }
        }

    }
}


@Composable
fun GraphCard(grade: String) {

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

    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp))//,
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = "Weekly ${grade} Price", modifier = Modifier.padding(10.dp, 10.dp))
            LineGraph(x,y,grade)
        }


    }
}