val userList: List<User> = listOf(
        User("a", 21,
                listOf<User>(User("a1", 53), User("a2", 47),
                        User("a3", 16), User("a4", 15)
                )
        ),
        User("b", 24,
                listOf<User>(User("b1", 58), User("b2", 51),
                        User("b3", 19), User("b4", 22)
                )
        ),
        User("c", 31,
                listOf<User>(User("c1", 64), User("c2", 62))
        ),
        User("d", 20,
                listOf<User>(User("d1", 42), User("d2", 42),
                        User("d1", 11), User("d2", 7)
                )
        )
);


fun main() {
    // userList 에서 유저의 가족(family) 중에 나이(age)가 20 이상인 사람을 나이가 높은 순으로 4명을 뽑아 나이를 모두 합해보아라.

    // Iterable
    p(userList.flatMap { it.family }
            .filter { it.age > 20 }
            .map { it.age }
            .sortedDescending()
            .take(4)
            .reduce(add))

    // Sequence
    p(userList.flatMap { it.family }
            .asSequence()
            .filter { it.age > 20 }
            .map { it.age }
            .sortedDescending()
            .take(4)
            .reduce(add))

}