# Lec01
## Observer Pattern
- 객체 상태 변화를 관찰하는 옵저버를 객체에 등록
- 상태변화 발생시 등록된 옵저버에 통지하는 구조
## RxKotlin Basic Structure
- RxJava 기반 ReactiveX의 JVM 구현
- 관찰 가능한 시퀀스를 이용, 비동기 및 이벤트 기반 프로그래밍 라이브러리
- Rx에서는 크게 3가지 역할이 있다.
    - Producer : 데이터를 생산하여 전달
    - Consumer : 데이터를 받아서 처리
    - Operator : 데이터를 가공
- 이 역할들을 각각 다른 Scheduler(어떤 스레드에서 할지 등)에서 처리할 수 있다.
## Disposable
- subscribe의 반환체인 Disposable을 통해 현재 작업을 취소(cancel)할 수 있다.
- CompositeDisposable을 통해 여러 Disposable을 한번에 관리할 수 있다.
- add, addAll
- clear(CompositeDisposable 재사용 가능), dispose(CompositeDisposable을 재사용 불가능)
- dispose는 실제로 쓸 일은 거의 없음.
## ETC
- Operator 관련 reference : reactivex.io (DOCs -> Operators)
- Marble Diagram