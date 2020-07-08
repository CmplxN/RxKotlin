package Lec_Six

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Jumping between threads
 */

fun main() = runBlocking {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started ibn ctx1")
                withContext(ctx2) { // change the context of a coroutine while staying at the same coroutine
                    log("Working in ctx2")
                }
                log("Back to ctx1")
            }
        }
    }
}