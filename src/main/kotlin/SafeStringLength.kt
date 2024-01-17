package org.example

fun safeStrLen(s: String?) =
  if (s == null) 0 else s.length

fun safeStrLen2(s: String?) =
  s?.length ?: 0

fun main() {
  val name: String? = null
  println(safeStrLen2(name))
}
