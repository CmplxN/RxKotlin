package Lec_Four

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Sequential by default
 */

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two} from ${Thread.currentThread().name}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne from ${Thread.currentThread().name}")
    delay(1000L) // pretend we do sth useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo from ${Thread.currentThread().name}")
    delay(1000L) // pretend we do sth useful here
    return 29
}