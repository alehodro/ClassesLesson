fun main() {
    val developer = Developer("Snowden",Sex.Male,2,"kotlin")
    developer.getDetails()
    val pizza = Pizza("peperoni")
    pizza.getDetails()
    val beer = Beer("Bud")
    beer.getDetails()
    developer.eat(pizza)
    developer.eat(beer)
    developer.code()
    developer.die()

}