package Lec03

import io.reactivex.Completable
import io.reactivex.Observable
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit
import kotlin.random.Random

// create, interval, timer => 주로 쓰이는 생성 연산자

fun main() {
    /**
     * create
     *  subscribe 하면 emitter 블럭을 타서 내용을 실행 ~ lazy하게
     *  항상 같은 observable을
     */
//    Observable.create<String> { emitter ->
//        emitter.onNext("Hello")
//        emitter.onNext("World")
//        emitter.onComplete()
//    }.subscribe { println(it) }

    /**
     * defer
     * subscribe한 순간 만들어서 준다.(다를 수 있는 ~ 옵저바블 소스를)
     * create와 if(Random.nextBoolean)
     * 케이스에 따라 다른 observable 필요, 전달 로직이 다른다던가, 함수가 대신 처리해준다던가
     */

//    val observable = Observable.defer {
//        if (Random.nextBoolean()) {
//            Observable.create<Int> {
//                println("랜덤 true 생산")
//                it.onNext(1)
//            }
//        } else {
//            Observable.create<Int> {
//                println("랜덤 false 생산")
//                it.onNext(1)
//            }
//        }
//    }
//    observable.subscribe(::println)
//    observable.subscribe(::println)
//    observable.subscribe(::println)

    /**
     * fromArray
     */
//    val items = arrayOf("Hello","World")
//    Observable.fromArray(*items).subscribe(::println)

    /**
     * fromCallable
     * 호출한 시점에 데이터를 만든다.
     */

//    println("start: ${System.currentTimeMillis()}")
//    fun createItem(): String {
//        println("start: ${System.currentTimeMillis()}")
//        return "Hello World"
//    }
//
//    val observable = Observable.fromCallable(::createItem)
//    Thread.sleep(1000)
//    observable.subscribe(::println)
//    Thread.sleep(1000)
//    observable.subscribe(::println)

    /**
     * fromIterable
     */

    /**
     * interval
     * 정해진 period 주기로 정기적 action을 취할 때 + 이니셜 딜레이
     */
//    Observable.interval(0, 1000, TimeUnit.MILLISECONDS).subscribe(::println)
//    Thread.sleep(3000)

    /**
     * just
     * 최대 10개..
     */

    /**
     * range
     * start부터 count만큼 값을 1씩 증가하는 값을 생산, Int 값 전달
     * n부터 m개 만큼
     */
    //Observable.range(3, 2).subscribe(::println)

    /**
     * repeat
     */
//    val observable = Observable.just("Hello", "World")
//        .doOnSubscribe(::println) // subscribe 하기 전에, doAfter라고 한 다음에 할 동작도 정의할 수 있다.
//        .repeat(2) // 이만큼 doOnSubscribe도 실행
//    observable.subscribe(::println)

    /**
     * timer ~ Completable과 함께 쓰이는 편이다.
     * 정해진 delay후 0의 값을 전달하는 Observable
     */
//    println("start : ${System.currentTimeMillis()}")
//    Completable.timer(1000,TimeUnit.MILLISECONDS)
//        .subscribe { println("start : ${System.currentTimeMillis()}") }
//    Thread.sleep(2000)
}