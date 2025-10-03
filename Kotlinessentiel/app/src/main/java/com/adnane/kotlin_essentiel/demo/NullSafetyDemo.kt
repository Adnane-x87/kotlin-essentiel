package com.adnane.kotlin_essentiel.demo


fun greet(input: String?): String =
    input
        ?.trim()
        ?.takeIf { it.isNotEmpty() }
        ?.let { "Bonjour, $it !" }
        ?: ""

fun parseCount(input: String?): Int =
    input
        ?.trim()
        ?.toIntOrNull()
        ?.coerceAtLeast(0)
        ?: 0

fun safeAt(xs: List<Int>, index: Int): Int =
    xs.getOrNull(index) ?: -1

fun parseAnyToNonNegativeInt(x: Any?): Int =
    (x as? String)?.toIntOrNull()?.coerceAtLeast(0) ?: 0

fun lengthOrZero(s: String?): Int =
    s?.length ?: 0

fun nonNullOrFail(s: String?): String =
    requireNotNull(s) { "La valeur ne peut pas être null ici." }

fun main() {
    println("--- Démonstration du chapitre Null-Safety ---")

    // Test pour greet
    println("\n--- Test de 'greet' ---")
    println("greet(null)         -> '${greet(null)}'")
    println("greet(\"  \")          -> '${greet("  ")}'")
    println("greet(\"  Ayoub \") -> '${greet("  Ayoub ")}'")

    // Test pour parseCount
    println("\n--- Test de 'parseCount' ---")
    println("parseCount(null)    -> ${parseCount(null)}")
    println("parseCount(\" abc \") -> ${parseCount(" abc ")}")
    println("parseCount(\" -10 \")-> ${parseCount(" -10 ")}")
    println("parseCount(\" 50 \") -> ${parseCount(" 50 ")}")

    // Test pour safeAt
    println("\n--- Test de 'safeAt' ---")
    val maListe = listOf(100, 200, 300)
    println("safeAt(maListe, 1)  -> ${safeAt(maListe, 1)}")
    println("safeAt(maListe, 5)  -> ${safeAt(maListe, 5)}")

    // Test pour parseAnyToNonNegativeInt
    println("\n--- Test de 'parseAnyToNonNegativeInt' ---")
    println("parseAnyToNonNegativeInt(\"123\") -> ${parseAnyToNonNegativeInt("123")}")
    println("parseAnyToNonNegativeInt(\"xyz\") -> ${parseAnyToNonNegativeInt("xyz")}")
    println("parseAnyToNonNegativeInt(99)    -> ${parseAnyToNonNegativeInt(99)}") // Test avec un Int
    println("parseAnyToNonNegativeInt(null)  -> ${parseAnyToNonNegativeInt(null)}")

    // Test pour lengthOrZero
    println("\n--- Test de 'lengthOrZero' ---")
    println("lengthOrZero(\"Kotlin\") -> ${lengthOrZero("Kotlin")}")
    println("lengthOrZero(null)     -> ${lengthOrZero(null)}")

    // Test pour nonNullOrFail
    println("\n--- Test de 'nonNullOrFail' ---")
    println("nonNullOrFail(\"OK\")  -> '${nonNullOrFail("OK")}'")
    // La ligne suivante va faire crasher le programme, c'est normal.
    // Décommentez-la pour tester.
    // println(nonNullOrFail(null))
}