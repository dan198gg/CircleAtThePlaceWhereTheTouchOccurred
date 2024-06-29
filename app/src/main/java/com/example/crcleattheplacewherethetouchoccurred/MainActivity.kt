package com.example.crcleattheplacewherethetouchoccurred

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.crcleattheplacewherethetouchoccurred.ui.theme.CrcleAtThePlaceWhereTheTouchOccurredTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            canvas1()
        }
    }
}



//@Composable
//fun draw1(modifier: Modifier){
//    androidx.compose.foundation.Canvas(modifier) {
//         drawCircle(Color.Yellow, radius = 50f)
//    }
//}

@Composable
fun canvas1(){
    var x1 by rememberSaveable {

        mutableStateOf(0f)}
    var y1 by rememberSaveable {

        mutableStateOf(0f)
    }

//    var draw2=draw1(modifier = Modifier.size(200.dp).offset(
//         x1.dp,
//        y1.dp))
    Log.i("R2",x1.toString())
    Box( modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                x1 = it.x
                y1 = it.y
                Log.i("R", x1.toString())


            })
        }
         )

}

