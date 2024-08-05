import kotlinx.coroutines.*

val handler = CoroutineExceptionHandler { _, exception ->
  println("CoroutineExceptionHandler got $exception")
}

suspend fun main() {
  println("Launch exception handling")
  launchExceptionHandling()
  println("Async exception handling")
  asyncExceptionHandling()
  println("Supervisor scope exception handling")
  supervisorScopeExceptionHandling()

  println("End of main")
}

/*
  We install the handler on the root scope, so when the ex is propagated up to the root scope,
  the handler will be invoked, and the app do not crash.
*/
private suspend fun launchExceptionHandling() {
  val rootScope = CoroutineScope(Job() + handler)
  val job = rootScope.launch {
    launch {
      delay(1000)
      throw Exception("Child 2 failed")
    }
    println("Child 1")
  }
  job.join()
}

/*
  When the root coroutine is started with async,
  the exception is encapsulated in the Deferred object.

  Using a CoroutineExceptionHandler on the root scope will not catch the exception.
*/
suspend fun asyncExceptionHandling() {
  val rootScope = CoroutineScope(Job())
  val result = rootScope.async {
    launch {
      delay(1000)
      throw Exception("Child 2 failed")
    }
    println("Child 1")
  }

  try {
    result.await()
  } catch (e: Exception) {
    println("Caught exception: $e")
  }
}

/*
  Unlike coroutineScope, a failure of a child does not cause this scope to fail
  and does not affect its other children, so a failure of one child does not affect other children.
*/
private suspend fun supervisorScopeExceptionHandling() {
  supervisorScope {
    launch {
      delay(1000)
      throw Exception("Child 2 failed")
    }

    launch {
      delay(2000)
      println("Child 3")
    }
    delay(3000)
    println("Root")
  }
}
