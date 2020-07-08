package Lec01

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

fun main() {
    val compositeDisposable = CompositeDisposable()
    val disposable1 = Observable.just(1, 2)
        .subscribe { println(it) }
    compositeDisposable.add(disposable1)
    compositeDisposable.clear() // dispose()
    val disposable2 = Observable.just(3, 4)
        .delay(1, TimeUnit.SECONDS)
        .subscribe { println(it) }
    compositeDisposable.add(disposable2)
    //compositeDisposable.clear()
    Thread.sleep(2000L)
}