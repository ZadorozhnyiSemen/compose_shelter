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