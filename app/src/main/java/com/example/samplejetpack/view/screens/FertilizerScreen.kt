package com.example.samplejetpack.view.screens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
//import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.samplejetpack.R
import com.example.samplejetpack.ui.theme.SampleJetpackTheme
import com.example.samplejetpack.view.fertilizer.FertilizerView


@Composable
fun FertilizerScreen() {
    val context = LocalContext.current
    val intent1 = Intent(context.getActivityOrNull(), FertilizerView::class.java)
    /*val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://fastly.picsum.photos/id/250/200/200.jpg?hmac=23TaEG1txY5qYZ70amm2sUf0GYKo4v7yIbN9ooyqWzs")
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )*/
    //intent1.putExtra("name", "Mr. Jay")
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Transparent)
            .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text( text = "This is Fertilizer View ",  color = MaterialTheme.colorScheme.primary, /*fontSize = 10.sp*/)
        Card(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth()/*.background(MaterialTheme.colorScheme.primary)*/,
            shape = RoundedCornerShape(CornerSize(10.dp)),
            onClick = {
                // Toast.makeText(context,"Card Clicked ", Toast.LENGTH_SHORT).show()
                context.startActivity(intent1)
            }
            // elevation = 4.dp
        ) {
            Row(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth()){
                Icon(
                    painter = painterResource(R.drawable.ic_bottom_report),
                    contentDescription = "image",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)
                        .clip(RoundedCornerShape(CornerSize(6.dp)))
                        .align(Alignment.CenterVertically),
                )
                Text(
                    text = "Company List",
                    modifier = Modifier.padding( 10.dp).wrapContentHeight(align = Alignment.CenterVertically),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 35.sp,
                    )
            }
        }

        Card(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            onClick = {
                //context.startActivity(intent1)
                Toast.makeText(context,"This is Toast: Card Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Row(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth()){
                Image(
                    painter = painterResource( R.drawable.ic_bottom_home),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)
                        .clip(RoundedCornerShape(CornerSize(6.dp)))
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Toast",
                    modifier = Modifier.padding( 10.dp).wrapContentHeight(align = Alignment.CenterVertically),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 35.sp,

                )
            }

        }

        /*Button(onClick = {  Toast.makeText(context,"Toast text ", Toast.LENGTH_SHORT).show()}) {
            Text("toast sample")
        }*/
        /*Button(onClick = {
            context.startActivity(intent1)
        }) {
            Text("Open List")
        }*/
    }

}


