abstract class PizzaCity(
    val neapolitanPizzaPrice: Double,
    val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double,
    val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var checkDiscounts = 0.0
    var totalDiscounts = 0.0
    var coffeeSold = 0
    var totalCoffeeRevenue = 0.0
    var totalRevenue = 0.0
    var totalRevenueAfterDiscounts = 0.0
    var totalSaucesSold = 0
    var totalSauceRevenue = 0.0
    var checkShown = 0
    var checkNotShown = 0
    var coffeeBought = 0
    var coffeeNotBought = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun addTransaction(
        checksShown: Boolean, discounts: Double, coffeeSold: Boolean,
        coffeeRevenue: Double, saucesSold: Int, sauceRevenue: Double
    ) {
        if (checksShown) {
            checkShown++
            totalDiscounts += discounts
        } else {
            checkNotShown++
        }

        if (coffeeSold) {
            this.coffeeSold++
            totalCoffeeRevenue += coffeeRevenue
            coffeeBought++
        } else {
            coffeeNotBought++
        }

        totalSaucesSold += saucesSold
        totalSauceRevenue += sauceRevenue

        // Calculate total revenue
        totalRevenue += coffeeRevenue + sauceRevenue
        totalRevenueAfterDiscounts = totalRevenue - totalDiscounts
    }

    fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неапольской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val money = neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice

        println("Всего заработано денег: $money")
        println("Выручка от кофе: $totalCoffeeRevenue")
        println("Общая сумма скидок: $totalDiscounts")
        println("Выручка после скидок: $totalRevenueAfterDiscounts")
        println("Процент людей, показывающих чек: ${calculatePercentage(checkShown, checkShown + checkNotShown)}%")
        println("Процент людей, не показывающих чек: ${calculatePercentage(checkNotShown, checkShown + checkNotShown)}%")
        println("Процент людей, покупающих кофе: ${calculatePercentage(coffeeBought, coffeeBought + coffeeNotBought)}%")
        println("Процент людей, не покупающих кофе: ${calculatePercentage(coffeeNotBought, coffeeBought + coffeeNotBought)}%")
        println("Продано соусов: $totalSaucesSold")
        println("Выручка от соусов: $totalSauceRevenue")

        // More detailed statistics per pizza-coffee combination can be added here.
    }

    private fun calculatePercentage(part: Int, whole: Int): Double {
        return if (whole > 0) (part.toDouble() / whole.toDouble()) * 100 else 0.0
    }
}

// Пример добавления новой пиццерии в другом городе
class AnotherCityPizza(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice) {

    private val saucesAvailable = listOf("Sauce1", "Sauce2")

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
    }
}

fun main() {
    val pizzaCity = AnotherCityPizza(10.0, 12.0, 8.0, 15.0)
    pizzaCity.neapolitanPizzaSale()
    pizzaCity.addTransaction(true, 10.0, true, 20.0, 5, 15.0)
    pizzaCity.addTransaction(false, 0.0, true, 30.0, 3, 10.0)
    pizzaCity.showStatistics()

    val anotherPizza = AnotherCityPizza(10.0, 12.0, 8.0, 15.0)
    anotherPizza.addTransaction(true, 10.0, true, 20.0, 2, 5.0)
    anotherPizza.showStatistics()
}

