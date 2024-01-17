package org.example

fun max(a: Int, b: Int): Int {
  if (a > b) {
    return a

  } else {
    return b
  }
}

// NOTE: https://kotlinlang.org/docs/control-flow.html#if-expression
fun max2(a: Int, b: Int): Int {
  return if (a > b) {
    a
  } else {
    b
  }
}

fun main() {
  println(max2(4, 2))
}
