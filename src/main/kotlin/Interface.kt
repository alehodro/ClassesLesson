interface TV {
    fun turnOn(): Stream?
    fun turnOff() {
        println("Trying to turn off TV")
        println("TV is turned off")
        println("")
    }

    fun adjustChannel(channel: String): Stream?
    fun switchChannel(index: Int): Stream?
    fun displayInputStream(input: Stream?): Stream?
    fun getDetails()
}


//abstract class Stream (val content)

data class Stream(val content: String = "Streaming content")

data class Channel(val name: String, val content: Stream) {
    init {
        println("$name channel is created")
    }
}

class TVImpl(val brend: String, val model: String) : TV {
    var isTurnedOn = false
    val channelsList = mutableListOf<Channel>()
    var currentCannel: Int? = null
    override fun turnOn(): Stream? {
        println("Trying to turn on TV")
        println("TV is turned on")
        isTurnedOn = true
        if (currentCannel != null) {
            val channel = channelsList[currentCannel!!]
            println("Current channel is ${channel.name}.")
            return channel.content
        } else {
            println("Current channel is blank")
            return null
        }

    }

    override fun turnOff() {
        super.turnOff()
        isTurnedOn = false
    }

    override fun adjustChannel(channel: String): Stream? {
        println("Trying to adjust a channel")
        if (isTurnedOn) {
            val channelSet = Channel(channel, Stream())
            channelsList.add(channelSet)
            val index = channelsList.indexOf(channelSet)
            currentCannel = index
            println("$channel is set to $index")
            return channelSet.content
        } else {
            println("Can't adjust channel, TV is turned off")
            return null
        }
    }

    override fun switchChannel(index: Int): Stream? {
        println("Trying to switch channel to $index")
        val channelSwitched = if (channelsList.isEmpty() || channelsList.size < index) {
            null
        } else {
            channelsList[index]
        }
        if (channelSwitched != null) {
            currentCannel = index
            println("Channel switched to ${channelsList[index].name}")
            return channelSwitched.content
        } else {
            println("There is no channel adjusted for $index")
            return null
        }
    }

    override fun displayInputStream(input: Stream?): Stream? {
        println("Trying to dispaly input stream")
        if (isTurnedOn) {
            if (input != null) {
                println("No input stream")
                return input
            } else {
                return null
            }
        } else {
            println("Can't display input stream, TV is turned off")
            return null
        }
    }

    override fun getDetails() {
        println("Getting info")
        println("TV brend is $brend")
        println("TV model is $model")
        if (!channelsList.isEmpty()) {
            println("TV has ${channelsList.size} channels adjusted")
        } else {
            println("TV has no channels adjusted")
        }

        if (isTurnedOn) {
            println("TV is turned on")
            val channelName = channelsList[currentCannel!!].name
            println("Current channel is $channelName")
            println("")
        } else {
            println("TV is turned off")
        }
    }

}

interface VHS {
    fun turnOn() {
        println("VHS is turned on")
    }

    fun insertTape(videoTape: VideoTape)
    fun ejectTape()
    fun play(tv: TV?): Stream?
    fun pause(){
        println("Trying to pause playing videotape")
        println("Paused")
    }
    fun stop(){
        println("Trying to stop playing videotape")
        println("Stopped")
    }
}

data class VideoTape(val film: String)

class VHSImpl (val brend: String, val model: String): VHS {
    var currentTape:VideoTape?=null
    override fun insertTape(videoTape: VideoTape) {
        println("Trying to insert video tape")
        currentTape=videoTape
        println("Video tape with a ${videoTape.film} movie")
    }

    override fun ejectTape() {
        println("Trying to eject video tape")
        if (currentTape!=null) {
            val tape = currentTape
            currentTape = null
            println("Video tape with ${tape?.film} ejected")
        }
    }

    override fun play(tv: TV?): Stream? {
        println("Trying to play video tape")
        if (tv!=null) {
            return tv.displayInputStream()
        }
    }


}