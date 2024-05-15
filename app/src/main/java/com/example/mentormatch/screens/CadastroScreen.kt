package com.example.mentormatch.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mentormatch.enums.SoftSkill
import com.example.mentormatch.enums.Technology
import com.example.mentormatch.ui.theme.MentorMatchTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CadastroScreen(navController: NavHostController) {
    Surface (
        modifier = Modifier.fillMaxSize(),
    ){
        var isMale = remember {
            mutableStateOf(false)
        }
        var isFemale = remember {
            mutableStateOf(false)
        }
        var nome = remember {
            mutableStateOf("")
        }
        var age = remember {
            mutableStateOf("0")
        }
        var typeUser =  remember {
            mutableStateOf(0)
        }
        var technologyListState = remember {
            mutableStateListOf<String>()
        }
        var softSkillListState = remember {
            mutableStateListOf<String>()
        }
        var goal = remember {
            mutableStateOf("")
        }
        var description = remember {
            mutableStateOf("")
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState(), enabled = true),
            // verticalArrangement = Arrangement.Center, // Alinhamento vertical
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(
                text = "Formulário de cadastro",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),

                value = nome.value,
                onValueChange = { novoValor ->
                    print("teste de preenchimento de campo?: $novoValor")
                    nome.value = novoValor
                },
                label = {
                    Text(text = "Digite seu nome")
                },
                placeholder = {
                    Text(text = "Digite o seu nome")
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = age.value,
                onValueChange = { novoValor ->
                    age.value = novoValor
                },
                label = {
                    Text(text = "Digite sua idade")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Text(
                text = "Gênero",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){

                Checkbox(
                    checked = isMale.value,
                    onCheckedChange = { checked ->
                        isMale.value = checked
                        isFemale.value = false
                    },
                )
                Text(
                    text = "Masculino"
                )
                Checkbox(
                    checked = isFemale.value,
                    onCheckedChange = { checked ->
                        isFemale.value = checked
                        isMale.value = false
                    },
                )
                Text(
                    text = "Feminino"
                )
            }
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Text(
                text = "Tipo de Perfil",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){
                RadioButton(
                    selected = typeUser.value == 0,
                    onClick = {
                        typeUser.value = 0
                    },
                )
                Text(text="Mentor")
                RadioButton(
                    selected = typeUser.value == 1,
                    onClick = {
                        typeUser.value = 1
                    },
                )
                Text(text="Aprendiz")
            }
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = goal.value,
                onValueChange = { novoValor ->
                    goal.value = novoValor
                },
                label = {
                    Text(text = "Escreva seu principal objetivo")
                },
                placeholder = {
                    Text(text = "Exemplo: Conquistar meu primeiro emprego, Trabalhar no exterior...")
                },
            )
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = description.value,
                onValueChange = { novoValor ->
                    description.value = novoValor
                },
                label = {
                    Text(text = "Descreva sobre você")
                },
                placeholder = {
                    Text(text = "Exemplo: Fale sobre sua história de vida, conquistas e percurso até hoje")
                },
            )
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Text(
                text = "Escolha 4 tecnologias que você se tem conhecimento!",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            FlowRow(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentHeight(align = Alignment.Top)
                    .fillMaxWidth(),
                maxItemsInEachRow = 4,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ){
                TechnologyChip(technologyListState)
            }
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Text(
                text = "Escolha 4 soft skills que te definem!",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            FlowRow(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                maxItemsInEachRow = 4,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ){
                SoftSkillChip(softSkillListState)
            }
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
            )
            {
                Button(
                    onClick = {
                        // val user:User = User(nome.value, age.value.toInt(), isMale.value, typeUser.value, description.value, goal.value, technologyListState.toTypedArray(), softSkillListState.toTypedArray())
                        // Log.d("Usuário criado", "User: " + user.toString())
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                )
                {
                    Text(text="Criar perfil")
                }
                OutlinedButton(
                    onClick = {
                        navController.navigate("login")
                    },
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color.Red
                    )
                )
                {
                    Text(color = Color.Red, text="Voltar tela de login")
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TechnologyChip(technologyListState : SnapshotStateList<String>) {
    Technology.values().forEach { tecnologia ->
        FilterChip(
            label = {
                Text(tecnologia.name)
            },
            onClick = {
                Log.d("Assist chip", "Index: " + tecnologia.name)
                if(tecnologia.name in technologyListState){
                    val index = technologyListState.indexOf(tecnologia.name)
                    technologyListState.removeAt(index)
                }else{
                    technologyListState.add(tecnologia.name)
                }
            },
            selected = tecnologia.name in technologyListState,
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoftSkillChip(softSkillListState : SnapshotStateList<String>){
    SoftSkill.values().forEach { softskill ->
        FilterChip(
            label = {
                Text(softskill.name)
            },
            onClick = {
                Log.d("Assist chip", "Name: " + softskill.name)
                if(softskill.name in softSkillListState){
                    val index = softSkillListState.indexOf(softskill.name)
                    softSkillListState.removeAt(index)
                }else{
                    softSkillListState.add(softskill.name)
                }
            },
            selected = softskill.name in softSkillListState,
        )
    }
}

@Preview(
    name = "PreviewCadastroScreen",
    showBackground = true
)
@Composable
fun PreviewCadastroScreen() {
    MentorMatchTheme {
        val navController = rememberNavController()
        CadastroScreen(navController)
    }
}