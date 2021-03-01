package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.entity.Dog
import com.example.androiddevchallenge.data.entity.Sex
import com.example.androiddevchallenge.data.entity.ShelterContact

object DogsRepository {

    private val dogs by lazy { populate() }

    fun getAllDogs(): List<Dog> = dogs

    fun getDogById(dogId: Int): Dog =
        dogs.find { it.id == dogId } ?: throw IllegalArgumentException("Doge not found")

    fun setFavorite(dogId: Int, favorite: Boolean) {
        getDogById(dogId).inFavorite = favorite
    }

    private fun populate(): List<Dog> {
        val contact = ShelterContact("James Bond", R.drawable.test)
        return listOf(
            Dog(
                1,
                R.drawable.daisy,
                R.drawable.profile1,
                "Daisy",
                "French Bulldog",
                Sex.Female,
                "12 weeks",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                2,
                R.drawable.gunter,
                R.drawable.profile2,
                "Gunther",
                "Poodle",
                Sex.Male,
                "6 weeks",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                3,
                R.drawable.sebastian,
                R.drawable.profile3,
                "Sebastian",
                "Brittany Spaniel",
                Sex.Male,
                "2 month",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                4,
                R.drawable.helga,
                R.drawable.profile4,
                "Helga",
                "Chocolate Labrador Retriever",
                Sex.Female,
                "1 year",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                5,
                R.drawable.lottie,
                R.drawable.profile5,
                "Daisy",
                "French Bulldog",
                Sex.Female,
                "12 weeks",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                6,
                R.drawable.daisy2,
                R.drawable.profile6,
                "Gunther",
                "Poodle",
                Sex.Male,
                "6 weeks",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                7,
                R.drawable.sebastian2,
                R.drawable.profile7,
                "Sebastian",
                "Brittany Spaniel",
                Sex.Male,
                "2 month",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            ),
            Dog(
                8,
                R.drawable.daisy3,
                R.drawable.profile8,
                "Sebastian",
                "Brittany Spaniel",
                Sex.Male,
                "2 month",
                "4kg",
                "Super friendly",
                "Suffers from atopic dermatitis",
                "My name is Helga and I'm the happiest little pup you'll ever meet! I love other dogs and have great manners around them. I'm a year old, but I still act like a young puppy and could benefit from learning some manners to act like the grownup I am. I am eager to please, so training will be a treat for both of us! I'll be a great family dog, I just need a family of my own!",
                contact
            )
        )
    }
}

