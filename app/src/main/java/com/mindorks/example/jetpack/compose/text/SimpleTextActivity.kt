package com.mindorks.example.jetpack.compose.text

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.mindorks.example.jetpack.compose.R
import com.mindorks.example.jetpack.compose.ui.JetpackComposeAndroidExamplesTheme
import com.mindorks.example.jetpack.compose.ui.purple500
import com.mindorks.example.jetpack.compose.ui.shapes

class SimpleTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The setContent block defines the layout of the activity and it is used in place of
        // setContent(R.id.some_xml_file) that we use normally(without compose). This is an
        // extension function of Activity. Form here we can call all our @Composable functions.
        setContent {
            // Column is used to have the views one after the other vertically. In the Column,
            // we can pass some parameters such as modifier, verticalArrangement, horizontalAlignment, etc.

            // modifier is used to decorate or add behavior to UI elements. Here we are telling the
            // column to fill the maximum size of the screen
            var showMenu by remember { mutableStateOf(false) }
            JetpackComposeAndroidExamplesTheme() {

                Surface(color = MaterialTheme.colors.background) {
                    // at below line we are calling
                    // our function for toolbar.
                    // theme for our app.
                    Scaffold(
                        // below line we are
                        // creating a top bar.
                        topBar = {
                            TopAppBar(
                                // in below line we are
                                // adding title to our top bar.
                                title = {
                                    // inside title we are
                                    // adding text to our toolbar.
                                    Text(
                                        text = "Geeks for Geeks",
                                        // below line is use
                                        // to give text color.
                                        color = Color.White
                                    )
                                },
                                actions = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(Icons.Default.Favorite)
                                    }
                                    IconButton(onClick = { showMenu = !showMenu }) {
                                        Icon(Icons.Default.MoreVert)
                                    }
                                    DropdownMenu(
                                        toggle = { /*TODO*/ },
                                        expanded = showMenu,
                                        onDismissRequest = { showMenu = false }) {
                                        DropdownMenuItem(onClick = {  }) {
                                            Row {
                                                Icon(Icons.Filled.Refresh)
                                                Text(text ="Refresh")
                                            }
                                        }
                                        DropdownMenuItem(onClick = {  }) {
                                            Icon(Icons.Filled.Call)
                                        }
                                    }
                                },
                                navigationIcon = {
                                    // navigation icon is use
                                    // for drawer icon.
                                    IconButton(onClick = {
                                        Toast.makeText(this,"navigationIcon click",Toast.LENGTH_SHORT).show()
                                    }) {
                                        // below line is use to
                                        // specify navigation icon.
                                        Icon(Icons.Filled.Menu)
                                    }
                                },
                                // below line is use to give background color
                                backgroundColor = colorResource(id = R.color.purple_200),
                                // content color is use to give
                                // color to our content in our toolbar.
                                contentColor = Color.White,
                                // below line is use to give
                                // elevation to our toolbar.
                                elevation = 12.dp,


                                )
                        },
                        floatingActionButton = {
                            FloatingActionButton(
                                shape = CircleShape,
                                onClick = {},
                            ) {
                                Icon(asset = Icons.Filled.Add)
                            }
                        },
                        floatingActionButtonPosition = FabPosition.End,
                        isFloatingActionButtonDocked = true,
                        bottomBar = {
                            BottomAppBar(backgroundColor = purple500, cutoutShape = CircleShape) {
                                IconButton(onClick = {
                                    //scaffoldState.drawerState.open()
                                }) {
                                    Icon(Icons.Filled.Menu, tint = Color.Red)
                                }
                                Text(text = "BottomAppBar")
                                Spacer(modifier = Modifier.preferredSize(16.dp))
                                Button(
                                    onClick = { },
                                    backgroundColor = Color.Red
                                ) {
                                    Row() {
                                        Text("Button")
                                    }
                                }
                            }
                        },
                        bodyContent = {
                            // bodyContent()
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                SimpleText(getString(R.string.msg_simple_text))
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(height = 100.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    SimpleText(getString(R.string.msg_simple_text) + "asdasdasdasd sd fgsdf ")
                                }
                            }
                        })
                }
            }


        }
    }
}


// This is a Composable function. To write any Composable function, you need to use @Composable annotation
@Composable
fun SimpleText(displayText: String) {
    // Text composable is used to display some text
    Text(text = displayText)
}

// Android Studio provides an awesome feature of previewing your Compose UI elements while writing the code.
// To do so, you need to use @Preview annotation and then write a Composable function and call your UI element.
// The UI will be refreshed on every build or you can refresh manually from the UI preview tab.
@Preview
@Composable
fun SimpleTextPreview() {
    SimpleText("Hi I am learning Compose")

}