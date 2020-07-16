package Lec02

import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import java.util.concurrent.TimeUnit

fun main() {
//    val t = ObservableSource<Int> {
//        it.onNext(1)
//        it.onNext(2)
//    }
//    RxJavaPlugins.setErrorHandler { println("By Error Handler") } //~ Rx쪽 전역적인 에러 핸들러 ~
//
//    val observable = Observable.just(1, 2, 3)
//        .map {
//            if (it == 3) throw IllegalStateException()
//            else it
//        }
//    observable.subscribe {println("this is on Next $it")}
//    observable.subscribe({
//
//    }, {
//
//    })
//
//    Single.just(1)
//        .subscribe({
//
//        },{
//
//        })
//    Single.just(1)
//        .subscribe { t1, t2 ->
//
//        }
//
//    Observable.just(1, 2, 3)
//        .subscribe(object : Observer<Int> {
//            override fun onComplete() {
//                println("onComplete")
//            }
//
//            override fun onSubscribe(d: Disposable) {
//                println("onSubscribe")
//            }
//
//            override fun onNext(t: Int) {
//                println("onNext $t")
//            }
//
//            override fun onError(e: Throwable) {
//                println("onError")
//            }
//            // 단축키 ctrl + y
//            // 단축키 shift + enter
//        })
//
//    val observer = Observable.just(11, 12, 13)
//        .map {
//            if (it == 12) throw IllegalStateException()
//            else it
//        }
//    observer.subscribe(
//        { println("onNext $it") },
//        { println("onError") },
//        { println("onComplete") },
//        { println("onSubscribe") })
//    val compositeDisposable = CompositeDisposable()
//    val single = Single.just(11).delay(5, TimeUnit.SECONDS)
//
//    single.subscribe(object: SingleObserver<Int> {
//        override fun onSuccess(t: Int) {
//            println("Success with $t")
//        }
//
//        override fun onSubscribe(d: Disposable) {
//            compositeDisposable.add(d)
//        }
//
//        override fun onError(e: Throwable) {
//            println("onError")
//        }
//
//    })
//    compositeDisposable.dispose()
//
//    val completable = Completable.complete()


}