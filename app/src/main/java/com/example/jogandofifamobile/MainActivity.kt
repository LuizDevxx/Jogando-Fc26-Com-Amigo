package com.example.jogandofifamobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogandofifamobile.ui.theme.JogandoFifaMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogandoFifaMobileTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable("inicio") {
                        Inicio(navController)
                    }
                    composable("sorteando") {
                        Sorteando(navController)
                    }
                    composable("premio/{ganhador}") { backStackEntry ->
                        val ganhador = backStackEntry.arguments?.getString("ganhador") ?: "Empate"
                        Premio(navController, ganhador)
                    }
                }

            }
        }
    }
}

@Composable
fun Inicio(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier
                .fillMaxSize(),
        ){
            Image(
                painter = painterResource(R.drawable.fifa26_palmer),
                contentDescription = "Imagem superior do Vini jn",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.Crop

            )
            Image(
                painter = painterResource(R.drawable.fc26_estadio),
                contentDescription = "Imagem do meio Estadio",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(R.drawable.fc26_arnold),
                contentDescription = "Imagem do Palmer Gelado",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.Crop

            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier
                    .size(275.dp)
                    .offset(y = (-20.dp))

            ){
                Image(
                    painter = painterResource(R.drawable.fifa26_logo),
                    contentDescription = "Logo do fifa 26",
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .clickable{
                            navController.navigate(route = "sorteando")
                        }

                )

            }
        }
    }
}