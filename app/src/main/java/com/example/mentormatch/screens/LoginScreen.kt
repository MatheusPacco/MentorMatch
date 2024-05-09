package com.example.mentormatch.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserFormulario() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(false) }
    var description by remember { mutableStateOf("") }
    var overview by remember { mutableStateOf("") }
    var goal by remember { mutableStateOf("") }
    var technologies by remember { mutableStateOf("") }
    var softSkills by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = gender,
                onCheckedChange = { gender = it },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Male")
        }
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = overview,
            onValueChange = { overview = it },
            label = { Text("Overview") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = goal,
            onValueChange = { goal = it },
            label = { Text("Goal") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = technologies,
            onValueChange = { technologies = it },
            label = { Text("Technologies") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        for (i in 0 until 5) {
            OutlinedTextField(
                value = softSkills,
                onValueChange = { softSkills = it },
                label = { Text("Soft Skill ${i + 1}") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = active,
                onCheckedChange = { active = it },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Active")
        }
        Button(
            onClick = {
//                val user = User(
//                    name = name,
//                    age = age.toInt(),
//                    image = image,
//                    gender = gender,
//                    description = description,
//                    overview = overview,
//                    goal = goal,
//                    technologies = technologies.split(",").toTypedArray(),
//                    softSkills = Array(5) { i -> softSkills.split(",")[i] },
//                    active = active
//                )
//                onSubmit(user)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

@Preview(
    name = "Cadastro Preview",
    showSystemUi = true
)
@Composable
fun PreviewCadastro(){
    UserFormulario()
}

