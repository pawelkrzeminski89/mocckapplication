package com.example.mockktestsapplication.ui

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mockktestsapplication.ui.theme.MockkTestsApplicationTheme
import com.example.mockktestsapplication.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
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
fun CurrentDateForm(viewModel: MainViewModel = hiltViewModel()) {
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