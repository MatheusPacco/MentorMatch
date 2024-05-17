package com.example.mentormatch.screens

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.background
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
import com.example.mentormatch.R
import com.example.mentormatch.database.repository.UserRepository
import com.example.mentormatch.model.User
import com.example.mentormatch.ui.theme.MentorMatchTheme

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

    Surface (
        modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFED145B))
        .padding(16.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(0xFFED145B)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "LOGIN",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Formulário de cadastro",
                fontSize = 26.sp,
                color = Color.White
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
            Row {
                Button(
                    onClick = {
                        var userFind : User? = userRepository.buscarUsuarioPorEmailESenha(emailState.value, passwordState.value)
                        if(userFind != null){
                            Log.d("Usuário encontrado", userFind.toString())
                            navController.navigate("telaDeBusca/${userFind.id.toString()}")
                        }else{
                            Log.d("Usuário NÃO encontrado", userFind.toString())
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = Color.Blue
                    )
                }
                Button(
                    onClick = { navController.navigate("cadastro") },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "Criar uma conta",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = Color.Blue
                    )
                }
            }
        }
    }
}
@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginScreenPreview() {
    MentorMatchTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}