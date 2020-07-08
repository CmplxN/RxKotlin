package Lec_Four

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Concurrent Calculation using async
 * Deferred : Job을 상속한 클래스 + 값을 가짐
 */

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()} from ${Thread.currentThread().name}")
    }
    println("Completed in $time ms")
}