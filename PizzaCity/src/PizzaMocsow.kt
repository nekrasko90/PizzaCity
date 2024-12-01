class PizzaMoscow (
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto {

    override fun showCheckPhoto() {
        println("У вас есть фотография чека ")
        println("1. Да\n2. Нет")
        if (readln() =="1") println("Вам будет скидка 50 рублей с покупки")
    }
    override fun neapolitanPizzaSale(){
        println("Спасибо за покупку неаполитанской пиццы в Москве")
        neapolitanPizzaCount++
    }

    override fun romanPizzaSale(){
        println("Спасибо за покупку римской пиццы в Москве")
        romanPizzaCount++
    }

    override fun sicilianPizzaSale() {
        println("Спасибо за покупку сицилийской пиццы в Москве")
        sicilianPizzaCount++
    }

    override fun tyroleanPizzaSale() {
        println("Спасибо за покупку тирольской пиццы в Москве")
        tyroleanPizzaCount++
    }
}

