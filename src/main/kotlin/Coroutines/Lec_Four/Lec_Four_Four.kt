package Lec_Four

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Structured concurrency with async
 * This way, if an exception is thrown, all the coroutines will be cancelled
 */

fun main() = runBlocking {
    try {
        val time = measureTimeMillis {
            println("let's start work from ${Thread.currentThread().name}")
            println("The answer is ${concurrentSum()} from ${Thread.currentThread().name}")
        }
        println("Completed in $time ms  from ${Thread.currentThread().name}")
    } catch (e:Exception){
        delay(10000)
    }
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    println("let's wait from ${Thread.currentThread().name}")
    one.await() + two.await()
}