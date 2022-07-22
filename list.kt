open class Item(val name: String, val price: Int) {
    override fun toString(): String {
        return name
    }
}

class Noodles : Item("Noodles", 10) 

class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        if (toppings.isEmpty()) {
            return "${name} Chef's Choice"
        } else {
        return name + " " + toppings.joinToString()
        }
    }
} 

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()
    
    fun addItem(item: Item): Order {
        itemList.add(item)
        return this
    }
    
    fun addAllItem(vararg items: Item): Order{
        itemList.addAll(items)
        return this
    }
    
    fun print() {
        println("\nOrder #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: ${item.price}$")
            total += item.price
        }
        println("Total: ${total}$")
    }
}

fun main() {
    val ordersList = mutableListOf<Order>()
    
    ordersList.addAll(listOf(
    	Order(1).addAllItem(Vegetables(), Noodles()),
        Order(2).addAllItem(Vegetables("Carrots", "Lectuce", "Tomato")),
        Order(3).addAllItem(Vegetables("Carrots", "Lectuce"), Noodles())
        )
    )
    
    for (order in ordersList) {
        order.print()
    }
}
