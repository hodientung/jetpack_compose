package com.example.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Column{
                    Text("Ho")
                    Text("Dien")
                    Text("Tung")
                }
                Row (modifier  = Modifier
                    .width((200.dp))
                    .height(300.dp)
                    .background(Color.Blue)){
                    Text("Go")
                    Text("for")
                    Text("it")

                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("be")
                    Text("able to")
                }
                Column(modifier = Modifier.fillMaxSize().background(Color.Green),
                        horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {
                    Text("be")
                    Text("able to")
                }
            }

        }
    }
}
//
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    LearnJetpackComposeTheme {
//        Greeting("Ho Dien Tung")
//    }
//}