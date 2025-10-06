package com.adnane.kotlin_essentiel.demo


// --- File: GoodPracticesDemo.kt ---

// --- Start of the Deliverable ---

// ---- 1. A Person class with an isAdult() function ----
class Person(val name: String, val age: Int) {
    /**
     * A member function (method) that checks if the person is an adult.
     * This is a behavior related to the "Person" concept.
     */
    fun isAdult(): Boolean {
        return age >= 18
    }
}

// ---- 2. Two simple functions (greet, checkAge) ----
/**
 * A simple function with a single responsibility: to print a welcome message.
 */
fun greet(name: String) {
    println("Hello, $name")
}

/**
 * Another simple function with a single responsibility: to return a status based on age.
 */
fun checkAge(age: Int): String {
    return if (age >= 18) "Adult" else "Minor"
}

// ---- 3. A Counter data class with an increment() function ----
/**
 * An immutable data class to represent a counter.
 * State changes are handled by creating a new instance via copy().
 */
data class Counter(val count: Int = 0) {
    /**
     * Returns a *new* instance of the counter with the incremented value.
     * The original instance is not modified.
     */
    fun increment(): Counter {
        return this.copy(count = count + 1)
    }
}

// ---- A main() function to test and demonstrate each part ----
fun main() {
    println("--- Testing the Person class ---")
    val person1 = Person("Ali", 20)
    val person2 = Person("Leila", 16)
    println("Is ${person1.name} an adult? ${person1.isAdult()}") // true
    println("Is ${person2.name} an adult? ${person2.isAdult()}") // false

    println("\n--- Testing the simple functions ---")
    greet("Sara")
    val ageStatus = checkAge(25)
    println("The status for age 25 is: $ageStatus")

    println("\n--- Testing the Counter data class ---")
    val c1 = Counter(10)      // Starts at 10
    val c2 = c1.increment()   // c2 is a new instance with count = 11
    val c3 = c2.increment()   // c3 is a new instance with count = 12

    println("Initial counter (c1): $c1")       // c1 remains unchanged
    println("After one increment (c2): $c2")
    println("After two increments (c3): $c3")
}

// --- End of the Deliverable ---