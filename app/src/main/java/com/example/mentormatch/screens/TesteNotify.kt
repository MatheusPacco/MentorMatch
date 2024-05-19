package com.example.mentormatch.screens

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mentormatch.service.notification.NotificationHandler
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun mainNofity(){
    Surface {
        val context = LocalContext.current
        val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
        val notificationHandler = NotificationHandler(context)

        LaunchedEffect(key1 = true) {
            if (!postNotificationPermission.status.isGranted) {
                postNotificationPermission.launchPermissionRequest()
            }
        }

        Column {
            Button(onClick = {
                notificationHandler.showSimpleNotification("Cliente criado com sucesso", "Pendente aprovação do cliente")
            }) { Text(text = "Simple notification") }
        }
        Text(text = "Teste de criação de notificação")
    }
}

@Preview
@Composable
fun previewMainNotify(){
    mainNofity()
}