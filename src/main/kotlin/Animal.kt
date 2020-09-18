enum class Sex { Male, Female, Other }
enum class DeathCause {War, Disease, FromOldAge }

abstract open class Baba {
    init {
        println("Baba Nam Kevalam")
    }
}

abstract class Human() : Baba() {
    init {
        println("Human is born")
    }

    abstract val name: String
    abstract val age:Int
    abstract var sex: Sex?

    abstract fun getDetails()

    abstract fun die(cause: DeathCause)
    open fun die() {
        println("Human is gone")
    }
}

class Man(override val name: String,override val age: Int) : Human() {
    override var sex: Sex? = null
    override fun getDetails() {
        if (sex == null) {
            println("This is a man, he's name is $name, he's age is $age and he is androgen")
        }
        when (sex) {
            Sex.Male -> println("This is a man, he's name is $name, he's age is $age and he is male")
            Sex.Female -> println("This is a man, he's name is $name, he's age is $age and he is transgender")

        }
    }

    override fun die(cause: DeathCause) {
        super.die()
        println("$name has died in age of $age years because of ${cause.name}")
    }

    fun goToWar(){
        println("Doing some pif-paf")
        this.die(DeathCause.War)
    }

    constructor(_name: String, _age: Int, _sex: Sex) : this(_name, _age) {
        sex = _sex

    }


}

/*class Test {
    init {
        println("1")
    }

    var int: Int? = null

    var string: String? = null

    fun test() {
        if (int != null) println("int")
        if (string != null) println("string")
    }

    constructor(age: Int) {
        int = age
    }

    constructor(b: String) {
        string = b
    }
}*/