package Lec_Two

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(100000) {
        launch {// if you do it with thread, worse output ==> 코루틴은 스레드보다 가볍다.
            delay(1000L)
            print(".")
        }
    }
//    GlobalScope.launch{ // 프로세스가 끝나면 코루틴 끝났다.
//        repeat(1000) {
//            println("I'm sleeping $it ...")
//            delay(500L)
//        }
//    }
//    delay(1300L)
}