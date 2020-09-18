fun main() {
    // println("Hello world")
    //Test(1).test()
    // Test("test").test()
    val a = Man("Ваня", 13)
    a.getDetails()
    val b = Man("Вивальди", 56, Sex.Female)
    b.getDetails()
    b.goToWar()
    val c = Man("Колян", 16, Sex.Male)
    c.getDetails()
    c.die()

}