package Lec01

import io.reactivex.Observable

fun main() {
    Observable // 생산자
        .just(0, 1, 2, 3) // 생산 연산자 ~ 간단하게 데이터 성장
        .map { it * 2 } // 변경 연산자
        .subscribe { item: Int -> println(item) } // 소비자
}