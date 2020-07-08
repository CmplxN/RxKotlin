package Lec_Two

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Structured Concurrency
 * Top Level Coroutine(GlobalScope의)을 따로 만들지 말고 현재 Scope의 Child로만 구성
 * 부모 Coroutine이 Child Coroutine이 끝나는 것을 기다려준다!
 */

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}