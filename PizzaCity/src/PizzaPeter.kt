class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink {
    override fun drinkSale() {
        println("Вы будете кофе ")
        println("1. Да\n2. Нет")
        if (readln() =="1") println("С вас 200 рублей")

    }
    override fun neapolitanPizzaSale(){
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
        neapolitanPizzaCount++
    }

    override fun romanPizzaSale(){
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
        romanPizzaCount++
    }

    override fun sicilianPizzaSale() {
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
        sicilianPizzaCount++
    }

    override fun tyroleanPizzaSale() {
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
        tyroleanPizzaCount++
    }
}

