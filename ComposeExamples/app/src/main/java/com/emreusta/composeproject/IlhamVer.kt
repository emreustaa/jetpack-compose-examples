package com.emreusta.composeproject

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreusta.composeproject.ui.theme.ComposeProjectTheme

class IlhamVer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "İlham Ver") },
            backgroundColor = colorResource(id = R.color.anaRenk),
            contentColor = colorResource(id = R.color.white)
        )
    }, content = {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.stevejobs), contentDescription = "")
                Text(
                    text = "Steve Jobs",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }
            Text(
                text = "Dünyayı değiştirecek insanlar, onu değiştirebileceklerini düşünecek kadar çılgın olanlardır.",
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center
            )
            Button(
                onClick = {
                    Log.e("Button", "İlham Verildi")
                }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "İlham Ver")
            }
        }
    })

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeProjectTheme {
        Page()
    }
}