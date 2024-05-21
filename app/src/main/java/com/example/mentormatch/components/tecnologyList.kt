package com.example.mentormatch.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                colors =  AssistChipDefaults.assistChipColors(MaterialTheme.colorScheme.secondary, labelColor = MaterialTheme.colorScheme.background),
                border =  AssistChipDefaults.assistChipBorder(MaterialTheme.colorScheme.secondary)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTecnologylist(){
    Surface {
        val tecnologyList = mutableListOf("Android")
        tecnologylist(tecnologyList)
    }
}
