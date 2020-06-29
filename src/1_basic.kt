val p = fun(s: Any) = println(s);

fun main() {

    // # 평가
    // - 코드가 계산(Evaluation) 되어 값을 만드는 것

    // # 일급
    // - 값으로 다룰 수 있다.
    // - 변수에 담을 수 있다.
    // - 함수의 인자로 사용될 수 있다.
    // - 함수의 결과로 사용될 수 있다.

    val x = 10
    val add10 = { i: Int -> i + 10 }
    val add8: (Int) -> Int = { i -> i + 8 }
    val r = add10(x)
    val t = add8(x)
    p(r);
    p(t)

    //# 일급 함수
    // - 함수를 값으로 다룰 수 있다.
    // - 조합성과 추상화의 도구

    val add5 = { a: Int -> a + 5 }
    p(add5)
    p(add5(5))

    val f1 = fun() = fun() = 1
    p(f1())

    val f2 = f1()
    p(f2)
    p(f2())
    p(f1()())

    // # 일급 함수
    // - 함수가 값으로 다뤄질 수 있다.

    // # 고차 함수
    // - 함수를 값으로 다루는 함수

    // ## 함수를 인자로 받아서 실행하는 함수
    // - apply1
    // - times

    val apply1 = { f: (Int) -> Int -> f(1) }
    val add2 = { a: Int -> a + 2 }
    p(apply1(add2))
    p(apply1(fun(a: Int) = a - 1))

    val times = fun(f: (Int) -> Any, n: Int) {
        var i = -1
        while (++i < n) f(i)
    }

    p("times")
    times(p, 3)
    times(fun(a: Int) = p(a + 10), 3)

    // ## 함수를 만들어 리턴하는 함수 (클로저를 만들어 리턴하는 함수)
    // - addMaker
//    val addMaker = fun(a: Int) = fun(b: Int) = a + b
    val addMaker = { a: Int -> { b: Int -> a + b } }
//    val addMaker3 = fun(a: Int) = fun(b: Int) = fun(c: Int) = a + b + c
    val add12 = addMaker(12)
    p(add12(5))
    p(add12(10))
}