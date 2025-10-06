package com.adnane.kotlin_essentiel.demo.`class`

class PersonClassic(val name: String, val age: Int) // sans overrides
data class PersonData(val name: String, val age: Int)

fun main() {
    val s1 = setOf(
        PersonClassic("Ada", 36),
        PersonClassic("Ada", 36)
    )
    println("Set (classique, sans overrides) taille = ${s1.size}") // 2

    val s2 = setOf(
        PersonData("Ada", 36),
        PersonData("Ada", 36)
    )
    println("Set (data class) taille = ${s2.size}")                 // 1
}
