package com.farzin.meditationui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farzin.meditationui.BottomMenuContent
import com.farzin.meditationui.Features
import com.farzin.meditationui.R
import com.farzin.meditationui.standardQuadFromTo
import com.farzin.meditationui.ui.theme.*


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {

            GreetingSection()
            ChipIndex(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeaturedSection(features = listOf(
                Features(
                    title = "Sleep meditation",
                    drawableRes = R.drawable.ic_headphone,
                    lightColor = BlueViolet1,
                    mediumColor = BlueViolet2,
                    darkColor = BlueViolet3
                ),

                Features(
                    title = "Tips for Sleeping",
                    drawableRes = R.drawable.ic_videocam,
                    lightColor = LightGreen1,
                    mediumColor = LightGreen2,
                    darkColor = LightGreen3
                ),

                Features(
                    title = "Night island",
                    drawableRes = R.drawable.ic_headphone,
                    lightColor = OrangeYellow1,
                    mediumColor = OrangeYellow2,
                    darkColor = OrangeYellow3
                ),

                Features(
                    title = "Calming Sounds",
                    drawableRes = R.drawable.ic_headphone,
                    lightColor = Beige1,
                    mediumColor = Beige2,
                    darkColor = Beige3
                ),
            ))
        }
        BottomNavMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun GreetingSection(name: String = "Farzin") {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h5,
                color = TextWhite
            )

            Text(
                text = "We wish you a good day!",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            "",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun ChipIndex(chips: List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }


    LazyRow {

        items(chips.size) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }

    }

}


@Composable
fun CurrentMeditation(color: Color = LightRed) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {

        Column() {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h5,
                color = TextWhite
            )

            Text(
                text = "Meditation   3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
            )
        }

    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedSection(features: List<Features>) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h5,
            color = TextWhite,
            modifier = Modifier.padding(15.dp),
        )


        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.dp, end = 7.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            items(features.size) {

                FeaturesItem(features = features[it])
            }
        }
    }
}

@Composable
fun FeaturesItem(features: Features) {

    BoxWithConstraints(
        modifier = Modifier
            .padding(7.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(features.darkColor)
    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight


        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = features.mediumColor
            )

            drawPath(
                path = lightColoredPath,
                color = features.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = features.title,
                color = Color.White,
                modifier = Modifier.align(Alignment.TopStart),
                fontSize = 22.sp,
                lineHeight = 26.sp
            )

            Icon(
                painter = painterResource(id = features.drawableRes), contentDescription = "",
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }

    }

}

































