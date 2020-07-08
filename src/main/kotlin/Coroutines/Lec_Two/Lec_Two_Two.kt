package Lec_Two

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 자신을 호출한 스레드를 Blocking하면서 코루틴 스코프를 생성
fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000L) // 일시 중단
        println("World!")
    }
    println("Hello")
    // suspend function은 suspend functino 내 또는 코루틴 스코프에서만 call 가능
    job.join() // job과 조인 되자.
}