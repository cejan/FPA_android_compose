package com.example.samplejetpack.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


@Composable
fun LineGraph(
    xData: List<Float>,
    yData: List<Float>,
    dataLabel: String,
    modifier: Modifier = Modifier
){
    AndroidView(
        modifier = modifier.fillMaxWidth().height(300.dp),
        factory = { context ->
            val chart = LineChart(context)  // Initialise the chart
            val entries: List<Entry> = xData.zip(yData) { x, y -> Entry(x, y) }  // Convert the x and y data into entries
            val dataSet = LineDataSet(entries, dataLabel)  // Create a dataset of entries
            chart.data = LineData(dataSet)  // Pass the dataset to the chart
            // Refresh and return the chart
            chart.invalidate()
            chart
        }
    )
}