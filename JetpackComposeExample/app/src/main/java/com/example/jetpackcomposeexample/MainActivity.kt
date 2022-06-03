package com.example.jetpackcomposeexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposeexample.data.Blog
import com.example.jetpackcomposeexample.data.getBlogList
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ScrollableColumnComponent(blogList = getBlogList())
            //LazyColumnScrollableComponent(blogList = getBlogList())
            //LazyRowScrollableComponent(blogList = getBlogList())
            AlertDialogComponent()
        }
    }
}


@Composable
fun AlertDialogComponent() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Alert Dialog") },
            text = { Text("Hello! I am an Alert Dialog") },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            },
            backgroundColor = Color.Black,
            contentColor = Color.White
        )
    }
}

@Composable
fun LazyRowScrollableComponent(blogList: List<Blog>) {
    LazyRow {
        itemsIndexed(blogList) { index, blog ->
            val context = LocalContext.current
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(16.dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT)
                            .show()
                    }),
                backgroundColor = Color(0xFFFFA867.toInt())
            ) {
                Text(
                    blog.name, style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun LazyColumnScrollableComponent(blogList: List<Blog>) {
    LazyColumn {
        itemsIndexed(blogList) { index, blog ->
            val context = LocalContext.current
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(16.dp)
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT)
                            .show()
                    }),
                backgroundColor = Color(0xFFFFA867.toInt())
            ) {
                Text(
                    blog.name, style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ScrollableColumnComponent(blogList: List<Blog>) {
    Column {
        val context = LocalContext.current
        Column {
            for (blog in blogList) {
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable(onClick = {
                            Toast
                                .makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT)
                                .show()
                        }),
                    backgroundColor = Color(0xFFFFA867.toInt())
                ) {
                    Text(
                        blog.name, style = TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExampleTheme {
        Greeting("Android")
    }
}