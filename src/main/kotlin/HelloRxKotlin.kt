import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

typealias Observer<T> = (T) -> Unit

class EventSource<T> {
    private val observers = mutableListOf<Observer<T>>()
    fun addObserver(observer: Observer<T>) = observers.add(observer)
    fun notify(event: T) = observers.forEach { it(event) }
}

fun main() {
    val eventSource = EventSource<String>()
    eventSource.addObserver { str: String -> println("첫번째 옵저버 : $str") }
    eventSource.addObserver { str: String -> println("두번째 옵저버 : $str") }
    eventSource.notify("Hello")
    eventSource.notify("RxKotlin")


    val t = Observable // 생산자
        .just(0, 1, 2, 3) // 생산 연산자 ~ 간단하게 데이터 성장
        .map { it * 2 } // 변경 연산자
        .subscribe { item: Int -> println(item) } // 소비자
    // 스케쥴러 ~ IO 스레드, 메인 스레드 등 어떤 스레드에서 돌릴지 그런 스케쥴러


    val compositeDisposable = CompositeDisposable()
    val disposable1 = Observable.just(1, 2)
        .subscribe { println(it) }
    compositeDisposable.add(disposable1)
    compositeDisposable.clear() // dispose는 compositeDisposable 자체를 먹통으로 만들어서 보통 clear()를 쓴다.
    val disposable2 = Observable.just(3, 4)
        .delay(1, TimeUnit.SECONDS) // delay 빼버리면 dispose 해도 출력한다. ==>
        .subscribe { println(it) }
    compositeDisposable.add(disposable2)
    compositeDisposable.clear() // 위에서 정한 1초가 지나기 전에 clear()가 호출되어 취소해버릴 수 있다.
    Thread.sleep(2000L)

    // onPause에 dispose를 걸어버리면 예를 들면 재난문자 받고 복귀하면 앱이 죽겠구나.
    // operator가 어떻게 동작하는지 ==> reactivex.io (DOCs -> Operators)
}