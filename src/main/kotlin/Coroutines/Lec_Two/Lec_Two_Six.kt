package Lec_Two

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 다른 코루틴 but 같은 스레드

fun main() = runBlocking {
    launch {
        repeat(5) {
            println("Coroutine A, $it from ${Thread.currentThread().name}")
            delay(10L) // delay는 suspend fun으로 현재 코루틴이 일시정지 될 수 있다.
        }
    }
    launch {
        repeat(5) {
            println("Coroutine B, $it from ${Thread.currentThread().name}")
            delay(10L)
        }
    }

    println("Coroutine Outer from ${Thread.currentThread().name}")
}