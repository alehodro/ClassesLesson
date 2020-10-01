interface Grinder{
    fun grind():Boolean
}

interface CoffeeCooker{
    fun cookCoffee():Boolean
}

class AutomaticGrinder():Grinder {
    override fun grind(): Boolean {
        println("Coffee grinded automatically")
        return true
    }
}

class ManuallGrinder():Grinder {
   override fun grind(): Boolean {
        println("Coffee grinded manually")
        return true
    }
}

class CoffeeMaker():CoffeeCooker {
    override fun cookCoffee(): Boolean {
        println("Coffee cooked in coffee maker")
        return true
    }
}

class Cezve():CoffeeCooker {
    override fun cookCoffee(): Boolean {
        println("Coffee cooked in сezve")
        return true
    }
}

class Coffee(grinder:Grinder,cofeeCooker:CoffeeCooker) {
    val grindedCoffee = grinder.grind()
    val cookedCoffee = cofeeCooker.cookCoffee()
    fun getCoffee(): String {
        val coffee = if (grindedCoffee && cookedCoffee) "Cup of coffee" else "No coffee"
        return coffee
    }
}