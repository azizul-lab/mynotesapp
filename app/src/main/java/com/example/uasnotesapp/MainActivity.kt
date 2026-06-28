package com.example.uasnotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// Ini adalah baris import yang sudah diperbaiki
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uasnotesapp.ui.theme.UASNotesAppTheme
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.compose.composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UASNotesAppTheme {
                val navController = rememberNavController()
                val auth = FirebaseAuth.getInstance()

                // Jika user sudah login sebelumnya, langsung lempar ke Home
                val startScreen = if (auth.currentUser != null) "home" else "login"

                NavHost(navController = navController, startDestination = startScreen) {
                    composable("login") {
                        LoginScreen(navController = navController)
                    }
                    composable("register") {
                        RegisterScreen(navController = navController)
                    }
                    composable("home") {
                        HomeScreen(navController = navController)
                    }
                    composable("add_note") {
                        AddNoteScreen(navController = navController)
                    }
                }
            }
        }
    }
}