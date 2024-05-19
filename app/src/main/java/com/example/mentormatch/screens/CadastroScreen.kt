package com.example.mentormatch.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.MentorMatchTheme
import com.example.mentormatch.R
import com.example.mentormatch.database.repository.UserRepository
import com.example.mentormatch.enums.SoftSkill
import com.example.mentormatch.enums.Technology
import com.example.mentormatch.model.User

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CadastroScreen(navController: NavHostController) {
    Surface (
        modifier = Modifier.fillMaxSize(),
    ){
        val context = LocalContext.current
        val userRepository = UserRepository(context)

        var genderState = remember{
            mutableStateOf("Feminino")
        }
        var nome = remember {
            mutableStateOf("")
        }
        var emailState = remember {
            mutableStateOf("")
        }
        var age = remember {
            mutableStateOf("0")
        }
        var typeUser =  remember {
            mutableStateOf("Aprendiz")
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
        var passwordState = remember {
            mutableStateOf("")
        }
        var passwordVisible by remember {
            mutableStateOf(false)
        }
        var error = remember{
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

                value = emailState.value,
                onValueChange = { novoValor ->
                    emailState.value = novoValor
                },
                label = {
                    Text(text = "Digite seu e-mail")
                },
                placeholder = {
                    Text(text = "Digite o seu e-mail")
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

                RadioButton(
                    selected = genderState.value == "Masculino",
                    onClick = {
                        genderState.value = "Masculino"
                    },
                    colors = if(isSystemInDarkTheme()) RadioButtonDefaults.colors(MaterialTheme.colorScheme.secondary)
                    else RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
                )
                Text(text="Masculino")

                RadioButton(
                    selected = genderState.value == "Feminino",
                    onClick = {
                        genderState.value = "Feminino"
                    },
                    colors = if(isSystemInDarkTheme()) RadioButtonDefaults.colors(MaterialTheme.colorScheme.secondary)
                    else RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
                )
                Text(text="Feminino")
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
                    selected = typeUser.value == "Mentor",
                    onClick = {
                        typeUser.value = "Mentor"
                    },
                    colors = if(isSystemInDarkTheme()) RadioButtonDefaults.colors(MaterialTheme.colorScheme.secondary)
                    else RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
                )
                Text(text="Mentor")
                RadioButton(
                    selected = typeUser.value == "Aprendiz",
                    onClick = {
                        typeUser.value = "Aprendiz"
                    },
                    colors = if(isSystemInDarkTheme()) RadioButtonDefaults.colors(MaterialTheme.colorScheme.secondary)
                    else RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
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
            if(error.value != ""){
                Text(color = Color.Red, text=error.value)
                Spacer(modifier = Modifier
                    .height(8.dp)
                )
            }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordState.value,
                onValueChange = { novoValor ->
                    passwordState.value = novoValor
                },
                label = { Text("Digite uma senha") },
                placeholder = { Text("Digite uma senha") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        R.drawable.visibility
                    else R.drawable.visibility_off

                    IconButton(
                        onClick = {passwordVisible = !passwordVisible}
                    ){
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = null
                        )
                    }
                }
            )
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            )
            {
                Button(
                    onClick = {
                        try{
                            if(technologyListState.toList().isEmpty()){
                                throw  Throwable("Lista de tecnologias vazia!")
                            }

                            if(softSkillListState.toList().isEmpty()){
                                throw  Throwable("Lista de tecnologias vazia!")
                            }

                            val user:User = User(
                                name = nome.value,
                                email = emailState.value,
                                password = passwordState.value,
                                age = age.value.toInt(),
                                gender = genderState.value,
                                typeUser = typeUser.value,
                                description = description.value,
                                goal = goal.value,
                                technologies = technologyListState.toMutableList(),
                                softSkills = softSkillListState.toMutableList()
                            )

                            userRepository.salvar(user);

                            // Jogar usuário para a home Screen
                            navController.navigate("login")

                            Log.d("Usuário criado", user.toString())
                        }catch(e:Throwable){
                            Log.e("Erro para criação de perfil: ",  e.toString())
                            error.value = e.message!!;
                        }
                    },
                    colors = if(isSystemInDarkTheme()) ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary) else ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                )
                {
                    Text(text="Criar perfil")
                }
                OutlinedButton(
                    onClick = {
                        navController.navigate("login")
                    },
                    border = if(isSystemInDarkTheme()) BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
                    else BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                )
                {
                    Text(text="Voltar tela de login")
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
                Text(softskill.titulo)
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
    showBackground = true,
    heightDp = 2000
)
@Composable
fun PreviewCadastroScreen() {
    MentorMatchTheme {
        val navController = rememberNavController()
        CadastroScreen(navController)
    }
}