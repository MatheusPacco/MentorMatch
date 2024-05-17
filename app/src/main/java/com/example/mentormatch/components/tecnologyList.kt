package com.example.mentormatch.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun tecnologylist(listTecnology:MutableList<String>){
    Row (
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        listTecnology.forEach { tecnology ->
            AssistChip(
                modifier = Modifier
                    .height(24.dp),
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = "$tecnology",
                        fontSize = 10.sp,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        color = MaterialTheme.typography.bodySmall.color
                    )
                },
                colors =  AssistChipDefaults.assistChipColors(Color.Blue, labelColor = Color.LightGray),
                border =  AssistChipDefaults.assistChipBorder(borderColor = Color.LightGray)
            )
        }
    }
}
