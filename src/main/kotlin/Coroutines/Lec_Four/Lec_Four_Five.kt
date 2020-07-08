package Lec_Four

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Cancellation propagated coroutines hierarchy
 */

fun main() = runBlocking {
    try {
        println("result : ${failedConcurrentSum()}")
    } catch (e: Exception) {
        println("Computation failed with ArithmeticException from ${Thread.currentThread().name}")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope { // 이곳에도 취소 전파
    val one = async {
        try {
            //delay(Long.MAX_VALUE)
            42
        } finally { // 아래 exception에 의해 전파될 것이다.
            println("First child was cancelled from ${Thread.currentThread().name}")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception from ${Thread.currentThread().name}")
        throw ArithmeticException()
    }
    one.await() + two.await()
}