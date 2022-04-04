package com.emreusta.composeproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SayfaA(
    navController: NavController,
    gelenNesne: Kisiler
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Sayfa A", fontSize = 50.sp)

        with(gelenNesne) {
            Text(text = isim)
            Text(text = "${yas}")
            Text(text = "${boy}")
            Text(text = "${bekarMi}")
        }
        Button(onClick = {
            navController.navigate("sayfa_b") {
                popUpTo("sayfa_a") { inclusive = true }
            }
        }) {
            Text(text = "Sayfa B'ya Git")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Geri Dön")
        }
    }
}