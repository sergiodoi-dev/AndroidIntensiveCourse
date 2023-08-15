package com.cursoant.android.kotlinbasics.classes

class Smartphone(number: Int,val isPrivate: Boolean): Phone(number) {
    override fun showNumber() {
        if(isPrivate) println("Unknown") else super.showNumber()
    }
}