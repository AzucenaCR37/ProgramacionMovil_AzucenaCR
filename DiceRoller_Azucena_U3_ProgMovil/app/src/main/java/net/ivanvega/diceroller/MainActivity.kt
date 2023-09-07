package net.ivanvega.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.ivanvega.diceroller.ui.theme.DiceRollerTheme

//PROGRAMA QUE HACE QUE 2 DADOS GIREN ALEATORIAMENTE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

//función compsable que maneja la apariencia de los dados
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    var image1 by remember {mutableStateOf(R.drawable.dice_1)}
    var image2 by remember {mutableStateOf(R.drawable.dice_1)}

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row( modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = image1),
                contentDescription = stringResource(
                    R.string.imagen_de_dado
                )
            )
            Image(
                painter = painterResource(id = image2),
                contentDescription = stringResource(
                    R.string.imagen_de_dado
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                image1 = getRandomDiceImage()
                image2 = getRandomDiceImage()
            }
        ) {Text(stringResource(R.string.roll))}
    }
}

//FUNCIONES

//funcion que define una cara random para un dado
fun getRandomDiceImage(): Int {
    return when((1..6).random()){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

//posicionamiento de las imágenes/dados
@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}