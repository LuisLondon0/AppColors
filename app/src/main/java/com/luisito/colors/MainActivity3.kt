package com.luisito.colors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyUI()
        }
    }
}

@Composable
fun MyUI(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        colorsSection()
        sliderSection(
            title = stringResource(R.string.Red),
            color = Color.Red,
            value = 102f
        )
        sliderSection(
            title = stringResource(R.string.Green),
            color = Color.Green,
            value = 153f
        )
        sliderSection(
            title = stringResource(R.string.Blue),
            color = Color.Blue,
            value = 204f
        )
        buttonSection(
            title = stringResource(R.string.Score)
        )
        buttonSection(
            title = stringResource(R.string.New)
        )
    }

}

@Composable
fun colorsSection(
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(R.string.Proposed_color),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = stringResource(R.string.Target_color),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun sliderSection(title: String,
                  color: Color,
                  value: Float
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){/*
        Text(
            text = title,
            modifier = Modifier
                .weight(0f)
        )*/
        Slider(
            value = value,
            onValueChange = {},
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTickColor = color,
                inactiveTickColor = Color.Gray
            ),
            modifier = Modifier
                .weight(1f)
        )/*
        Text(
            text = value.toString(),
            modifier = Modifier
                .weight(0f)
        )*/
    }
}

@Composable
fun buttonSection(
    title: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            onClick = { /*TODO*/ },
        ){
            Text(text = title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyUI()
}