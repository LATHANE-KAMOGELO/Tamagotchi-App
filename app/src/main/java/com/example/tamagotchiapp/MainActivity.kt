package com.example.tamagotchiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tamagotchiapp.ui.theme.TamagotchiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TamagotchiAppTheme {
                    TamagotchiApp()
                }
            }
        }
    }


@Composable
fun TamagotchiApp(modifier: Modifier = Modifier) {

    var showContent by remember { mutableStateOf(false) }
    var petImageId by remember { mutableStateOf(R.drawable.ai_generated_8476408_640) }
    var health by remember { mutableStateOf(0) }
    var hunger by remember { mutableStateOf(0) }
    var cleanliness by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showContent) {
            Text(
                text = "Welcome Pit",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Your Tamagotchi App",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        val petImage: Painter = painterResource(petImageId)

        Image(
            painter = petImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        if (showContent) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(onClick = {
                        petImageId = R.drawable.eating
                        hunger += 10
                        if (hunger > 100) hunger = 100
                    }) {
                        Text(text = "Feed")
                    }
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(color = Color.Gray)
                    ) {
                        Text(
                            text = "$hunger%",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(onClick = {
                        petImageId = R.drawable.cleanliness
                        cleanliness += 10
                        if (cleanliness > 100) cleanliness = 100
                    }) {
                        Text(text = "Clean")
                    }
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(color = Color.Gray)
                    ) {
                        Text(
                            text = "$cleanliness%",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(onClick = {
                        petImageId = R.drawable.health
                        health += 10
                        if (health > 100) health = 100
                    }) {
                        Text(text = "Play")
                    }
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(color = Color.Gray)
                    ) {
                        Text(
                            text = "$health%",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        } else {
            Button(
                onClick = { showContent = true },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "Get Started")
            }
        }
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TamagotchiAppTheme {
        TamagotchiApp()
    }
}