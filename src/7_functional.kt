fun main() {
    val users = listOf(User("a", 32),
            User("b", 31),
            User("c", 37),
            User("d", 28),
            User("e", 25),
            User("f", 32),
            User("g", 31),
            User("h", 37))



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



    // # 지연 평가 (Lazy Evaluation)
    // - 제때 계산법 (Eager Evaluation => Iterator)
    // - 느긋한 계산법 (Lazy Evaluation => Sequence)




}