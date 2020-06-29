fun <T, U> map(f: (T) -> U, iter: Iterable<T>): List<U> {
    val res = mutableListOf<U>()
    for (a in iter) res.add(f(a))
    return res
}

fun <T> filter(f: (T) -> Boolean, iter: Iterable<T>): List<T> {
    val res = mutableListOf<T>()
    for (a in iter) if (f(a)) res.add(a)
    return res
}

fun <T, U> reduce(f: (U, T) -> U, acc: U, iter: Iterable<T>): U {
    var ac = acc
    for (a in iter) ac = f(ac, a)
    return ac
}

fun <T> reduce(f: (T, T) -> T, iter: Iterable<T>): T {
    val it = iter.iterator()
    var acc = it.next()
    for (a in it) acc = f(acc, a)
    return acc
}

fun <T> reduce(f: (T, T) -> T, iter: Sequence<T>): T {
    val it = iter.iterator()
    var acc = it.next()
    for (a in it) acc = f(acc, a)
    return acc
}


fun main() {
    val products = listOf(Product("반팔티", 15000),
            Product("긴팔티", 20000),
            Product("핸드폰케이스", 15000),
            Product("후드티", 30000),
            Product("바지", 2500))

    p(map(fun(p: Product) = p.name, products))
    p(map(fun(p: Product) = p.price, products))

    p(filter(fun(p: Product) = p.price < 20000, products))
    p(filter(fun(p: Product) = p.price >= 20000, products))

    p(filter(fun(n: Int) = n % 2 == 0, listOf(1, 2, 3, 4)))

    val add: (Int, Int) -> Int = { x, y -> x + y }

    p(reduce(add, 0, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    p(reduce(add, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))

    p(reduce(fun(totalPrice: Int, product: Product) = totalPrice + product.price,
            0, products))

    p(reduce(
            add,
            map(fun(p: Product) = p.price,
                    filter(fun(p: Product) = p.price < 20000, products))))

    p(reduce(
            add,
            filter(fun(n: Int) = n >= 20000,
                    map(fun(p: Product) = p.price, products))))
}