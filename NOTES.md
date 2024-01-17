# Kotlin

> “Kotlin is a pragmatic programming language for the JVM and
Android that combines OO and functional features and is
focused on interoperability, safety, clarity, and tooling support.”

Andrey Breslav, 2016

> "One of the most important use cases for Kotlin is a big
Java codebase whose developers want a better language:
you can mix Java and Kotlin freely and migration can be
gradual and doesn't have to alter entire codebase.”

Andrey Breslav, 2014

## Index

- [References](#references)
- [Variables](#variables)
- [Functions](#functions)
- [Control structures](#control-structures)

## References

[Getting started](https://kotlinlang.org/docs/getting-started.html)
[Kotlin in action](https://www.manning.com/books/kotlin-in-action)

## Variables

In Kotlin, everything is an object in the sense that you can call member functions and properties on
any variable. While certain types have an optimized internal representation as primitive values at
runtime (such as numbers, characters, booleans and others), they appear and behave like regular
classes to you.

Variables can be declared using `var` and `val` keywords. `var` is mutable and `val` is immutable.

```kotlin
var a: Int = 1
val b = 2
val c: Int
c = 3
```

Variables can be declared at package level.
Then, they belong to the default package and can be accessed from any other package.

## Functions

As variables, functions can be declared at package level.

Functions can have default values for parameters.

```kotlin
fun sum(a: Int = 0, b: Int = 0): Int {
    return a + b
}
```

Functions can have named parameters.

```kotlin
fun sum(a: Int = 0, b: Int = 0): Int {
    return a + b
}

fun main(args: Array<String>) {
    println(sum(a = 1, b = 2))
}
```

We can interpolate variables in strings and use expressions in string templates.

```kotlin
fun main(args: Array<String>) {
    val a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}
```

NOTE: In Java this is in preview mode. https://openjdk.java.net/jeps/8273943

By default, functions return `Unit` (void). We can omit the return type.

```kotlin
fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}
```

Functions can be declared inside other functions.

```kotlin
fun main(args: Array<String>) {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    println(sum(1, 2))
}
```

Functions can be declared as block body or expression body.

```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum(a: Int, b: Int) = a + b
```

## Control structures

In Kotlin, most of the control structures are expressions.
It means that they return a value.

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b
```

When a function returns nothing, it returns `Unit`.

In Kotlin, `when` replaces `switch` in Java.

```kotlin
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }
```

We can use objects in `when` statements, not only expressions.

```kotlin
fun main(args: Array<String>) {
    val x = 1
    val y = 2
    when (setOf(x, y)) {
        setOf(0, 1) -> println("x or y is 0 or 1")
        setOf(1, 2) -> println("x or y is 1 or 2")
        else -> println("x or y is not 0 or 1")
    }
}
```

We can use the for loop to iterate over anything that provides an iterator.

```kotlin
fun main(args: Array<String>) {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}
```

We can use ranges to iterate over numbers.

```kotlin
fun main(args: Array<String>) {
    for (x in 1..5) {
        println(x)
    }
}
```
