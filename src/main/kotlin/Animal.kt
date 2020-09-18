enum class Sex { Male, Female, Other }
enum class Disease

abstract open class Baba {
    init {
        println("Baba Nam Kevalam")
    }
}

abstract class Human() : Baba() {
    init {
        println("Human is born")
    }

    open fun die() {
        println("Human is gone")
    }
}

class Man(val name: String, val age: Int) : Human() {
    var sex: Sex? = null
    fun getDetails(){
        if (sex==null){println("This is a man, he's name is $name, he's age is $age and he is androgen")}
        when (sex){
            Sex.Male -> println("This is a man, he's name is $name, he's age is $age and he is male")
            Sex.Female -> println("This is a man, he's name is $name, he's age is $age and he is transgender")

        }
    }

    constructor(_name: String, _age: Int, _sex: Sex) : this(_name,_age) {
        sex=_sex

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