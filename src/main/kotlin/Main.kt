fun main() {
    //   Classes,Abstract Classes,Inheritance
    /*val developer = Developer("Snowden",Sex.Male,2,"kotlin")
     developer.getDetails()
     val pizza = Pizza("peperoni")
     pizza.getDetails()
     val beer = Beer("Bud")
     beer.getDetails()
     developer.eat(pizza)
     developer.eat(beer)
     developer.code()
     developer.die()*/

    //Interfaces
    val sonyTV = TVImpl("Sony","Bravia")
    sonyTV.getDetails()
    sonyTV.adjustChannel("MTV")
    sonyTV.turnOn()
    sonyTV.adjustChannel("MTV")
    sonyTV.adjustChannel("Discovery")
    sonyTV.getDetails()
    sonyTV.switchChannel(10)
    sonyTV.switchChannel(0)
    sonyTV.turnOff()
}