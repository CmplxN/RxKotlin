package Lec01

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
    eventSource.notify("Observer")
}