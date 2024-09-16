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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.samplejetpack.interface2.Credentials
import com.example.samplejetpack.interface2.LoginForm1
import com.example.samplejetpack.interface2.checkCredentials
import com.example.samplejetpack.ui.theme.SampleJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //LoginForm1()
            SampleJetpackTheme {
                val viewModel = hiltViewModel<MyViewModel>()
                viewModel.fetchData()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current


/*
    Text(
        text = "Hello $name!!",
        modifier = modifier
    )*/

    Button(
        onClick = {
            Toast.makeText(context, "clicked!", Toast.LENGTH_SHORT).show()
            // if (!checkCredentials(credentials, context)) credentials = Credentials()
        },
        // enabled = credentials.isNotEmpty(),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("toast")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleJetpackTheme {
        Greeting("Android")
    }
}
