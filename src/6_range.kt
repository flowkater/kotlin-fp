val add: (Int, Int) -> Int = { x, y -> x + y }

// range
fun range(l: Int): Iterable<Int> {
    var i = -1
    val res = mutableListOf<Int>()
    while (++i < l) res.add(i)
    return res
}

// 느긋한 range
fun lazyRange(l: Int): Sequence<Int> = sequence {
    var i = -1
    while (++i < l) yield(i)
}

inline fun <T> test(function: () -> T) {
    val startTime = System.currentTimeMillis()
    val result: T = function.invoke()
    val endTime = System.currentTimeMillis()

    p("${result}, ${endTime - startTime}ms")
}

fun <T> take(l: Int, iter: Iterable<T>): Iterable<T> {
    var res = mutableListOf<T>()
    for (a in iter) {
        res.add(a)
        if (res.size == l) return res
    }
    return res
}

fun <T> take(l: Int, iter: Sequence<T>): Iterable<T> {
    var res = mutableListOf<T>()
    for (a in iter) {
        res.add(a)
        if (res.size == l) return res
    }
    return res
}


fun main() {
    val list = range(4)
    p(list)
    p(reduce(add, list))

    val lazyList = lazyRange(4)
    p(lazyList)
    p(reduce(add, lazyList))

//    test(fun() = reduce(add, range(1000000)))
//    test(fun() = reduce(add, lazyRange(1000000)))

    test(fun() = reduce(add, take(5, range(1000000))))
    test(fun() = reduce(add, take(5, lazyRange(1000000))))
}