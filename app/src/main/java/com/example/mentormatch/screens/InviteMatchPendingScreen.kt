package com.example.mentormatch.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InviteMatchPending(){
    Surface {
        Column {
            Text(
                text = "teste",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun PreviewInviteMatchPending(){
    InviteMatchPending()
}
