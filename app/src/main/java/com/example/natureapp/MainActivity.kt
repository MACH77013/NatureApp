package com.example.natureapp

import com.example.natureapp.models.Place
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureApp()
        }
    }
}

val places = listOf(
    Place("Dulce Reino", "Gobernado por la Dulce Princesa, este reino está hecho principalmente de caramelos y dulces. Los habitantes son criaturas de azúcar y golosinas vivientes. Es uno de los lugares más pacíficos de Ooo, aunque también ha sido escenario de varios conflictos.", "https://static.wikia.nocookie.net/horadeaventura/images/6/66/HDD1.png/revision/latest?cb=20160920192134&path-prefix=es"),
    Place("Reino Helado", "Hogar del Rey Helado, este reino está cubierto de hielo y nieve perpetua. Aunque parece inofensivo, el Rey Helado es una figura importante que vive en un castillo de hielo y constantemente crea problemas con sus poderes de congelación.", "https://static.wikia.nocookie.net/horadeaventura/images/7/7e/Ice_Kingdom.png/revision/latest?cb=20120108175034&path-prefix=es"),
    Place("El Reino de Fuego", "Es el hogar de la Princesa Flama y sus súbditos, todos hechos de fuego y lava. El reino está constantemente rodeado de llamas y magma, lo que lo convierte en un lugar hostil para aquellos que no están acostumbrados a su calor extremo. A pesar de su aspecto peligroso, tiene una estructura social compleja y relaciones diplomáticas con otros reinos de Ooo.", "https://static.wikia.nocookie.net/horadeaventura/images/6/6a/S7e32_Fire_Kingdom.png/revision/latest?cb=20160525231014&path-prefix=es"),
    Place("La Nocheosfera", "Un reino infernal gobernado por el temible Hunson Abadeer, padre de Marceline. La Nocheosfera es un lugar caótico lleno de demonios y criaturas aterradoras, que representa el caos puro. Es un lugar muy importante en la historia de Marceline, ya que está vinculado con su linaje y poderes demoníacos.", "https://static.wikia.nocookie.net/horadeaventura/images/3/3e/DRAN53.png/revision/latest?cb=20140412171939&path-prefix=es"),
    Place("Dimension de Cristal", " Es un reino misterioso donde todo está hecho de cristal, incluido su gobernante, el Rey Cristal. Este lugar tiene una atmósfera brillante y reluciente, pero es también peligroso, ya que los visitantes corren el riesgo de ser transformados en estatuas de cristal si rompen sus leyes. Finn fue atrapado aquí en uno de los episodios, y Jake tuvo que rescatarlo.", "https://static.wikia.nocookie.net/horadeaventura/images/c/c3/Crystal_Dimension.jpg/revision/latest?cb=20120308180614&path-prefix=es")
)


@Composable
fun NatureApp() {
    MaterialTheme {
        LazyColumn {
            items(places) { place ->
                PlaceCard(place)
            }
        }
    }
}

@Composable
fun PlaceCard(place: Place) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column {
            Image(
                painter = rememberImagePainter(place.imageUrl),
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = place.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = place.description,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
