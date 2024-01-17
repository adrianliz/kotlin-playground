package org.example

// In Kotlin, when you declare a function to return a value,
// you should use the = symbol to assign the value directly to the function,
// not use the return statement.

//fun GenerateGreeting(name: String) {
//  return "Hello " + name
//}

fun GenerateGreeting(name: String) = "Hello $name"

fun main() {
  println(GenerateGreeting("Exeal"))
}
