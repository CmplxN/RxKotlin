package Lec_Three

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Cancellation 시 Resource 해제 => 예외발생후 finally 블록으로 들어가는 것을 이용
 */

fun main() = runBlocking {
    val job = launch {
        try{
            repeat(1000) {
                println("job : I'm sleeping $it...")
                delay(500L)
            }
        }finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}