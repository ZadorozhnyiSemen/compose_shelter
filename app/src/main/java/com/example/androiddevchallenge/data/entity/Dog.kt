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
package com.example.androiddevchallenge.data.entity

import androidx.annotation.DrawableRes

data class Dog(
    val id: Int,
    @DrawableRes val frontPhoto: Int,
    @DrawableRes val profilePhoto: Int,
    val name: String,
    val breed: String,
    val sex: Sex,
    val age: String,
    val weight: String,
    val behavior: String,
    val healthCondition: String,
    val biography: String,
    val shelterContact: ShelterContact,
    var inFavorite: Boolean = false
)

sealed class Sex {
    object Female : Sex() {
        override fun asString(): String = "Female"
    }

    object Male : Sex() {
        override fun asString(): String = "Male"
    }

    abstract fun asString(): String
}
