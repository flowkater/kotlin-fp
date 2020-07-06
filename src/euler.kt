fun main() {

// 10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.
// 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?

//    p((1..999).filter { it % 3 == 0 || it % 5 == 0 }.sum())


//    피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.

//    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//    짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?

//    val arr = mutableListOf(1, 2)
//    while (arr[arr.size - 1] <= 4000000) arr.add(arr[arr.size - 2] + arr[arr.size - 1])
//    p(arr.filter{ it % 2 == 0}.sum())

    p(fibonacci().filter { it % 2 == 0 }.takeWhile { it < 4000000 }.sum())

}

fun fibonacci() = sequence {
    var p = Pair(1, 2)
    // this sequence is infinite
    while (true) {
        yield(p.first)
        p = Pair(p.second, p.first + p.second)
    }
}

