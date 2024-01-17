package org.example

fun main() = println("El usuario es ${getAdultStatus(22)} de edad")

fun isAdult(age: Int) = age >= 18

fun getAdultStatus(age: Int) = if (isAdult(age)) "mayor" else "menor"
