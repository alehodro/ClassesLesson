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
    //val sonyTV = TVImpl("Sony", "Bravia")
    /*sonyTV.getDetails()
    println("")
    sonyTV.adjustChannel("MTV")
    println("")
    sonyTV.turnOn()
    println("")
    sonyTV.adjustChannel("MTV")
    println("")
    sonyTV.adjustChannel("Discovery")
    println("")
    sonyTV.getDetails()
    println("")
    sonyTV.switchChannel(10)
    println("")
    sonyTV.switchChannel(0)
    println("")
    sonyTV.displayInputStream(null)*/

    val panasonicVHS = VHSImpl("Panasonic", "t-1000")
    panasonicVHS.turnOn()
   // panasonicVHS.insertTape(VideoTape("Porn"))
   // sonyTV.turnOn()
   // panasonicVHS.play(sonyTV)
  //  panasonicVHS.ejectTape()
   // panasonicVHS.play(sonyTV)
    panasonicVHS.turnOff()
    panasonicVHS.play(null)

    //Listener
    /* val event = Event("Что-то произошло")
     val subscriber = Subscriber("Подписчик", listOf(event))
     val publisher = Publisher("Издатель")
     publisher.subscribe(subscriber)
     publisher.changeState(event)*/

}