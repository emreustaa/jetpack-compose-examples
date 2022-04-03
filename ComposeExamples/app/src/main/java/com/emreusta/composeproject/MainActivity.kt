package com.emreusta.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreusta.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //UseRow()
                    //UseColumn()
                    //UseBox()
                    //UseMixed()
                    //UseArrangement()
                    //UseAlignment()
                    //UseFillMax()
                    //UseAlign()
                    //UseSize()
                    //UseSpacer()
                    //UsePadding()
                    //UseWeight()
                    //UseCustomizedWidget()
                    UseLanguageSupport()
                }
            }
        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun DefaultPreview() {
    ComposeProjectTheme {
        //UseRow()
        //UseColumn()
        //UseBox()
        //UseMixed()
        //UseArrangement()
        //UseAlignment()
        //UseFillMax()
        //UseAlign()
        //UseSize()
        //UseSpacer()
        //UsePadding()
        //UseWeight()
        //UseCustomizedWidget()
        UseLanguageSupport()
    }
}

@Composable
fun UseLanguageSupport() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.textYazi), fontSize = 50.sp)
        Button(onClick = { }) {
            Text(text = stringResource(id = R.string.buttonYazi), fontSize = 24.sp)
        }
    }
}

@Composable
fun UseCustomizedWidget() {

    Column {
        KirmiziKare()
        YesilKare()
        Yazi("Merhaba", 50)
    }
}

@Composable
fun KirmiziKare() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
    )
}

@Composable
fun YesilKare() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
    )
}

@Composable
fun Yazi(icerik: String, boyut: Int) {
    Text(text = icerik, fontSize = boyut.sp)
}

@Composable
fun UseWeight() {

    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .weight(50f)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .weight(30f)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .weight(20f)
        )
    }
}

@Composable
fun UsePadding() {

    Row {
        Text(
            text = "Merhaba",
            modifier = Modifier.padding(start = 5.dp, end = 10.dp, top = 20.dp, bottom = 30.dp)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(80.dp, 200.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun UseSpacer() {

    Row {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Spacer(modifier = Modifier.size(100.dp, 200.dp))
        Box(
            modifier = Modifier
                .size(80.dp, 200.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun UseSize() {

    Row {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(80.dp, 200.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun UseAlign() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red)
    ) {
        Text(text = "Merhaba", modifier = Modifier.align(Alignment.TopEnd))
    }
}

@Composable
fun UseFillMax() {
    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun UseAlignment() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun UseArrangement() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun UseRow() {
    Row {
        Text("Merhaba")
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun UseColumn() {
    Column {
        Text("Merhaba")
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun UseBox() {
    Box {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
        )
        Text("Merhaba")
    }
}

@Composable
fun UseMixed() {
    Box {
        Box(
            modifier = Modifier
                .size(400.dp)
                .background(Color.White)
        )
        Column {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
            )
            Row {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Yellow)
                )
            }
        }
    }
}