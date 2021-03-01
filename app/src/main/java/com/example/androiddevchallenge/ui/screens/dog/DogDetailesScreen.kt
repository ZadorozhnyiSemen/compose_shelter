package com.example.androiddevchallenge.ui.screens.dog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.DogsRepository
import com.example.androiddevchallenge.data.entity.Dog
import com.example.androiddevchallenge.data.entity.ShelterContact
import com.example.androiddevchallenge.ui.system.DogTag
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.blackText
import com.example.androiddevchallenge.ui.theme.blue500
import com.example.androiddevchallenge.ui.theme.contentShapes
import com.example.androiddevchallenge.ui.theme.divider
import com.example.androiddevchallenge.ui.theme.grayText
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.whiteText

@Composable
fun DogDetails(
    dogId: Int,
    upPress: () -> Unit
) {
    // Simplified for the sample
    var dog = remember(dogId) { mutableStateOf(DogsRepository.getDogById(dogId)) }
    DogInfo(dog.value, upPress) {
        val newValue = !dog.value.inFavorite
        dog.value = dog.value.copy(inFavorite = newValue)
        DogsRepository.setFavorite(dog.value.id, newValue)
    }
}

@Composable
fun DogInfo(dog: Dog, upPress: () -> Unit, favoritePress: () -> Unit) {
    MyTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(white)
        ) {
            val scroll = rememberScrollState(0)
            Column(
                Modifier
                    .verticalScroll(scroll)
                    .padding(horizontal = 24.dp, vertical = 56.dp)
                    .fillMaxSize()
            ) {
                Image(
                    modifier = Modifier
                        .size(360.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = dog.profilePhoto),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    dog.name,
                    style = typography.h1.copy(
                        fontSize = 24.sp,
                        lineHeight = 24.sp,
                        color = blackText
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    dog.breed,
                    style = typography.caption.copy(
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        color = grayText
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    DogTag(
                        text = dog.sex.asString(),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        tagTextStyle = typography.caption.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.sp,
                            color = grayText
                        )
                    )
                    Spacer(Modifier.width(8.dp))
                    DogTag(
                        text = dog.age,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        tagTextStyle = typography.caption.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.sp,
                            color = grayText
                        )
                    )
                    Spacer(Modifier.width(8.dp))
                    DogTag(
                        text = dog.weight,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        tagTextStyle = typography.caption.copy(
                            fontSize = 16.sp,
                            lineHeight = 19.sp,
                            color = grayText
                        )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "Behaviour specifics",
                    style = typography.caption.copy(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = grayText
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    dog.behavior,
                    style = typography.caption.copy(
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        color = blackText
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "Health",
                    style = typography.caption.copy(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = grayText
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    dog.healthCondition,
                    style = typography.caption.copy(
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        color = blackText
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "Biography",
                    style = typography.caption.copy(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = grayText
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    dog.biography,
                    style = typography.caption.copy(
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        color = blackText
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = divider)
                Spacer(modifier = Modifier.height(24.dp))
                ShelterContact(dog.shelterContact)
                Spacer(modifier = Modifier.height(32.dp))
            }
            DetailsTopBar(
                dog, upPress, favoritePress, scroll, 60.dp,
                Modifier
                    .height(56.dp)
                    .fillMaxWidth()
            )
            AdoptButton(
                Modifier
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun AdoptButton(modifier: Modifier = Modifier) {
    Surface(modifier = modifier, elevation = 4.dp, shape = shapes.large) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .clickable(onClick = {})
                .background(blue500)
        ) {
            Text(
                "Adopt me",
                style = typography.h1.copy(fontSize = 16.sp, lineHeight = 24.sp, color = whiteText)
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DetailsTopBar(
    dog: Dog,
    upPress: () -> Unit,
    favoritePress: () -> Unit,
    scroll: ScrollState,
    activeAfter: Dp,
    modifier: Modifier = Modifier
) {
    val size = with(LocalDensity.current) { activeAfter.roundToPx() }
    val active = scroll.value > size
    println(scroll.value)
    println(active)

    val color: Color by animateColorAsState(targetValue = if (active) white else Color.Transparent)
    val elevation: Dp by animateDpAsState(targetValue = if (active) 4.dp else 0.dp)

    Surface(
        modifier = modifier
            .background(color)
            .zIndex(with(LocalDensity.current) { elevation.toPx() }),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .weight(2f)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_arrow_back_24dp),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = upPress)
                        .width(48.dp)
                        .height(48.dp)
                        .padding(12.dp)
                        .weight(1f),
                    tint = blue500
                )
                if (!active) {
                    Spacer(modifier = Modifier.weight(5f))
                } else {
                    Text(
                        dog.name,
                        modifier = Modifier.weight(5f),
                        style = typography.subtitle2.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            lineHeight = 18.sp,
                            letterSpacing = 0.01.em
                        )
                    )
                }

                val icon =
                    if (dog.inFavorite) R.drawable.ic_favorite_24dp else R.drawable.ic_favorite_border_24dp
                Icon(
                    painterResource(id = icon), contentDescription = null, modifier = Modifier
                        .clickable(onClick = favoritePress)
                        .weight(1f)
                        .width(48.dp)
                        .height(48.dp)
                        .padding(12.dp), tint = blue500
                )
            }
            AnimatedVisibility(visible = active) {
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
            }
        }
    }
}

@Composable
fun ShelterContact(contact: ShelterContact, modifier: Modifier = Modifier) {
    Column {
        Text(
            "Contacts", style = typography.caption.copy(
                fontSize = 12.sp,
                lineHeight = 14.sp,
                color = grayText
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        ShelterAgentInfo(contact, Modifier.fillMaxWidth())
    }
}

@Composable
fun ShelterAgentInfo(contact: ShelterContact, modifier: Modifier) {
    Row(
        modifier = modifier.clickable(onClick = {}),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(56.dp),
            elevation = 0.dp,
            shape = contentShapes.small
        ) {
            Image(
                painter = painterResource(id = contact.photo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(modifier = Modifier.weight(2f), verticalArrangement = Arrangement.Center) {
            Text(
                contact.name, style = typography.h6.copy(
                    fontSize = 16.sp,
                    lineHeight = 19.sp,
                    color = blackText
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "Shelter’s representative", style = typography.caption.copy(
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = grayText
                )
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_call_24dp),
            contentDescription = null,
            tint = blue500
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun ContactsPreview() {
    val contact = ShelterContact("Jhon", R.drawable.profile_photo)
    ShelterContact(contact = contact, modifier = Modifier.width(360.dp))
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun AgentPreview() {
    val contact = ShelterContact("Jhon", R.drawable.profile_photo)
    ShelterAgentInfo(contact = contact, modifier = Modifier.width(360.dp))
}
