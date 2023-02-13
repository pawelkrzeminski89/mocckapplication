package com.example.mockktestsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mockktestsapplication.ui.theme.MockkTestsApplicationTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MockkTestsApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CurrentDateForm()
                }
            }
        }
    }
}

@Composable
fun CurrentDateForm() {
    var date = remember { Calendar.getInstance().time.time }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = date.toString(),
            onValueChange = { newDate ->
                // tutaj należy dodać kod do konwersji tekstu na datę i ustawienia jej w zmiennej date
            }
        )
        Button(onClick = { /* tutaj możesz dodać logikę związaną z potwierdzeniem daty */ }) {
            Text("Zatwierdź")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MockkTestsApplicationTheme {
        CurrentDateForm()
    }
}