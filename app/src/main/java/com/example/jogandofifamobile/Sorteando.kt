package com.example.jogandofifamobile

import android.R.attr.label
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Sorteando(navController: NavController) {
    var sorteio by remember { mutableStateOf(1) }
    var sorteioDois by remember { mutableStateOf(2) }

    val time = when (sorteio) {
        1 -> R.drawable.fc26_barcelona
        2 -> R.drawable.fc26_real
        3 -> R.drawable.fc26_city
        4 -> R.drawable.fc26_bayern
        5 -> R.drawable.fc26_chelsea
        6 -> R.drawable.fc26_united
        7 -> R.drawable.fc26_inter
        8 -> R.drawable.fc26_juventus
        9 -> R.drawable.fc26_borussia
        10 -> R.drawable.fc26_milan
        11 -> R.drawable.fc26_liverpool
        else -> R.drawable.fc26_psg
    }
    val nomeTime = when (sorteio) {
        1 -> "Barcelona"
        2 -> "Real Madrid"
        3 -> "M. City"
        4 -> "Bayern M."
        5 -> "Chelsea"
        6 -> "M. United"
        7 -> "Inter M."
        8 -> "Juventus"
        9 -> "Borussia D."
        10 -> "Milan"
        11 -> "Liverpool"
        else -> "PSG"
    }

    val timeDois = when (sorteioDois) {
        1 -> R.drawable.fc26_barcelona
        2 -> R.drawable.fc26_real
        3 -> R.drawable.fc26_city
        4 -> R.drawable.fc26_bayern
        5 -> R.drawable.fc26_chelsea
        6 -> R.drawable.fc26_united
        7 -> R.drawable.fc26_inter
        8 -> R.drawable.fc26_juventus
        9 -> R.drawable.fc26_borussia
        10 -> R.drawable.fc26_milan
        11 -> R.drawable.fc26_liverpool
        else -> R.drawable.fc26_psg
    }
    val nomeTime2 = when (sorteioDois) {
        1 -> "Barcelona"
        2 -> "Real Madrid"
        3 -> "M. City"
        4 -> "Bayern M."
        5 -> "Chelsea"
        6 -> "M. United"
        7 -> "Inter M."
        8 -> "Juventus"
        9 -> "Borussia D."
        10 -> "Milan"
        11 -> "Liverpool"
        else -> "PSG"
    }

    var placar by remember { mutableStateOf("") }
    var placarDois by remember { mutableStateOf("") }

    var mensagemErro by remember { mutableStateOf("") }
    var ganhador by remember { mutableStateOf(0) }



    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.easportsfc26scr),
            contentDescription = "Fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(width = 300.dp, height = 100.dp)
                    .clip(RoundedCornerShape(50.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fundo),
                    contentDescription = "Campo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "X1 DOS CRIAS",
                    color = Color.White,
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = nomeTime, color = Color.White, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(time),
                            contentDescription = nomeTime,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(RoundedCornerShape(100.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        value = placar,
                        onValueChange = {
                            if (it.all { char -> char.isDigit() }) {
                                placar = it
                            }
                        },
                        label = { Text("Placar") },
                        singleLine = true,
                        modifier = Modifier.size(width = 80.dp, height = 56.dp)
                    )

                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = nomeTime2, color = Color.White, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(timeDois),
                            contentDescription = nomeTime2,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(RoundedCornerShape(100.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        value = placarDois,
                        onValueChange = {
                            if (it.all { char -> char.isDigit() }) {
                                placarDois = it
                            }
                        },
                        label = { Text("Placar") },
                        singleLine = true,
                        modifier = Modifier.size(width = 80.dp, height = 56.dp)
                    )
                }
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                        sorteio = (1..12).random()
                        sorteioDois = (1..12).random()
                    },
                    modifier = Modifier
                        .padding(bottom = 30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text("Sortear Times",
                        color = Color.White,
                        fontSize = 15.sp)
                }
                if (placar == placarDois && placar.isNotEmpty() && placarDois.isNotEmpty()){
                    Text(
                        text = "Gere outro time e desempate",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                        if (placar.isNotEmpty() && placarDois.isNotEmpty()&&placarDois !=placar) {

                            ganhador = when {
                                placar > placarDois-> 1
                                else -> 2
                            }
                            navController.navigate("premio/$ganhador")
                        } else {
                            mensagemErro = "Digite o placar"
                        }
                    },
                    modifier = Modifier
                        .size(width = 200.dp, height = 60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)

                ) {
                    Text("Confirmar placar",
                        color = Color.White,
                        fontSize = 20.sp)

                }

                if (mensagemErro.isNotEmpty()) {
                    Text(
                        text = mensagemErro,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}