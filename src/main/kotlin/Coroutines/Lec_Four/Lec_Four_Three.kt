package Lec_Four

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Lazily started async
 * async(start = CoroutineStart.LAZY)
 */

// No Async-style functions (no suspend function, using GlobalScope...) ==> Cannot handle exceptions etc.
// Use Structured Concurrency !!

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        // some computation to be done prior
        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()} from ${Thread.currentThread().name}")
        // 만약 start를 안했다면 one.await() call에 1초, two.await()에 1초 해서 2초 걸린다.
    }
    println("Completed in $time ms")
}