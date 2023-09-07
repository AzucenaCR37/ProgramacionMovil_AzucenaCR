package com.example.diceroller_azucena_u3_progmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller_azucena_u3_progmovil.ui.theme.DiceRoller_Azucena_U3_ProgMovilTheme
import androidx.compose.material3.Button as Button1
import androidx.compose.material3.Text as Text1
import androidx.compose.ui.res.stringResource as stringResource1
import net.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                DiceRollerApp()
            }
        }
    }

}
@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) }
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Image(painter = painterResource(id = getRandomDiceImage(result)), contentDescription = result.toString())
            Image(painter = painterResource(id = getRandomDiceImage(result2)), contentDescription = result2.toString())
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button1(onClick = { result = (1..6).random(); result2 = (1..6).random() }) {
            Text1(stringResource1(R.string.roll))
        }
    }
}


private fun getRandomDiceImage(result: Int): Int{
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    return imageResource
}


