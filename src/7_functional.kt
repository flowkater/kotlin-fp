fun main() {
    val users = listOf(User("a", 32),
            User("b", 31),
            User("c", 37),
            User("d", 28),
            User("e", 25),
            User("f", 32),
            User("g", 31),
            User("h", 37))

    val add: (Int, Int) -> Int = { x, y -> x + y }
    val list = 1..10
    p(list.map { it * 2 })
    p(list.filter { it % 2 == 0 })
    p(list.reduce(add))

    val deepList = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6))
    p(deepList.flatten())
    p(deepList.flatMap { it.toList() })

    val numbers = listOf(5, 2, 10, 4)

    p(numbers.reduce { total, num -> total + num * 2 }) // 37
    p(numbers.fold(0) { total, num -> total + num * 2 }) // 42

    p(list.take(2))
    p(list.find { it % 2 == 0 }!!)

    //    ### map, filter 계열 함수들이 가지는 결합 법칙
    //
    //    - 사용하는 데이터가 무엇이든지
    //    - 사용하는 보조 함수가 순수 함수라면 무엇이든지
    //    - 아래와 같이 결합한다면 둘 다 결과가 같다.
    //
    //    [[mapping, mapping], [filtering, filtering], [mapping, mapping]]
    //    =
    //    [[mapping, filtering, mapping], [mapping, filtering, mapping]]
    //
    p(list.map { it * 2 }
            .filter { it % 2 == 0 }
            .reduce { total, num -> total + num })

    p(users.find { it.age < 30 }!!)

    p(users.map { it.age }
            .find { it < 30 }!!)


    // # 지연 평가 (Lazy Evaluation)
    // - 제때 계산법 (Eager Evaluation => Iterator)
    // - 느긋한 계산법 (Lazy Evaluation => Sequence)

    val doubleMap = list.asSequence().map { it * 2 }

    p(doubleMap)
    p(doubleMap.toList())

    val numList = 1..10
    val infinity = 1..Int.MAX_VALUE

    test(fun() = numList
            .filter { p("filter: $it"); it % 2 == 0 }
            .map { p("map: $it"); it + 10 }
            .take(2))

    test(fun() = infinity
            .asSequence()
            .filter { p("filter: $it"); it % 2 == 0 }
            .map { p("map: $it"); it + 10 }
            .take(2)
            .toList())

    val naturalNumbers = generateSequence(0) { it + 1 }
    val nTo100 = naturalNumbers.takeWhile { it <= 100 }
    p(nTo100.sum())


}