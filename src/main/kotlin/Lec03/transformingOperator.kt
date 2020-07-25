package Lec03

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    /**
     * buffer
     * count: 이만큼
     * skip: 전달한 갯수 포함해서 버림, 디폴트는 버퍼사이즈랑 같다. 0이면 IllegalArgument
     * buffer(2,3) = 01 들어오고 3개 버리면 -1상태 -> 2들어오면 0상태 -> 34 들어오고...
     * list 형태로 변환
     */

//    Observable.fromIterable(0..10)
//        .buffer(2,4) // 마지막은(onComplete) 갯수와 상관없이 출력
//        .subscribe(::println)

    /**
     * flatMap
     * concat과 달리 병렬적으로 실행
     * 새로운 데이터를 만든다.
     */

    Observable.interval(1000,TimeUnit.MILLISECONDS)
        .flatMap { Observable.just("$it Hello, $it World") }
        .subscribe(::println)

    Thread.sleep(5000)
    /**
     * concatMap
     * sequential 하게 실행
     */

    /**
     * switchMap
     * 이전 데이터 무시
     */

    /**
     * map
     * 데이터를 바꾼다
     */
//    Observable.fromIterable(0..3)
//        .map { "RxJava : $it" }
//        .subscribe(::println)

    /**
     * scan
     * 이전 데이터와 현재 데이터를 합쳐서 데이터를 전달하는 Observable 생성
     */

//    Observable.fromIterable(0..3)
//        .scan { t1, t2 -> t1 + t2 }
//        .subscribe(::println)

}