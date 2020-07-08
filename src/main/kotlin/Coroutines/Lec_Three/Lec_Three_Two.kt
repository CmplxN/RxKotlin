package Lec_Three

import kotlinx.coroutines.*

// Coroutine cancellation is cooperative
// A coroutine code has to cooperate to be cancellable
// suspending functions are cancellable

// job이 cancel이 되면, suspend였다가 재개될 때 suspend fun이 JobCancellationException을 던진다.

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    // delay(1L)
                    yield() // yield는 아무 행동 없는 suspend fun으로, delay 없이 코루틴이 cooperative가 된다.
                    println("job : I'm sleeping ${i++}")
                    nextPrintTime += 500L
                }
            }
        } catch (e: Exception) {
            println("Exception [$e]")
        }
    }
    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}