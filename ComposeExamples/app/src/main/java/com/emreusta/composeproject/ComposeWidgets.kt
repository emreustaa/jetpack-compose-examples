package com.emreusta.composeproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.emreusta.composeproject.ui.theme.ComposeProjectTheme

class ComposeWidgets : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SayfaWebView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposeProjectTheme {
        SayfaWebView()
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun SayfaWebView() {
    val url = "https://gelecegiyazanlar.turkcell.com.tr"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}

@Composable
fun SayfaProgressVeSlider() {

    val progressDurum = remember { mutableStateOf(false) }
    val sliderDeger = remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (progressDurum.value) {
            CircularProgressIndicator(color = Color.Red)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {
                progressDurum.value = true
            }) {
                Text(text = "Başla")
            }

            Button(onClick = {
                progressDurum.value = false
            }) {
                Text(text = "Dur")
            }

        }
        Text(text = "Sonuç : ${sliderDeger.value.toInt()}")

        Slider(
            value = sliderDeger.value,
            onValueChange = { sliderDeger.value = it },
            valueRange = 0f..100f,
            modifier = Modifier.padding(20.dp),
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.Black
            )
        )

        Button(onClick = {
            Log.e("Slider", sliderDeger.value.toInt().toString())
        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaRadioButton() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val secilenIndex = remember { mutableStateOf(0) }
        val takimListesi = listOf("Real Madrid", "Barcelona")

        Column {
            takimListesi.forEachIndexed { index, takim ->
                Row(modifier = Modifier.clickable {
                    secilenIndex.value = index
                    Log.e("RadioButton seçildi", takim)
                }) {
                    RadioButton(
                        selected = (takim == takimListesi[secilenIndex.value]),
                        onClick = {
                            secilenIndex.value = index
                            Log.e("RadioButton seçildi", takim)
                        })
                    Text(text = takim)
                }
            }
        }

        Button(onClick = {
            Log.e("Rb En Son Durum", takimListesi[secilenIndex.value])
        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaClickable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            Log.e("Box", "Tıklandı")
                        },
                        onDoubleTap = {
                            Log.e("Box", "İki Kere Tıklandı")
                        },
                        onLongPress = {
                            Log.e("Box", "Üzerine Uzun Basıldı")
                        }
                    )
                }
        )
    }
}

@Composable
fun SayfaCheckBox() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val cbDurum = remember {
            mutableStateOf(false)
        }
        Row {
            Checkbox(
                checked = cbDurum.value,
                onCheckedChange = {
                    cbDurum.value = it
                    Log.e("CheckBox seçildi", it.toString())
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red
                )
            )
            Text(text = "Jetpack Compose", modifier = Modifier.padding(start = 10.dp))
        }
        Button(onClick = {
            Log.e("CheckBox En Son Durum", cbDurum.value.toString())
        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaSwitch() {
    val switchStatus = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = switchStatus.value,
            onCheckedChange = {
                switchStatus.value = it
                Log.e("Switch Seçildi", it.toString())
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Red,
                checkedThumbColor = Color.Blue,
                uncheckedTrackColor = Color.Green,
                uncheckedThumbColor = Color.Black

            )
        )

        Button(onClick = {
            Log.e("Switch En Son Durum", switchStatus.value.toString())
        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaFab() {
    Scaffold(
        content = {

        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { Log.e("FAB", "Tıklandı") },
                text = { Text(text = "Ekle", color = Color.White) },
                backgroundColor = Color.Red,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )
        })
}

@Composable
fun SayfaButtonTextTextField() {

    val tfData = remember { mutableStateOf("") }
    val tfDataOutlined = remember { mutableStateOf("") }

    val alinanVeri = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Gelen Veri : ${alinanVeri.value}",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                background = Color.Blue
            )
        )

        TextField(
            value = tfData.value,
            onValueChange = { tfData.value = it },
            label = { Text(text = "Veri Giriniz") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Gray,
                textColor = Color.Red,
                focusedIndicatorColor = Color.Green,
                focusedLabelColor = Color.Yellow
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                alinanVeri.value = tfData.value
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Veriyi Al")
        }

        OutlinedTextField(
            value = tfDataOutlined.value,
            onValueChange = { tfDataOutlined.value = it },
            label = { Text(text = "Veri Giriniz") })

        OutlinedButton(
            onClick = {
                alinanVeri.value = tfDataOutlined.value
            }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Veriyi Al Outlined")
        }
    }
}

