package com.cursoant.android.kotlinbasics

fun main() {
    newTopic("Loops")
    showPersons("Angel", "Mary", "Fany")
    showPersons("Angel", "Mary", "Sergio", "Alex", "Carla")
}

fun showPersons(p1: String, p2: String, p3: String) {
    println(p1)
    println(p2)
    println(p3)
}

fun showPersons(vararg persons: String) {
    newTopic("For")
    for(person in persons) println(person)

    newTopic("While")
    var index = 0
    while (index < persons.size){
        if (persons[index] == "Mary") println("Es Mary!")
        println(persons[index])
        index++
    }

    newTopic("When")
    index = (0..persons.size-1).random()
    println(index)
    when (persons[index]){
        "Angel" -> println("Es Angel!")
        "Mary" -> {
            println("Ir a otra pantalla")
            print(2+4)
        }
        else -> println(persons[index])
    }
}