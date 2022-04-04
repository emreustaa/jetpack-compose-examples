package com.emreusta.composeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreusta.composeproject.ui.theme.ComposeProjectTheme

class YemekTarifi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Yazi(icerik = "Yemek Tarifi") },
                backgroundColor = colorResource(id = R.color.anaRenkYemek)
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.yemek), contentDescription = "")
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { Log.e("Button", "Beğenildi") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.anaRenkYemek)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Beğen")
                    }
                    Button(
                        onClick = { Log.e("Button", "Yorum Yapıldı") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.alternatifRenkYemek)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Yorum Yap")
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Köfte",
                        color = colorResource(id = R.color.alternatifRenkYemek),
                        fontSize = 18.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Yazi(icerik = "Izgaraya Uygun")
                        Yazi(icerik = "7 Haziran")
                    }
                }
                Text(
                    text = "Köfte harcını hazırlamak için, soğanları rendeleyin ve maydanozları ince ince kıyın, isterseniz, bir diş sarımsak da ekleyebilirsiniz.",
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}

@Composable
fun Yazi(icerik: String) {
    Text(text = icerik)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeProjectTheme {
        MainApp()
    }
}