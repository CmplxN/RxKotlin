package Lec_Six

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * Debugging coroutines and threads
 * use -Dkotlinx.coroutines.debug
 */

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg [${Thread.currentThread().name}]")

fun main() = runBlocking {
    val a = async {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async {
        log("I'm computing another piece of the answer")
        10
    }
    log("The answer is ${a.await() + b.await()}")
}