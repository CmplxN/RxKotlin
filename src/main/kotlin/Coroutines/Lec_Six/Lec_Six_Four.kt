package Lec_Six

import kotlinx.coroutines.*

/**
 * Job in the context (디스패처가 다 가 아니야)
 * Scope의 coroutineContext[Job] 를 통해서 확인
 */

fun main() = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")
    launch {
        println("My job is ${coroutineContext[Job]}")
    }
    async {
        println("My job is ${coroutineContext[Job]}")
    }

    // isActive 또한 코루틴 컨텍스트의 Job에 대한 정보 중 하나
}