package com.example.laboratorio13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio13.ui.theme.Laboratorio13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio13Theme {
                SizeAndPositionAnimationExample()
            }
        }
    }
}

@Composable
fun SizeAndPositionAnimationExample() {
    var isExpanded by remember { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp,
        animationSpec = tween(durationMillis = 1000)
    )
    val offset by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { isExpanded = !isExpanded }) {
            Text(text = "Animate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offset, y = offset)
                .background(Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SizeAndPositionAnimationExamplePreview() {
    Laboratorio13Theme {
        SizeAndPositionAnimationExample()
    }
}