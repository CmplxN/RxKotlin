package Lec_Six

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * Coroutine Dispatcher : 어떤 스레드 풀에서 실행될지 결정하는 요소
 * 코루틴 빌더에 코루틴 컨텍스트를 인자로 줘서 적용한다.
 */

fun main() = runBlocking<Unit> {
    launch {
        println("main runBlocking from ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) { // Main Thread에서 실행됨
        println("Unconfined from ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) { // 참고 : GlobalScope가 Default 사용함
        println("Default from ${Thread.currentThread().name}")
    }
    launch(Dispatchers.IO) {
        println("IO from ${Thread.currentThread().name}")
    }
    // open을 사용해야 내부에 close가 있어서 메모리 leak이 발생하지 않는다.
    newSingleThreadContext("MyOwnThread").use {
        launch(it) {
            println("newSingleThreadContext from ${Thread.currentThread().name}")
        }
    }
}