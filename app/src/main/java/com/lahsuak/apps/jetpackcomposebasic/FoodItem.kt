package com.lahsuak.apps.jetpackcomposebasic

import androidx.annotation.DrawableRes

data class FoodItem(
    val id: Int,
    val name: String,
    val price: Double,
    @DrawableRes val image: Int,
)

val foodList = listOf(
    FoodItem(1, "Pizza", 20.0, R.drawable.food1),
    FoodItem(2, "French toast", 10.05, R.drawable.foo2),
    FoodItem(3, "Chocolate cake", 12.99, R.drawable.food3),
)

data class Person(
    val id: Int,
    val name: String,
    @DrawableRes val profile: Int,
)

val persons = listOf(
    Person(1, "Kaushal", R.drawable.person1),
    Person(2, "Jigar", R.drawable.person2),
    Person(3, "John", R.drawable.person3),
)