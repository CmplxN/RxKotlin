package Lec_Six

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Combining context elements
 * When we have to define mutiple elements for a coroutine context.
 * use '+' operator
 */

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working int thread ${Thread.currentThread().name}")
    }
}