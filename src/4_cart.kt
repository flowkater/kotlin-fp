// Currying 예제

infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
    return { gInput: G -> this(g(gInput)) }
}

fun main() {
    val products = listOf(Product("반팔티", 15000, 1, true),
            Product("긴팔티", 20000, 2, false),
            Product("핸드폰케이스", 15000, 3, true),
            Product("후드티", 30000, 4, false),
            Product("바지", 2500, 5, false))

    val add: (Int, Int) -> Int = { x, y -> x + y }

    fun <T> sum(f: (T) -> Int) = fun(iter: Iterable<T>) = reduce(add, map(f, iter))

//    val totalQuantity = sum(fun(p: Product) = p.quantity)
    val totalQuantity = sum(Product::quantity)
    val calTotal = { p: Product -> p.price * p.quantity }
//    val totalPrice = sum(fun(p: Product) = p.price * p.quantity)
    val totalPrice = sum(calTotal)

//    p(totalQuantity(filter(fun(p: Product) = p.isSelected, products)))
    p(totalQuantity(filter(Product::isSelected, products)))
    p(totalPrice(filter(Product::isSelected, products)))
}