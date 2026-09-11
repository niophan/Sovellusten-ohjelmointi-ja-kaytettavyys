package com.example.harjoitus_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyGUI()
        }
    }
}

@Preview
@Composable
fun MyGUI() {
    Column (modifier =  Modifier
        .fillMaxSize()
    ){
//     Heading
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.Cyan),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {

            Image(
                painter = painterResource(id = R.drawable.my_image),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .padding(10.dp)
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Column (
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = "Hello, Nhan Phan",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .wrapContentSize((Alignment.Center))
                )
                CommonText("What we are growing today?", 18)

            }
        }

//      Big Image
        Image(
            painter = painterResource(id = R.drawable.random_plant),
            contentDescription = "Plant Image",
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )



//        Description
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.Cyan)
                .padding(10.dp)

        ) {
            Text(
                text = "Plant AI",
                fontSize = 60.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .wrapContentSize((Alignment.Center))
            )
            CommonText(
                "Plant AI helps you identify plants, flowers, tree, and houseplants in seconds.",
                20,
                Modifier.padding(20.dp),
            )
            CommonButton("Browse ->")



        }
    }

}


@Composable
fun CommonText(text: String, fontSize: Int, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = Color.DarkGray,
        modifier = modifier
    )
}

@Composable
fun CommonButton(text: String) {
    Button(onClick = {}) {
        Text(
            text = text,
            fontSize = 20.sp,
        )
    }
}

