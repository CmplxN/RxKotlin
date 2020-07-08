package Lec_Three

import kotlinx.coroutines.*

/**
 * how to make a coroutine cooperative
 * 1. to periodically invoke a suspend function
 * 2. explicitly check the cancellation status => no Exception throwing
 */

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        println("isActive $isActive..")
        while (isActive) { // cancellable computation loop (코루틴 스코프의 확장 프로퍼티)
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job : I'm sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
        println("isActive $isActive..")
    }
    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}