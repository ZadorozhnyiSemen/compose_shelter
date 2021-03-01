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
package com.example.androiddevchallenge.ui.screens.shelter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.DogsRepository
import com.example.androiddevchallenge.ui.system.DogCard
import com.example.androiddevchallenge.ui.system.StaggeredVerticalGrid
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.background2
import com.example.androiddevchallenge.ui.theme.blackText
import com.example.androiddevchallenge.ui.theme.blue500
import com.example.androiddevchallenge.ui.theme.typography

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Shelter(
    selectDog: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    MyTheme {
        val dogList = remember { DogsRepository.getAllDogs() }

        Scaffold(backgroundColor = background2) {
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    Modifier
                        .height(56.dp)
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Puppies",
                        modifier = Modifier.weight(2f),
                        style = typography.h1.copy(
                            fontSize = 24.sp,
                            lineHeight = 24.sp,
                            color = blackText
                        )
                    )
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_filter_24),
                        contentDescription = "Filter",
                        tint = blue500
                    )
                    Spacer(Modifier.width(16.dp))
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_search_24),
                        contentDescription = "Search",
                        tint = blue500
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(Modifier.padding(horizontal = 24.dp)) {
                    Text(
                        "${dogList.size} PUPPIES NEARBY",
                        style = typography.subtitle1.copy(
                            fontSize = 12.sp,
                            lineHeight = 14.sp,
                            color = blackText
                        )
                    )
                }
                StaggeredVerticalGrid(
                    modifier = Modifier.padding(12.dp),
                    maxColumnWidth = 220.dp
                ) {
                    dogList.forEach { dog ->
                        DogCard(dog, { selectDog(dog.id) })
                    }
                }
            }
        }
    }
}
