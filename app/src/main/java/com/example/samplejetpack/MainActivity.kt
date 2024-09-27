package com.example.samplejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.samplejetpack.ui.theme.SampleJetpackTheme
import com.example.samplejetpack.view.bottomnav.BottomNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        setContent {
            //val viewModel = hiltViewModel<MyViewModel>()
            //LoginForm1()

            SampleJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    BottomNav()
                }

            }
        }
    }
}
@Composable
fun TopBar() {
    /*TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        //backgroundColor = colorResource(id = R.color.purple_500),
        //contentColor = Color.White
    )*/
}
