package com.cursoant.android.kotlinbasics.classes

open class Phone (protected val number: Int){
    fun call(){
        println("Calling...")
    }

    open fun showNumber(){
        println("My number is $number")
    }
}