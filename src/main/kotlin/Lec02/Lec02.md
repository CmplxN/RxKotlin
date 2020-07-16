# 다양한 생산자와 친해지기
## Observable
- 0 ~ n개 데이터를 전달하는 생산자.
- observer : Observer interface 구현체를 subscribe에 전달
- consumer : 직관적인 방법으로, consumer들을 subscribe에 전달하고 반환값으로 disposable을 받음.
- Observable의 특수 케이스인 Single, Maye, Completable도 같은 원리로 사용.
## Single
- 1개 데이터를 전달하는 생산자.
- 전달하거나 에러가 나거나 둘중 하나인 경우 (GET)
## Maybe
- 0개 또는 1개 데이터를 전달하는 생산자.
- onComplete와 onSuccess로 나눠서 처리 가능
## Completable
- 0개 데이터를 전달하는 생산자.
- 데이터 없이, 성공했냐 실패했냐만 관심있을 때

## Subject
- Observable과 Observer의 성격을 둘다 가지는 클래스
- Observable이 가지는 subscribe 등의 operator를 사용할 수 있다.
- 동시에 Observer가 가지는 onNext, onComplete, onError도 사용할 수 있다.
- subscribe 때 데이터를 넘겨주는 방식으로 여러 종류가 있음.
### PublishSubject
- 구독한 시점부터 새로운 데이터를 받는다.
### BehaviorSubject
- 구독한 시점에서 가장 최근에 발행한 데이터를 받는다.
- 구독 시점이 비동기라서 publish보다는 이거를 쓰는 편이다.
### ReplaySubject
- 지금까지 발행됐던 데이터를 모두 받는다.
### AsyncSubject
- onComplete 했을 때 가장 마지막 데이터만 받는다.

# ETC
- RxJava2는 null을 전달할 수 없다.
- Flowable