package com.example.mentormatch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.MentorMatchTheme
import com.example.mentormatch.database.repository.UserRepository
import com.example.mentormatch.repository.getAllUsers
import com.example.mentormatch.screens.CadastroScreen
import com.example.mentormatch.screens.LoginScreen
import com.example.mentormatch.screens.MatchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorMatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable("login") { LoginScreen(navController = navController)}
                        composable("cadastro") { CadastroScreen(navController = navController)}
                        composable("telaDeBusca/{idUser}") {
                            val idUser: String? = it.arguments?.getString("idUser", "")
                            Log.d("Valor da Rota", idUser!!)
                            MatchScreen(navController = navController, idUser!!)
                        }
                    }
                }
            }
        }
    }
}
