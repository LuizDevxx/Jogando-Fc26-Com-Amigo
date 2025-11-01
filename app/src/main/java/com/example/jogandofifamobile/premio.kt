package com.example.jogandofifamobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Premio(navController: NavController, ganhador: String) {
    var resultado by remember { mutableStateOf(0) }
    var perdedor by remember { mutableStateOf("") }

    val lanches = when (resultado) {
        0 -> R.drawable.sem_t_tulo
        1 -> R.drawable.espetinhos
        2 -> R.drawable.pizza
        3 -> R.drawable.comida_japonesa
        4 -> R.drawable.acai
        else -> R.drawable.hamburguer_e_fritas
    }

    var nomeLanches = when(resultado){
        0->"Lanches"
        1->"Espetinhos"
        2->"Pizza"
        3->"Comida japonesa"
        4->"Açai"
        else -> "Hamburguer"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF0B132B)),// Oxford Blue
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 150.dp, bottomEnd = 150.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.fundo_premio),
                contentDescription = "Fundo do premio",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(30.dp)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$nomeLanches",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                )
                Image(
                    painter = painterResource(lanches),
                    contentDescription = "Sorteio de lanches",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "🏆 jogador $ganhador ganhou!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                if (ganhador=="1"){
                  perdedor="2"
                }else{
                    perdedor="1"
                }
                Text(
                    text = "😅 jogador $perdedor perdeu... agora tem que pagar em kkk",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                var cont by remember { mutableStateOf(0) }

                Button(onClick = {
                    if (cont<1) {
                        cont++
                        resultado = (1..6).random()
                    }

                },
                        colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                        )
                )
                {
                    Text("Sorteio",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
