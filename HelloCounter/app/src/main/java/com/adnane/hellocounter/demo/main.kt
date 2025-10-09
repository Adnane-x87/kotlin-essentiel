package com.adnane.hellocounter.demo

fun levelLabel(count: Int): String = when {
    count < 0 -> "Invalide"
    count == 0 -> "Debut"
    count in 1..9 -> "Bas"
    count in 10..99 -> "Moyen"
    else -> "Eleve"
}

//Fonction sum0to
fun sum0to(n: Int): Int {
    require(n >= 0)
    var s = 0
    for (i in 0..n) s += i
    return s
}

// Démonstration val/var + string templates
fun demoValVar() {
    val appName = "HelloCounter"
    var count = 0
    val i = 42
    val name = "Adnane"

    val msg = "Bonjour, $name ! (#$i → ${i.toString(16)})"

    println("App: $appName, count initial=$count")
    println(msg)

    count += 5
    println("Count apres modification = $count")
}

// Main pour tester tout
fun main() {
    demoValVar()

    println("\n=== levelLabel ===")
    listOf(-1, 0, 5, 42, 150).forEach { println("$it → ${levelLabel(it)}") }

    println("\n=== sum0to ===")
    listOf(0, 5, 10).forEach { println("sum0to($it) = ${sum0to(it)}") }
}