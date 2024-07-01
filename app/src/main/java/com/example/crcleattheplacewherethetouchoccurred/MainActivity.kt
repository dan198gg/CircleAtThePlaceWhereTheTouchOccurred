package com.example.crcleattheplacewherethetouchoccurred

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.crcleattheplacewherethetouchoccurred.ui.theme.CrcleAtThePlaceWhereTheTouchOccurredTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    val context= LocalContext.current
    var offset by remember {

        mutableStateOf(Offset(0f,0f))}
    var color by remember {
        mutableStateOf(Color.Yellow)
    }
    var isVisible by remember {
        mutableStateOf(false)
    }
    var corScope= rememberCoroutineScope()
    val mp:MediaPlayer=MediaPlayer.create(context, R.raw.skalazvuk)
//    var y1 by rememberSaveable {
//
//        mutableStateOf(0f)
//    }

//    var draw2=draw1(modifier = Modifier.size(200.dp).offset(
//         x1.dp,
//        y1.dp))
    Log.i("R2",offset.toString())
    Box( modifier = Modifier

        .pointerInput(Unit) {
            detectTapGestures(onTap =
            {
                offset = it
                Log.i("R", offset.toString())
                isVisible = !isVisible
                mp.start()
                corScope.launch {

                    delay(300)
                    isVisible = !isVisible


                }
            })
        }
        .fillMaxSize()
         ){
        var imageWidth=900
        var imageHeight=1920
        AnimatedVisibility(
            visible = isVisible,
            enter = scaleIn(animationSpec = tween(1000)),
            exit = fadeOut(animationSpec = tween(durationMillis = 1000)), modifier = Modifier.fillMaxSize()){
            Box(modifier = Modifier.size(imageWidth.dp,imageHeight.dp).offset(
                    x = with(LocalDensity.current) { -(imageWidth / 2).toDp() + offset.x.toDp() },
                y = with(LocalDensity.current) { -(imageHeight / 2).toDp() + offset.y.toDp() })) {
                Image(
                    painter = painterResource(id = R.drawable.skala),
                    contentDescription = "a1",
                    modifier = Modifier
                        .fillMaxSize()
                )

            }

            }


        }

        }



