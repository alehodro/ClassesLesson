interface TV {
    var isTurnedOn:Boolean
    val channelsList
    fun turnOn()
    fun turnOff()
    fun adjustChannel(channel: String)
    fun switchChannel(index: Int)
    fun getDetails()
}

data class Channel(val name: String) {
    init {
        println("$name channel is created")
    }
}

class TVImpl(val brend: String, val model: String) : TV {
    override var isTurnedOn = false
    val channelsList = mutableListOf<Channel>()
    var currentCannel: String? = null
    override fun turnOn() {
        println("TV is turned on")
        isTurnedOn = true
    }

    override fun turnOff() {
        println("TV is turned off")
        isTurnedOn = false
    }

    override fun adjustChannel(channel: String) {
        println("Trying to adjust a channel")
        if (isTurnedOn) {
            val channelSet = Channel(channel)
            channelsList.add(channelSet)
            currentCannel = channel
            println("$channel is set to ${channelsList.indexOf(channelSet)}")
        } else {
            println("Can't adjust channel, TV is turned off")
        }
    }

    override fun switchChannel(index: Int) {
        println("Trying to switch channel")
       val channelSwitched = if (channelsList.isEmpty()||channelsList.size<index) {
           null
       }
       else  {
           channelsList[index]
       }
        if (channelSwitched!=null) {
            currentCannel=channelSwitched.name
            println("Channel switched to $currentCannel")
        } else {
            println("There is no channel adjusted for $index")
        }
    }

    override fun getDetails() {
        println("TV brend is $brend")
        println("TV model is $model")
        if (!channelsList.isEmpty()){
            println("TV has ${channelsList.size} channels adjusted")
        } else {
            println("TV has no channels adjusted")
        }

        if (isTurnedOn) {
            println("TV is turned on")
            println("Current channel is $currentCannel")
        } else {
            println("TV is turned off")
        }
    }
}