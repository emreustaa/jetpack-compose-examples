package com.emreusta.composeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.emreusta.composeproject.ui.theme.ComposeProjectTheme
import com.google.gson.Gson

class AppPageStructure : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SayfaGecisleri()
                }
            }
        }
    }
}

@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") {
            AnaSayfa(navController = navController)
        }
        composable(
            "sayfa_a/{nesne}", arguments = listOf(
                navArgument("nesne") { type = NavType.StringType },
            )
        ) {
            it.arguments?.let {
                with(it) {
                    val json = getString("nesne").orEmpty()
                    val nesne = Gson().fromJson(json, Kisiler::class.java)
                    SayfaA(navController = navController, nesne)
                }
            }
        }
        composable("sayfa_b") {
            SayfaB()
        }
    }
}

@Composable
fun AnaSayfa(navController: NavController) {

    val sayac = remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Ana Sayfa", fontSize = 50.sp)
        val kisi = Kisiler("Ahmet", 30, 1.78f, true)
        val kisiJson = Gson().toJson(kisi)
        Button(onClick = { navController.navigate("sayfa_a/$kisiJson") }) {
            Text(text = "Sayfa A'ya Git")
        }
        Text(text = "Sayac : ${sayac.value}")
        Button(onClick = { sayac.value = sayac.value + 1 }) {
            Text(text = "Arttır")
        }
    }

    LaunchedEffect(key1 = true) {
        Log.e("Anasayfa", "LaunchedEffect Çalıştı!")
    }

    SideEffect {
        Log.e("Anasayfa", "SideEffect Çalıştı!")
    }

    DisposableEffect(Unit) {
        onDispose {
            Log.e("Anasayfa", "DisposableEffect Çalıştı!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposeProjectTheme {
    }
}