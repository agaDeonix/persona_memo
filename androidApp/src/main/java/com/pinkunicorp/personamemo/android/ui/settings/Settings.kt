package com.pinkunicorp.personamemo.android.ui.settings

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen() {
    SettingsScreenContent()
}

@Composable
fun SettingsScreenContent() {
    var enableReminders by remember { mutableStateOf(true) }
    var enableNotifications by remember { mutableStateOf(true) }
    var backupEnabled by remember { mutableStateOf(true) }
    var passwordProtectionEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Settings", color = Color.Black, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(24.dp))

        SwitchListItem("Enable Reminders", enableReminders) { enableReminders = it }
        Spacer(modifier = Modifier.height(16.dp))

        SwitchListItem("Enable Notifications", enableNotifications) { enableNotifications = it }
        Spacer(modifier = Modifier.height(16.dp))

        SwitchListItem("Enable Backup", backupEnabled) { backupEnabled = it }
        Spacer(modifier = Modifier.height(16.dp))

        SwitchListItem("Enable Password Protection", passwordProtectionEnabled) { passwordProtectionEnabled = it }
    }
}

@Composable
fun SwitchListItem(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text, style = MaterialTheme.typography.body1)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Preview
@Composable
fun SettingsScreenContentPreview() {
    SettingsScreenContent()
}
