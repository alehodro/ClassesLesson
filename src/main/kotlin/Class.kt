enum class Sex { Male, Female, Other }

abstract class Baba {
    init {
        println("Baba Nam Kevalam")
    }

    abstract fun getDetails()
}

abstract class LivingBeing : Baba() {
    init {
        println("Living being is created")
    }

    open fun die() {
        println("Living being has gone")
    }

    abstract fun eat(food: Food)
}

abstract class NonLivingEntity : Baba() {
    init {
        println("Non living entity is created")
    }
}

abstract class Food : NonLivingEntity() {
    init {
        println("Food is created")
    }

    abstract fun getContent(): List<String>
    abstract val isBeverage: Boolean
}


data class Pizza(val type: String) : Food() {
    init {
        println("Pizza -  is created")
    }

    override val isBeverage = false

    override fun getDetails() {
        println("This is $type pizza")
    }

    override fun getContent(): List<String> {
        return listOf("pizza", type)
    }
}

data class Beer(val brend: String) : Food() {
    init {
        println("Beer is created")
    }

    override val isBeverage = true
    override fun getDetails() {
        println("This is $brend beer")
    }

    override fun getContent(): List<String> {
        return listOf("beer", brend)
    }
}


abstract class Animal : LivingBeing() {
    init {
        println("Animal is created")
    }

}

abstract class Human() : LivingBeing() {
    init {
        println("Human is created")
    }

    abstract val isChild: Boolean

}

open class Person(val name: String, val sex: Sex, var age: Int) : Human() {
    init {
        println("Person is created")
    }

    override val isChild: Boolean = age in 0..7


    override fun getDetails() {
        val sex = when (sex) {
            Sex.Male -> "he is"
            Sex.Female -> "she is"
            Sex.Other -> "it is"
        }
        val child = if (isChild) "${sex.capitalize()} a child" else "${sex.capitalize()} an adult"
        println("This is $name,$sex $age years old.$child ")
    }

    override fun die() {
        super.die()
        println("$name has died at age of $age years")
    }

    override fun eat(food: Food) {
        val product = food.getContent()
        val isBeverage = food.isBeverage

        if (!isBeverage) {
            println("$name ate some ${product[1]} ${product[0]}")
        } else {
            println("$name drunk some ${product[1]} ${product[0]}")
        }

    }

}

class Developer(name: String, sex: Sex, age: Int, val language: String) : Person(name, sex, age) {
    fun code() {
        println("$name codes \"Hello world\" on $language")
    }
}