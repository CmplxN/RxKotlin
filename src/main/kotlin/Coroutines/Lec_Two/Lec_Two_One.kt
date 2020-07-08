package Lec_Two

import kotlinx.coroutines.*

fun main() {
    // launch : 코루틴 빌더 ==> 내부적으로 코루틴을 만들어서 job을 반환해줌
    // 코루틴 스코프에서 코루틴 빌더를 통해 시작
    // GlobalScope : 라이프타임이 프로그램 전체인 스코프
    // coroutines are light-weight threads

    GlobalScope.launch {
        delay(1000L) // 일시 중단
        println("World!")
    }

    println("Hello")
    runBlocking { // 자신을 호출한 스레드를 Blocking하면서 코루틴 스코프를 생성
        // suspend function은 suspend functino 내 또는 코루틴 스코프에서만 call 가능
        delay(1500L)
    }
}