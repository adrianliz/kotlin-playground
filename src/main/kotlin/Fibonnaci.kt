package org.example

fun main() {
    val fibonnaci = Fibonnaci()
    for (i in 1..50) {
        println(fibonnaci.of(i))
    }
}

class Fibonnaci {
    fun of(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return of(n - 1) + of(n - 2)
    }
}
