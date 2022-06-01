package com.example.learnjetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.tirodevanagarihindiitalic, FontWeight.Thin),
            Font(R.font.tirodevanagarihindiregular, FontWeight.Light)
        )
        setContent {

            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(value = textFieldState, label = {
                        Text("Enter your name")
                    }, onValueChange = {
                        textFieldState = it
                    }, singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                        }
                    }) {
                        Text("Please greet me")
                    }

                }
            }

            //ColorBox(Modifier.fillMaxSize())
//            val painter = painterResource(R.drawable.bachtung_thuthuy)
//            val description = "Eat together"
//            val title = "Great"
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCard(painter = painter, contentDescription = description, title = title)
//            }

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//            ) {
//                Text(
//                    text = buildAnnotatedString {
//                        withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
//                            append("J")
//                        }
//                        append("etpack")
//                        withStyle(style = SpanStyle(color = Color.Green, fontSize = 50.sp)) {
//                            append("C")
//                        }
//                        append("ompose")
//                    },
//                    color = Color.White,
//                    fontSize = 30.sp,
//                    fontFamily = fontFamily,
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    textDecoration = TextDecoration.Underline
//                )
//            }

//            Column {
//                Column{
//                    Text("Ho")
//                    Text("Dien")
//                    Text("Tung")
//                }
//                Row (modifier  = Modifier
//                    .width((200.dp))
//                    .height(300.dp)
//                    .background(Color.Blue)){
//                    Text("Go")
//                    Text("for")
//                    Text("it")
//
//                }
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Text("be")
//                    Text("able to")
//                }
//                Column(modifier = Modifier.fillMaxSize().background(Color.Green),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween) {
//                    Text("be")
//                    Text("able to")
//                }
//            }

        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    Box(modifier = Modifier
        .background(color.value)
        .clickable {
            color.value = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
        })
}

@Composable
fun ImageCard(
    painter: Painter, contentDescription: String,
    title: String, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter, contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black), startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
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