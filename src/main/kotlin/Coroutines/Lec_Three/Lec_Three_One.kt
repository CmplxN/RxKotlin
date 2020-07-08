package Lec_Three

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000){
            println("job : I'm sleeping $it ...")
            delay(500L)
        }
    }
    delay(1300L)
    println("main : I'm tired of waiting!!!")
    job.cancel()
    //job.join()
    println("main : Now I can quit ^_^")
}