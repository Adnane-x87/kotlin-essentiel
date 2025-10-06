package com.adnane.kotlin_essentiel.demo.`class`

data class Book(val title: String, val author: String, val year: Int)

fun main() {
    println("=== Data class copy & destructuration ===")
    val b1 = Book("Kotlin for Beginners", "Sara", 2020)
    val b2 = b1.copy(year = 2021)  // copy w change year
    println("b1: $b1")
    println("b2: $b2")

    // destructuration
    val (title, author, year) = b2
    println("title=$title, author=$author, year=$year")

    println("\n=== Data class in Set ===")
    val books = setOf(
        Book("Clean Code", "Ali", 2008),
        Book("Clean Code", "Ali", 2008), // duplicate
        Book("Effective Kotlin", "Karim", 2019)
    )
    println(books)

    println("\n=== Data class in Map ===")
    val library = mapOf(
        Book("Clean Code", "Ali", 2008) to "Programming",
        Book("Effective Kotlin", "Karim", 2019) to "Best practices",
        Book("Clean Code", "Ali", 2008) to "Classic"
    )
    println(library)
}
