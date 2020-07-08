package Lec_Six

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Children of a coroutine : GlobalScope cannot be a child. it's independent
 */

fun main() = runBlocking {
    val request = launch {
        GlobalScope.launch {
            println("job1 : I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1 : I am not affected by cancellation of the request")
        }
        launch {
            delay(100)
            println("job2 : I am a child of the request coroutine")
            delay(1000)
            println("job2 : I will not execute this line if my parent request is cancelled")
        }
        delay(500)
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("main : Who hs survived from cancellation?")
}