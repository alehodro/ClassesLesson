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

    sonyTV.adjustChannel("MTV")

    sonyTV.turnOn()

    sonyTV.adjustChannel("MTV")

    sonyTV.adjustChannel("Discovery")

    sonyTV.getDetails()

    sonyTV.switchChannel(10)

    sonyTV.switchChannel(0)

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
    val videoCombo=VideoComboImpl("Sharp","VideoCombo")
    videoCombo.turnOn()
    videoCombo.adjustChannel("NTV")
    videoCombo.insertTape(VideoTape("9 рота"))
    videoCombo.play()
    videoCombo.ejectTape()
    videoCombo.turnOff()
    videoCombo.getDetails()

    //Listener
    /* val event = Event("Что-то произошло")
     val subscriber = Subscriber("Подписчик", listOf(event))
     val publisher = Publisher("Издатель")
     publisher.subscribe(subscriber)
     publisher.changeState(event)*/

}