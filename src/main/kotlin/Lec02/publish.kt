package Lec02

import io.reactivex.subjects.BehaviorSubject

fun main() {
    val xSubject = BehaviorSubject.create<Int>()
//    val xSubject = PublishSubject.create<Int>()
//    val xSubject = ReplaySubject.create<Int>()
//    val xSubject = AsyncSubject.create<Int>()
    xSubject.subscribe { println("첫번째 $it") }
    xSubject.onNext(1)
    Thread.sleep(1000L)
    xSubject.subscribe { println("두번째 $it") }
    xSubject.onNext(2)
    xSubject.onNext(3)
    Thread.sleep(1000L)
    xSubject.subscribe { println("세번째 $it") }
    xSubject.onNext(4)
    xSubject.onComplete()
}