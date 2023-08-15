package com.cursoant.android.kotlinbasics

import com.cursoant.android.kotlinbasics.classes.Group
import com.cursoant.android.kotlinbasics.classes.User

fun main() {
    newTopic("Collections")
    newTopic("Read Only")

    val fruitList = listOf("Apple", "Banana", "Grape", "Lime")
    println(fruitList.get((0..fruitList.size - 1).random()))

    println("Index of grape is ${fruitList.indexOf("Grape")}")

    newTopic("Mutable list")
    val myUser = User(0, "Sergio", "Ordonez", Group.FAMILY.ordinal)
    val bro = myUser.copy(1, "Ivan")
    val friend = bro.copy(2, group = Group.FRIEND.ordinal)
    val userList = mutableListOf(myUser, bro)
    println(userList)
    userList.add(friend)
    println(userList)
    //userList.removeAt(1)
    userList.remove(bro)
    println(userList)

    val userSelectedList = mutableListOf<User>()
    println(userSelectedList)
    userSelectedList.add(myUser)
    println(userSelectedList)

    userSelectedList.set(0, bro)
    println(userSelectedList)

    userSelectedList.add(myUser)
    userSelectedList.add(myUser)
    println(userSelectedList)

    newTopic("Map")
    val userMap = mutableMapOf<Int, User>()
    println(userMap)
    userMap.put(myUser.id.toInt(), myUser)
    userMap.put(myUser.id.toInt(), myUser)
    println(userMap)

    userMap.put(friend.id.toInt(), friend)
    println(userMap)
    userMap.remove(2)
    println(userMap)

    println(userMap.isEmpty())
    println(userMap.containsKey(0))
    userMap.put(bro.id.toInt(), bro)
    userMap.put(friend.id.toInt(), friend)
    println(userMap)
    println(userMap.keys)
    println(userMap.values)
}