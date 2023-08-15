package com.cursoant.android.kotlinbasics

fun main(){
    showMessage(10, sn = 6, 23)
}

fun showMessage(fn: Int, sn: Int, tn: Int) {
    println("I need to get a $fn in my final test.")
    println("It's really hard having $sn subjects to complete.")
    println("I hope to finish my semester until $tn" + "th this month.")
}
