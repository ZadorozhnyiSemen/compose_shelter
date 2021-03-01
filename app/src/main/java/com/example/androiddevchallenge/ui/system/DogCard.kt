package com.example.androiddevchallenge.ui.system

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.entity.Dog
import com.example.androiddevchallenge.data.entity.Sex
import com.example.androiddevchallenge.data.entity.ShelterContact
import com.example.androiddevchallenge.ui.theme.blackText
import com.example.androiddevchallenge.ui.theme.contentShapes
import com.example.androiddevchallenge.ui.theme.grayText
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun DogCard(
    dog: Dog,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        elevation = 4.dp,
        shape = shapes.medium,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = modifier
                .clickable(onClick = onClick)
                .height(233.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .height(164.dp),
                painter = painterResource(id = dog.frontPhoto),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Surface(
                elevation = 0.dp,
                shape = contentShapes.medium,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(97.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(white)
                        .padding(12.dp),
                ) {
                    Text(
                        dog.name,
                        style = typography.h2.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.sp,
                            color = blackText
                        )
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        dog.breed,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = typography.caption.copy(
                            fontSize = 12.sp,
                            lineHeight = 14.sp,
                            color = grayText
                        )
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        val sex = when (dog.sex) {
                            Sex.Female -> "Female"
                            Sex.Male -> "Male"
                        }

                        DogTag(
                            text = sex,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            tagTextStyle = typography.caption.copy(
                                fontSize = 12.sp,
                                lineHeight = 14.sp,
                                color = grayText
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        DogTag(
                            text = dog.age,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            tagTextStyle = typography.caption.copy(
                                fontSize = 12.sp,
                                lineHeight = 14.sp,
                                color = grayText
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    name = "Dog Card preview",
    widthDp = 158,
    heightDp = 237,
    showBackground = true
)
@Composable
fun DogCardPreview() {
    val doggie = Dog(
        0,
        R.drawable.test,
        R.drawable.test,
        "Lottie",
        "Shepard",
        Sex.Female,
        "7 month",
        "12kg",
        "Loves to lick",
        "Happy healthy dog",
        "Lorem ipsum",
        ShelterContact("Guiness", R.drawable.profile_photo)
    )

    DogCard(dog = doggie, onClick = {})
}

