fun main() {
    // Java와 비교해 기존과 달라진 리스트 순회
    val list = listOf(1, 2, 3)

//    for(var i = 0; i < list.length(); i++) {
//        p(list[i])
//    }

    // Kotlin에는 for..in 만 존재
    for (x in list) p(x)

    val str = "abc"
    for (s in str) p(s)

    // Array
    p("Array --------")
    val arr = arrayOf(1, 2, 3)
    for (x in arr) p(x)

    // List
    p("List ---------")
    val iter1 = list.iterator()
    for (x in iter1) p(x)

    // Set
    p("Set ---------")
    val set = setOf(1, 2, 3);
    for (x in set) p(x)

    // Map
    p("Map ---------")
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for (x in map.keys) p(x)
    for (x in map.values) p(x)
    for (x in map.entries) p(x)

    p("=====================")

    // ## 이터러블/이터레이터 프로토콜
    // - 이터러블: 이터레이터를 리턴하는 iterator() 를 가진 값
    // - 이터레이터: hasNext(), next() 를 가진 값
    // - 이터러블/이터레이터 프로토콜: 이터러블을 for...in 등과 함께 동작하도록한 규약

    val it1 = list.iterator()

    p(it1.next())
    p(it1.next())
    p(it1.next())
    // p(it1.next()); // Error

    for (a in it1) p(a)

    val it2 = list.iterator()
    while (it2.hasNext()) p(it2.next())

    p("hasNext, next=====")
    val it3 = list.iterator()
    while (it3.hasNext()) {
        p(it3.hasNext())
        p(it3.next())
    }

    p(it3.hasNext())
//    p(it3.next())

    // 전개 연산자 -> kotlin 에서는 array 타입으로 활용
    val a = listOf(1, 2);
    val spread = listOf(*arr, *a.toTypedArray(), *list.toTypedArray(), *set.toTypedArray())
    p(spread)
}