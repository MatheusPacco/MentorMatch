package com.example.mentormatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mentormatch.screens.CadastroScreen
import com.example.mentormatch.ui.theme.MentorMatchTheme

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
                        startDestination = "cadastro"
                    ){
                        composable("cadastro") { CadastroScreen(navController) }
                    }
                }
            }
        }
    }
}
