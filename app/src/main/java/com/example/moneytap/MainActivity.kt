package com.example.moneytap

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneytap.ui.theme.MoneyTapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val reqContext = LocalContext.current
            var moneyAdd by remember{
                mutableStateOf(0)
            }
            MoneyTapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        MainText(content = moneyAdd,"$")
                        Spacer(modifier = Modifier.height(60.dp))
                        CircleButton(title = "Tap", reqContext,moneyAdd){
                            moneyAdd += 1
                        }
}
                }
            }
        }
    }
}

@Composable
fun CircleButton(title: String, context : Context, moneyAdd : Int = 0, updateMonneyCounter :(Int) -> Unit) {

    Button(
        onClick = {
             Toast.makeText(context, "tap-tap", Toast.LENGTH_SHORT).show()
//            moneyAdd +=10
            updateMonneyCounter(moneyAdd)
            Log.d("counter", "CircleButton: $moneyAdd")
        },
        Modifier
            .size(150.dp)
            .padding(10.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Tap",
            fontFamily = FontFamily.Monospace,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
@Composable
fun MainText(content : Int,currency:String ){
    Text(
        text = "$currency$content",
        Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        color = Color.Blue,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center,
        fontSize = 40.sp
    )
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoneyTapTheme {

    }
}