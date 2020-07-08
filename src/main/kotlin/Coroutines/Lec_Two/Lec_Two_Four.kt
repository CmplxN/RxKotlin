package Lec_Two

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("let's go myWorld() ${Thread.currentThread().name}")
        myWorld()
        println("out of myWorld() ${Thread.currentThread().name}")
    }
    println("Hello from ${Thread.currentThread().name}")
}

suspend fun myWorld() {
    delay(1000L) // suspend fun이 아니면 suspend fun인 delay를 호출할 수 없다.
    println("World! from ${Thread.currentThread().name}")
}