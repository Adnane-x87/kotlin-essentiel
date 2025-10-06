package com.adnane.kotlin_essentiel.demo

// Main.kt — Étape 5
data class Todo(val id: Long, val title: String, val done: Boolean)

fun filterAndSort(todos: List<Todo>, q: String): List<Todo> =
    todos
        .filter { it.title.contains(q.trim(), ignoreCase = true) }
        .sortedBy { it.title.lowercase() }

data class Section(val header: String, val items: List<Todo>)
fun asSections(todos: List<Todo>): List<Section> =
    todos.groupBy { if (it.done) "Terminées" else "À faire" }
        .map { (h, items) -> Section(h, items.sortedBy { it.title }) }

data class Stats(val total: Int, val done: Int, val ratio: Double)
fun stats(todos: List<Todo>): Stats {
    val total = todos.size
    val done = todos.count { it.done }
    val ratio = if (total == 0) 0.0 else done.toDouble() / total
    return Stats(total, done, ratio)
}

fun main() {
    val todos = listOf(
        Todo(1, "Lire Kotlin", true),
        Todo(2, "Coder utils", false),
        Todo(3, "Écrire tests", true),
        Todo(4, "Composer UI", false)
    )

    val filtered = filterAndSort(todos, "kotlin")
    println("filtered=${filtered.map { it.title }}")

    val sections = asSections(todos)
    println("sections=${sections.map { it.header to it.items.map { t -> t.title } }}")

    val st = stats(todos)
    println("stats=$st")

    // mini-tests simples
    check(filtered.size == 1)
    check(st.total == 4 && st.done == 2 && st.ratio == 0.5)
}
