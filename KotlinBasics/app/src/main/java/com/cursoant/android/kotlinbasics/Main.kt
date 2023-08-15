package com.cursoant.android.kotlinbasics

const val separator = "===================="

fun main(){
    newTopic("Hello Kotlin!")
    newTopic("Variables y Constantes")
    val a = true
    println("a = $a")

    /*var b = 2*/
    var b: Int
    b = 5
    println("b = $b")

    var objNull: Any?
    objNull = null
    objNull = "Hi"

    println(objNull)
}

fun newTopic(topic: String){
    /*println()
    print("======================= ")
    print(topic)
    print(" =======================")
    println()*/

    print("\n$separator $topic =======================\n")

}