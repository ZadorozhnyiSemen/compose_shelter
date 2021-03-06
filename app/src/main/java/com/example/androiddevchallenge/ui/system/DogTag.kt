/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.DogsRepository
import com.example.androiddevchallenge.ui.theme.grayText
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.tagBackground
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun DogTag(
    text: String,
    modifier: Modifier = Modifier,
    tagTextStyle: TextStyle = MaterialTheme.typography.subtitle1
) {
    Surface(
        elevation = 0.dp,
        // modifier = Modifier.background(Color.Blue),
        shape = shapes.small
    ) {
        Box(modifier = Modifier.background(tagBackground)) {
            Text(
                modifier = modifier
                    .widthIn(max = 120.dp),
                text = text,
                style = tagTextStyle.copy(color = grayText),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DogTagSmallPreview() {
    val doge = DogsRepository.getDogById(1)
    DogTag(
        text = doge.age,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        tagTextStyle = typography.caption
    )
}

@Preview(showBackground = true)
@Composable
fun DogTagBigPreview() {
    val doge = DogsRepository.getDogById(1)
    DogTag(
        text = doge.age,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
        tagTextStyle = typography.body2
    )
}

@Preview(showBackground = true)
@Composable
fun DogTagLongTextPreview() {
    val doge = DogsRepository.getDogById(1)
    DogTag(
        text = doge.biography,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
        tagTextStyle = typography.body2
    )
}
