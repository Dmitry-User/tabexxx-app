package com.tabex.promax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity: ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent { App() }
 }
}

@Composable
fun App() {
 var day by remember { mutableStateOf(1) }
 var taken by remember { mutableStateOf(0) }
 val total = 6

 Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

  Text("День $day / 25")

  Canvas(modifier = Modifier.size(180.dp)) {
   drawArc(Color.LightGray,0f,360f,false)
   drawArc(Color.Green,-90f,(taken/total.toFloat())*360f,false)
  }

  Spacer(Modifier.height(16.dp))

  Row {
   repeat(total) {
    Box(
     Modifier.size(12.dp).padding(3.dp).background(
      if(it < taken) Color.Green else Color.Gray,
      CircleShape
     )
    )
   }
  }

  Spacer(Modifier.height(20.dp))

  Button(onClick={
   if(taken < total) taken++ else { taken=0; day++ }
  }) {
   Text("Принял таблетку")
  }
 }
}
