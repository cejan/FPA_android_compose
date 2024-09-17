package com.example.samplejetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplejetpack.interface2.Credentials
import com.example.samplejetpack.interface2.LoginForm1
import com.example.samplejetpack.interface2.checkCredentials
import com.example.samplejetpack.ui.theme.SampleJetpackTheme
import com.example.samplejetpack.view.CardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<MyViewModel>()
            //LoginForm1()
            SampleJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                ) {
                    CardScreen(viewModel)
                }
                //viewModel.findbyID(1).observ
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardScreen(viewModel)
                    *//*Greeting(
                        name = "Android 1",
                        modifier = Modifier.padding(innerPadding)
                    )*//*

                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current


    var name1 by remember {
        mutableStateOf("")
    }

    //name1 = viewModel.findbyID(1).value.toString()

    Text(
        text = name1,
        modifier = modifier
    )

    /*Button(
        onClick = {
            Toast.makeText(context, "clicked!", Toast.LENGTH_SHORT).show()
            // if (!checkCredentials(credentials, context)) credentials = Credentials()
        },
        // enabled = credentials.isNotEmpty(),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("toast")
    }*/
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleJetpackTheme {
        Greeting("Android")
    }
}
