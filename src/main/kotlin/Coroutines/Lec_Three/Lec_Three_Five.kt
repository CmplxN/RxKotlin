package Lec_Three

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try{
            repeat(1000) {
                println("job : I'm sleeping $it... from ${Thread.currentThread().name}")
                delay(500L)
            }
        }finally {
            println("before NonCancellable coroutine from ${Thread.currentThread().name}")
            withContext(NonCancellable) { // NonCancellable CoroutineContext. finally 안에서 다시 코루틴
                println("job: I'm running finally from ${Thread.currentThread().name}")
                delay(1000L)
                println("job : And I've just delayed for 1 sec because I'm non-cancellable from ${Thread.currentThread().name}")
            }
            println("after NonCancellable coroutine from ${Thread.currentThread().name}")
        }
    }
    delay(1300L)
    println("main : I'm tired of waiting! from ${Thread.currentThread().name}")
    job.cancelAndJoin()
    println("main : Now I can quit. from ${Thread.currentThread().name}")
}