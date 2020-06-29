fun main() {

    // # Sequence
    // Java8의 Stream, ES6의 Generator

    fun gen() = sequence {
        yield(1)
        if (false) yield(2)
        yield(3)
    }

    val seq = gen()
    p(seq.iterator())
    for (s in seq) p(s)

    // odds

    fun infinity(a: Int = 0) = sequence {
        var i = a
        while (true) yield(i++)
    }

    fun <T> limit(l: Int, iter: Sequence<T>) = sequence {
        for (a in iter) {
            yield(a)
            if (a == l) break;
        }
    }

    fun odds(l: Int) = sequence {
        for (a in limit(l, infinity(1))) {
            if (a % 2 == 0) yield(a)
        }
    }

    val seq2 = odds(10)
    p(seq2)

    for (s in seq2) p(s)

}