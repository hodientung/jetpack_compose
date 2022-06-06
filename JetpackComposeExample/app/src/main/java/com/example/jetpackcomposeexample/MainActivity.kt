package com.example.jetpackcomposeexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
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
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposeexample.data.Blog
import com.example.jetpackcomposeexample.data.getBlogList
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme


val dialogState by lazy { mutableStateOf(false) }
val selectedCountry by lazy { mutableStateOf("") }
val countriesList = getCountries().values.toList()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ScrollableColumnComponent(blogList = getBlogList())
            //LazyColumnScrollableComponent(blogList = getBlogList())
            //LazyRowScrollableComponent(blogList = getBlogList())
            //AlertDialogComponent()
            CountriesDialog()
            SingleChoiceDialogActivityContent()
        }
    }
}

@Composable
fun CountriesDialog() {
    SingleSelectedDialog(
        dialogState = dialogState,
        title = "Choose your Country",
        optionsList = countriesList,
        submitButtonText = "Select",
        onSubmitButtonClick = { selectedCountry.value = countriesList[it] },
        onDismissRequest = { dialogState.value = false }
    )
}

fun getCountries(): Map<String, String> {
    val countriesMap = hashMapOf<String, String>()
    val isoCountries = java.util.Locale.getISOCountries()
    isoCountries.forEach {
        val locale = java.util.Locale("", it)
        countriesMap[locale.country.toLowerCase(java.util.Locale.getDefault())] =
            locale.displayCountry
    }
    return countriesMap.toList().sortedBy { (_, value) -> value }.toMap()
}

@Composable
fun SingleSelectedDialog(
    dialogState: MutableState<Boolean>,
    title: String,
    optionsList: List<String>,
    defaultSelected: Int = -1,
    submitButtonText: String,
    onSubmitButtonClick: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    if (dialogState.value) {
        SingleSelectDialog(
            title = title,
            optionsList = optionsList,
            defaultSelected = defaultSelected,
            submitButtonText = submitButtonText,
            onSubmitButtonClick = onSubmitButtonClick,
            onDismissRequest = onDismissRequest
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun SingleSelectDialog(
    title: String,
    optionsList: List<String>,
    defaultSelected: Int = -1,
    submitButtonText: String,
    onSubmitButtonClick: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    val selectedOption = mutableStateOf(defaultSelected)
    Dialog(onDismissRequest = { onDismissRequest.invoke() }) {
        Surface(
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = title)
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(modifier = Modifier.height(500.dp)) {
                    itemsIndexed(optionsList) { index, item ->
                        val selected = if (selectedOption.value == -1)
                            ""
                        else optionsList[selectedOption.value]
                        RadioButtonHandle(item, selected) { selectedValue ->
                            selectedOption.value = optionsList.indexOf(selectedValue)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        onSubmitButtonClick.invoke(selectedOption.value)
                        onDismissRequest.invoke()
                    },
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = submitButtonText)
                }
            }
        }
    }
}

@Composable
fun RadioButtonHandle(text: String, selectedValue: String, onClickListener: (String) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .selectable(selected = (text == selectedValue), onClick = {
                onClickListener(text)
            })
            .padding(horizontal = 16.dp)
    ) {
        RadioButton(selected = (text == selectedValue), onClick = {
            onClickListener(text)
        })
        Text(
            text = text,
            style = MaterialTheme.typography.body1.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun SingleChoiceDialogActivityContent() {
    Column {
        Button(
            onClick = {
                dialogState.value = true
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
        ) {
            Text(
                text = "Show Countries List",
                textAlign = TextAlign.Center,
                color = Color.White
            )

        }
        Divider(color = Color.Black)
        Text(text = selectedCountry.value, textAlign = TextAlign.Center, color = Color.Black)
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