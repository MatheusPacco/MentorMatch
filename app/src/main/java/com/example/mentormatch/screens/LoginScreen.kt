package com.example.mentormatch.screens

import android.content.res.Configuration
import android.util.Log
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.MentorMatchTheme
import com.example.mentormatch.R
import com.example.mentormatch.database.repository.UserRepository
import com.example.mentormatch.model.User

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val userRepository = UserRepository(context)

    var passwordVisible by remember {
        mutableStateOf(false)
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }
    var erro = remember {
        mutableStateOf("")
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "LOGIN",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Formulário de cadastro",
                fontSize = 26.sp,
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
                    Text(text = "Digite seu e-mail")
                },
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordState.value,
                onValueChange = { novoValor ->
                    passwordState.value = novoValor
                },
                label = { Text("Password") },
                placeholder = { Text("Password") },
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
            Spacer(modifier = Modifier.height(12.dp))
            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Button(
                    onClick = {
                        var userFind : User? = userRepository.buscarUsuarioPorEmailESenha(emailState.value, passwordState.value)
                        if(userFind != null){
                            Log.d("Usuário encontrado", userFind.toString())
                            navController.navigate("telaDeBusca/${userFind.id.toString()}")
                        }else{
                            erro.value = "Nenhum usuário encontrado com essas credenciais"
                            Log.d("Usuário NÃO encontrado", userFind.toString())
                        }
                    },
                    colors = if(isSystemInDarkTheme()) ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                    else ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    )
                }
                OutlinedButton(
                    onClick = { navController.navigate("cadastro") },
                ) {
                    Text(
                        text = "Criar uma conta",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                }
            }
            if(erro.value.length > 0){
                Text(
                    text = erro.value,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun LoginScreenPreview() {
    MentorMatchTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}