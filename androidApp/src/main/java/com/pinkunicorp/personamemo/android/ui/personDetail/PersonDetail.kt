package com.pinkunicorp.personamemo.android.ui.personDetail

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PersonDetailScreen() {
    val test = Person("John Doe", "Friend", "Loyal, Honest, Kind", "Helped me move")
    PersonDetailScreenContent(test)
}

data class Person(val name: String, val relationship: String, val traits: String, val moments: String)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonDetailScreenContent(person: Person) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Person Detail") },
                navigationIcon = {
                    IconButton(onClick = { /*Handle back button click*/ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = person.name, style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Relationship: ${person.relationship}", style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Traits: ${person.traits}", style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Memorable Moments: ${person.moments}", style = MaterialTheme.typography.body1)
        }
    }
}

@Preview
@Composable
fun PersonDetailScreenContentPreview() {
    PersonDetailScreenContent(
        person = Person("John Doe", "Friend", "Loyal, Honest, Kind", "Helped me move")
    )
}
