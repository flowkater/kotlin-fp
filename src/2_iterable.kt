fun main() {
    // Java와 비교해 기존과 달라진 리스트 순회
    val list = listOf(1, 2, 3)

//    for(var i = 0; i < list.length(); i++) {
//        p(list[i])
//    }

    // Kotlin에는 for..in 만 존재


    // Array
    p("Array --------")


    // List
    p("List ---------")


    // Set
    p("Set ---------")


    // Map
    p("Map ---------")


    p("=====================")

    // ## 이터러블/이터레이터 프로토콜
    // - 이터러블: 이터레이터를 리턴하는 iterator() 를 가진 값
    // - 이터레이터: hasNext(), next() 를 가진 값
    // - 이터러블/이터레이터 프로토콜: 이터러블을 for...in 등과 함께 동작하도록한 규약



    p("hasNext, next=====")


    // 전개 연산자 -> kotlin 에서는 array 타입으로 활용

}