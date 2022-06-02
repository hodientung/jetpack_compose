package com.example.learnjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import java.util.concurrent.ThreadLocalRandom.current
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val fontFamily = FontFamily(
//            Font(R.font.tirodevanagarihindiitalic, FontWeight.Thin),
//            Font(R.font.tirodevanagarihindiregular, FontWeight.Light)
//        )
        setContent {
            Column {
                SimpleCardComponent()
                Divider(color = Color.Gray)
                RoundedCornerCardComponent()
                Divider(color = Color.Gray)
                BorderedCardComponent()
                Divider(color = Color.Gray)
            }
//            val scrollState = rememberScrollState()
//            LazyColumn {
//                itemsIndexed(listOf("This", " is", " jetpack", " compose")) { index, string ->
//                    Text(
//                        text = string,
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp)
//                    )
//                }
//            }
            //ConstraintLayoutComponent()
//            Column() {
//                SimpleTextComponent("Example of Simple Text Field")
//                SimpleTextFieldComponent()
//                Divider(color = Color.Gray)
//
//                SimpleTextComponent("Example of Text Field for Numbers")
//                NumberTextFieldComponent()
//                Divider(color = Color.Gray)
//            }
//            Column {
//                SetTextStyling(displayText = "I'm a simple text")
//                SetTextStyling(
//                    displayText = "I'm having font size as 24sp",
//                    style = TextStyle(fontSize = 24.sp)
//                )
//                SetTextStyling(
//                    displayText = "I'm a bold text",
//                    style = TextStyle(fontWeight = FontWeight.Bold)
//                )
//                SetTextStyling(
//                    displayText = "I'm an Italic text of size 16sp",
//                    style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 16.sp)
//                )
//                SetTextStyling(
//                    displayText = "I'm a simple text having RED color",
//                    style = TextStyle(color = Color.Red)
//                )
//                SetTextStyling(
//                    displayText = "My font family is Cursive",
//                    style = TextStyle(fontFamily = FontFamily.Cursive)
//                )
//                SetTextStyling(
//                    displayText = "Set text color, font size, font weight, font style",
//                    style = TextStyle(
//                        color = Color.Blue,
//                        fontWeight = FontWeight.Bold,
//                        fontStyle = FontStyle.Italic,
//                        fontSize = 16.sp
//                    )
//                )
//                SetTextStyling(
//                    displayText = "I'm an underlined text",
//                    style = TextStyle(textDecoration = TextDecoration.Underline)
//                )
//                SetTextStyling(
//                    displayText = "I'm a Strikethrough text",
//                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
//                )
//                SetTextStyling(
//                    displayText = "I'm a text having shadow",
//                    style = TextStyle(
//                        shadow = Shadow(
//                            color = Color.Red,
//                            blurRadius = 8f,
//                            offset = Offset(2f, 2f)
//                        )
//                    )
//                )
//
//            }


//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                SimpleText(displayText = getString(R.string.text_jetpack_compose))
//            }

//            var textFieldState by remember {
//                mutableStateOf("")
//            }
//            val scope = rememberCoroutineScope()
//            val scaffoldState = rememberScaffoldState()
//            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 30.dp)
//                ) {
//                    TextField(value = textFieldState, label = {
//                        Text("Enter your name")
//                    }, onValueChange = {
//                        textFieldState = it
//                    }, singleLine = true,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
//                        }
//                    }) {
//                        Text("Please greet me")
//                    }
//
//                }
//            }

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
fun SimpleCardComponent() {
    // Card is a composable that is used to make a CardView.
    Card(
        backgroundColor = Color(0xFFFFA867.toInt()),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(
            text = "Simple Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun RoundedCornerCardComponent() {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFFFA867.toInt()),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(
            text = "Rounded Corner Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BorderedCardComponent() {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFFFA867.toInt()),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green)),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(
            text = "Bordered Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ConstraintLayoutComponent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, textTop, textBottom, textStart, textEnd) = createRefs()
        Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(button) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Text(text = "Button")
        }
        Text(text = "Text Top", Modifier.constrainAs(textTop) {
            top.linkTo(parent.top)
            bottom.linkTo(button.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(text = "Text Bottom", modifier = Modifier.constrainAs(textBottom) {
            top.linkTo(button.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Text(text = "Text Start", modifier = Modifier.constrainAs(textStart) {
            start.linkTo(parent.start)
            end.linkTo(button.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Text(text = "Text End", modifier = Modifier.constrainAs(textEnd) {
            start.linkTo(button.end)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })

    }
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 16.sp, color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@ExperimentalFoundationApi
@Composable
fun SimpleTextFieldComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember {
            mutableStateOf(TextFieldValue("Enter text here"))
        }
        TextField(value = text, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), onValueChange =
        {
            text = it
        })
    }
}

@ExperimentalFoundationApi
@Composable
fun NumberTextFieldComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf(TextFieldValue("0123")) }
        TextField(value = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                text = it
            }
        )
    }
}

@Composable
fun SetTextStyling(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
}

@Composable
fun SimpleText(displayText: String) {
    Text(text = displayText)
}

@Preview
@Composable
fun SimpleTextPreview() {
    SimpleText(displayText = "Ho Dien Tung")
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