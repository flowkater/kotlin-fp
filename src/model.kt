data class Product(val name: String, val price: Int, val quantity: Int = 0, val isSelected: Boolean = false)
data class User(var name: String = "", var age: Int = 0, var family: List<User> = listOf());
