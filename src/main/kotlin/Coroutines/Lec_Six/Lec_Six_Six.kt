package Lec_Six

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Parental responsibilities : 자식 코루틴이 모두 끝날 때 까지 기다림. 따로 join할 필요 없음
 */

fun main() = runBlocking {
    val request = launch {
        repeat(3) {
            launch {
                delay((it+1)*200L)
                println("Coroutine $it is done")
            }
        }
        println("request : I'm done and I don't explicitly join my childeren")
    }
    println("Now processing of the request is complete")
}