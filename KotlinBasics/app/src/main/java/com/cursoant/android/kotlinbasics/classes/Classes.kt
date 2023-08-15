package com.cursoant.android.kotlinbasics.classes

import com.cursoant.android.kotlinbasics.newTopic

fun main(){
    newTopic("Classes")
    val phone: Phone = Phone (123456790)

    phone.call()
    phone.showNumber()

    //println(phone.number)

    newTopic("Heritage")
    val smartphone = Smartphone(987654321, true)
    smartphone.call()

    newTopic("Overwritting")
    smartphone.showNumber()
    println("Private? ${smartphone.isPrivate}")

    newTopic("Data classes")
    val myUser = User(0, "Sergio", "Ordonez", Group.FAMILY.ordinal)
    val bro = myUser.copy(1, "Ivan")
    val friend = bro.copy(2, group = Group.FRIEND.ordinal)
    println(myUser.component3())
    println(myUser)
    println(bro)
    println(friend)

    newTopic("Scope Functions")
    with(smartphone){
        println("Private? $isPrivate")
        call()
    }

    /*friend.group = Group.WORK.ordinal
    friend.name = "John"
    friend.lastName = "Castle"*/
    friend.apply {
        group = Group.WORK.ordinal
        name = "Charles"
        lastName = "Dickens"
    }

    println(friend)


}