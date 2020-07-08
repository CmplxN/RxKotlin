package Lec_Six

import kotlinx.coroutines.*

class Activity {
    private val mainScope = CoroutineScope(Dispatchers.Default)

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        repeat(10) {
            mainScope.launch{ // same thread, different coroutine
                delay((it+1) * 200L)
                println("Coroutine $it is done ${Thread.currentThread().name}")
            }
        }
    }
}

fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething()
    println("Launched coroutines ${Thread.currentThread().name}")
    delay(500L)
    println("Destroying activity ${Thread.currentThread().name}")
    activity.destroy()
    delay(3000L)
}