package com.example.jetpackcomposeexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsProperties.ToggleableState
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
            //CountriesDialog()
            //SingleChoiceDialogActivityContent()
//            Column(modifier = Modifier.fillMaxSize()) {
//                Text(text = "Bottom Appbar")
//                BottomAppBarComponent()
//                Text(text = "Top Appbar")
//                TopAppBarComponent()
//            }
//            Text(text = "Bottom Navigation with label")
//            BottomNavigationWithLabelComponent()
//            Column {
//                SimpleTextComponent(text = "Simple CheckBox Example")
//                SimpleCheckboxComponent()
//                SimpleTextComponent(text = "Colored CheckBox Example")
//                ColoredCheckboxComponent()
//                SimpleTextComponent(text = "Tri-State CheckBox Example")
//                TriStateCheckboxComponent()
//            }
//            Column {
//                SimpleTextComponent(text = "Simple Circular Progress")
//                SimpleCircularProgressComponent()
//                SimpleTextComponent(text = "Circular ProgressBar with 40% progress")
//                CircularProgressComponent()
//                SimpleTextComponent(text = "Simple Linear Progress")
//                SimpleLinearProgressComponent()
//                SimpleTextComponent(text = "Linear Progress with 70% progress")
//                LinearProgressComponent()
//            }
            //CustomViewComponent()
            CrossFadeAnimation()
//            Column {
//                SimpleTextComponent(text = "Radio Button Example")
//                SimpleRadioButtonComponent()
//            }
//            Column {
//                SimpleTextComponent(text = "Simple Slider Example")
//                SimpleSliderComponent()
//                SimpleTextComponent(text = "Colored Slider Example")
//                ColoredSliderComponent()
//                SimpleTextComponent(text = "Stepped Slider Example")
//                SteppedSliderComponent()
//            }
        }
    }
}

@Composable
fun CrossFadeAnimation() {
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Gray)
    var current by remember { mutableStateOf(colors[0]) }
    Column(modifier = Modifier.fillMaxSize()) {
        Crossfade(targetState = current, animationSpec = tween(3000)) { color ->
            Box(Modifier
                .fillMaxSize()
                .clickable(
                    onClick = {
                        current = colors.random()
                    }
                )
                .background(color))
            Text(
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                text = "Click To See"
            )
        }
    }
}

@Composable
fun CustomViewComponent() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        drawRect(
            color = Color.Red,
            topLeft = Offset(0f, 0f),
            size = Size(800f, 400f)
        )
        drawRect(
            color = Color.Green,
            topLeft = Offset(100f, 100f),
            size = Size(600f, 200f)
        )
        drawRect(
            color = Color.Yellow,
            topLeft = Offset(200f, 150f),
            size = Size(400f, 100f)
        )
        drawArc(
            Color.Gray,
            startAngle = 0f,
            sweepAngle = 120f,
            useCenter = true,
            size = Size(600f, 600f),
            topLeft = Offset(200f, 200f)
        )
        drawLine(
            color = Color.Green,
            start = Offset(400f, 400f),
            end = Offset(500f, 500f),
            strokeWidth = 4f
        )
        drawCircle(
            color = Color.Red,
            center = Offset(500f, 500f),
            radius = 40f
        )
    }
}

@Composable
fun SimpleSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        }
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun ColoredSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        }
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun SteppedSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.5f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        valueRange = 0f..10f,
        steps = 10,
        onValueChange = { sliderValue = it })
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun SimpleRadioButtonComponent() {
    val radioOptions = listOf("Tung", "Thuy", "Mai")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
fun SimpleCircularProgressComponent() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun CircularProgressComponent() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp),
        progress = 0.4f,
        color = Color.Green
    )
}

@Composable
fun SimpleLinearProgressComponent() {
    LinearProgressIndicator(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun LinearProgressComponent() {
    LinearProgressIndicator(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        progress = 0.7f,
        color = Color.Green
    )
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp
        ), modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun SimpleCheckboxComponent() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Row {
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onCheckedChange = { checkedState.value = it })
        Text(text = "Checkbox Example", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ColoredCheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(Color.Blue)
        )
        Text(text = "Checkbox Example with color", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TriStateCheckboxComponent() {
    val toggleableState =
        listOf(
            androidx.compose.ui.state.ToggleableState.Off,
            androidx.compose.ui.state.ToggleableState.On,
            androidx.compose.ui.state.ToggleableState.Indeterminate
        )
    var counter by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TriStateCheckbox(
            state = toggleableState[counter % 3],
            onClick = {
                counter++
            })
        Text(text = "Checkbox tri-state example", modifier = Modifier.padding(start = 16.dp))
    }
}

@Composable
fun BottomNavigationWithLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Blogs", "Profile")
    BottomNavigation(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.Yellow
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = selectedItem == index,
                label = { Text(text = item) },
                icon = { Icon(Icons.Filled.Favorite, "favorite") },
                onClick = { selectedItem = index })
        }
    }
}

@Composable
fun BottomAppBarComponent() {
    BottomAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Menu, "menu")

        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, "favorite")
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite, "favorite")
        }
    }
}

@Composable
fun TopAppBarComponent() {
    TopAppBar(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(), title = { Text("App Name") }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Menu, "menu")
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, "favorite")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, "favorite")
        }
    })
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