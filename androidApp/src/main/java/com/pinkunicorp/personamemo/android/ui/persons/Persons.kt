package com.pinkunicorp.personamemo.android.ui.persons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PersonsScreen() {
    PersonsScreenContent()
}

data class Person(val name: String, val relationship: String)

@Composable
fun PersonsScreenContent() {
// Sample data
    val persons = remember {
        listOf(
            Person("John Doe", "Friend"),
            Person("Jane Smith", "Colleague"),
            // Add more persons here...
        )
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*Navigate to Add New Person Screen*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add New Person")
            }
        }
    ) { contentPadding ->
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(persons) { person ->
                PersonCard(person = person)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun PersonCard(person: Person) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = person.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = person.relationship, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview
@Composable
fun PersonsScreenContentPreview() {
    PersonsScreenContent()
}
