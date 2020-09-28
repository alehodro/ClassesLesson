interface TV {
    fun display(stream: Stream?): Stream?
    fun adjustChannel(channel: String)
    fun switchChannel(index: Int)
}

interface VHS {
    fun insertTape(videoTape: VideoTape)
    fun ejectTape()
}

interface VHSPlayer {
    fun play(tv: TVImpl?)
}

interface VideoComboPlayer {
    fun play(): Stream?
}

interface TVinputExtendable {
    fun displayInputStream(input: Stream?): Stream?
}

interface Power {
    val isTurnedOn: Boolean
    fun turnOn()
    fun turnOff()
}

interface ObjectChecker {
    fun getDetails()
}

data class Stream(val content: String = "Streaming content")

data class Channel(val name: String, val content: Stream) {
    init {
        println("$name channel is created")
    }
}

data class VideoTape(val film: String)

class TVImpl(val brend: String, val model: String) : TV, Power, ObjectChecker, TVinputExtendable {
    init {
        println("${this.brend}: TV is created")
    }

    override var isTurnedOn = false
    val channelsList = mutableListOf<Channel>()
    var currentCannel: Int? = null

    override fun turnOn() {
        println("${this.brend}:Trying to turn on TV")
        isTurnedOn = true
        println("${this.brend}:TV is turned on")
        display(null)
    }

    override fun turnOff() {
        println("${this.brend}:Trying to turn off TV")
        isTurnedOn = false
        println("${this.brend}:TV is turned off")
    }

    override fun display(stream: Stream?): Stream? {
        if (stream != null) {
            println("${this.brend}: is playing ${stream.content}")
            println("${this.brend}:Streaming")
            return stream
        }
        if (currentCannel != null) {
            val channel = channelsList[currentCannel!!]
            println("${this.brend}:Current channel is ${channel.name}.")
            println("${this.brend}:Streaming")
            return channel.content
        } else {
            println("${this.brend}:Current channel is blank")
            return null
        }
    }

    override fun adjustChannel(channel: String) {
        println("${this.brend}:Trying to adjust a channel")
        if (isTurnedOn) {
            val channelSet = Channel(channel, Stream())
            channelsList.add(channelSet)
            val index = channelsList.indexOf(channelSet)
            currentCannel = index
            println("${this.brend}:$channel is set to $index")
            display(null)
        } else {
            println("${this.brend}:Can't adjust channel, TV is turned off")
        }
    }

    override fun switchChannel(index: Int) {
        println("${this.brend}:Trying to switch channel to $index")
        val channelSwitched = if (channelsList.isEmpty() || channelsList.size < index) {
            null
        } else {
            channelsList[index]
        }
        if (channelSwitched != null) {
            currentCannel = index
            println("${this.brend}:Channel switched to ${channelsList[index].name}")
            display(null)
        } else {
            println("${this.brend}:There is no channel adjusted for $index")
        }
    }

    override fun displayInputStream(input: Stream?): Stream? {
        println("${this.brend}:Trying to dispaly input stream")
        if (isTurnedOn) {
            if (input != null) {
                println("${this.brend}:Streaming ${input.content}")
                return input
            } else {
                println("${this.brend}:No input stream")
                return null
            }
        } else {
            println("${this.brend}:Can't display input stream, TV is turned off")
            return null
        }
    }

    override fun getDetails() {
        println("${this.brend}:Getting info")
        println("${this.brend}:TV brend is $brend")
        println("${this.brend}:TV model is $model")
        if (!channelsList.isEmpty()) {
            println("${this.brend}:TV has ${channelsList.size} channels adjusted")
        } else {
            println("${this.brend}:TV has no channels adjusted")
        }

        if (isTurnedOn) {
            println("${this.brend}:TV is turned on")
            val channelName = channelsList[currentCannel!!].name
            println("${this.brend}:Current channel is $channelName")
            println("")
        } else {
            println("${this.brend}:TV is turned off")
        }
    }

}


class VHSImpl(val brend: String, val model: String) : VHS, Power, ObjectChecker, VHSPlayer {
    init {
        println("${this.brend}:VHS is created")
    }

    override var isTurnedOn = false
    var currentTape: VideoTape? = null

    override fun turnOn() {
        println("${this.brend}:Trying to turn on VHS")
        isTurnedOn = true
        println("${this.brend}:VHS is turned on")
    }

    override fun insertTape(videoTape: VideoTape) {
        println("${this.brend}:Trying to insert video tape")
        if (!isTurnedOn) {
            turnOn()
            isTurnedOn = true
        }
        if (currentTape != null) {
            println("${this.brend}:Unable to insert this tape, there is tape already inserted")
            return
        }
        currentTape = videoTape
        println("${this.brend}:Video tape with a ${videoTape.film} movie inserted")
    }

    override fun ejectTape() {
        println("${this.brend}:Trying to eject video tape")
        if (!isTurnedOn) {
            println("$this.brend:Unable to eject, VHS is turned off")
            return
        }
        if (currentTape != null) {
            val tape = currentTape
            currentTape = null
            println("${this.brend}:Video tape with ${tape?.film} ejected")
        } else {
            println("${this.brend}:Failed to eject, no tape inside")
        }
    }

    override fun play(tv: TVImpl?) {
        if (!isTurnedOn) {
            println("${this.brend}:Unable to play, VHS is turned off")
            return
        }
        if (tv != null) println("${this.brend}:Trying to play video tape on TV ${tv.brend}")
        if (tv != null && currentTape != null) {
            tv.displayInputStream(Stream("${currentTape?.film}"))
            return
        } else if (currentTape == null) {
            println("${this.brend}:Unable to play. Insert a video tape")
            return
        } else {
            println("${this.brend}:Connect TV to display content")
        }
    }

    override fun getDetails() {
        println("${this.brend}:Getting info")
        println("${this.brend}:VHS brend is $brend")
        println("${this.brend}:VHS model is $model")
    }

    override fun turnOff() {
        println("${this.brend}:Trying to turn off VHS")
        isTurnedOn = false
        println("${this.brend}:VHS is turned off")
    }

}

class VideoComboImpl(val brend: String, val model: String) : TV, VHS, Power, ObjectChecker, VideoComboPlayer {
    init {
        println("${this.brend}: VideoCombo is created")
    }

    override var isTurnedOn = false
    val channelsList = mutableListOf<Channel>()
    var currentCannel: Int? = null
    var currentTape: VideoTape? = null

    override fun turnOn() {
        println("${this.brend}:Trying to turn on VideoCombo")
        isTurnedOn = true
        println("${this.brend}:VideoCombo is turned on")
        display(null)
    }

    override fun turnOff() {
        println("${this.brend}:Trying to turn off VideoCombo")
        isTurnedOn = false
        println("${this.brend}:VideoCombo is turned off")
    }

    override fun insertTape(videoTape: VideoTape) {
        println("${this.brend}:Trying to insert video tape")
        if (!isTurnedOn) {
            turnOn()
            isTurnedOn = true
        }
        if (currentTape != null) {
            println("${this.brend}:Unable to insert this tape, there is tape already inserted")
            return
        }
        currentTape = videoTape
        println("${this.brend}:Video tape with a ${videoTape.film} movie inserted")
    }

    override fun ejectTape() {
        println("${this.brend}:Trying to eject video tape")
        if (!isTurnedOn) {
            println("$this.brend:Unable to eject, VideoCombo is turned off")
            return
        }
        if (currentTape != null) {
            val tape = currentTape
            currentTape = null
            println("${this.brend}:Video tape with ${tape?.film} ejected")
        } else {
            println("${this.brend}:Failed to eject, no tape inside")
        }
    }

    override fun play(): Stream? {
        if (!isTurnedOn) {
            println("${this.brend}:Unable to play, VideoCombo is turned off")
            return null
        }
        println("${this.brend}:Trying to play video tape on VideoCombo ${this.brend}")
        if (currentTape != null) {
            println("${this.brend}:Streaming ${currentTape?.film}")
            return Stream("${currentTape?.film}")
        } else {
            println("${this.brend}:Unable to play. Insert a video tape")
            return null
        }
    }

    override fun display(stream: Stream?): Stream? {
        if (stream != null) {
            println("${this.brend}: is playing ${stream.content}")
            println("${this.brend}:Streaming")
            return stream
        }
        if (currentCannel != null) {
            val channel = channelsList[currentCannel!!]
            println("${this.brend}:Current channel is ${channel.name}.")
            println("${this.brend}:Streaming")
            return channel.content
        } else {
            println("${this.brend}:Current channel is blank")
            return null
        }
    }

    override fun adjustChannel(channel: String) {
        println("${this.brend}:Trying to adjust a channel")
        if (isTurnedOn) {
            val channelSet = Channel(channel, Stream())
            channelsList.add(channelSet)
            val index = channelsList.indexOf(channelSet)
            currentCannel = index
            println("${this.brend}:$channel is set to $index")
            display(null)
        } else {
            println("${this.brend}:Can't adjust channel, VideoCombo is turned off")
        }
    }

    override fun switchChannel(index: Int) {
        println("${this.brend}:Trying to switch channel to $index")
        val channelSwitched = if (channelsList.isEmpty() || channelsList.size < index) {
            null
        } else {
            channelsList[index]
        }
        if (channelSwitched != null) {
            currentCannel = index
            println("${this.brend}:Channel switched to ${channelsList[index].name}")
            display(null)
        } else {
            println("${this.brend}:There is no channel adjusted for $index")
        }
    }

    override fun getDetails() {
        println("${this.brend}:Getting info")
        println("${this.brend}:VideoCombo brend is $brend")
        println("${this.brend}:VideoCombo model is $model")
        if (!channelsList.isEmpty()) {
            println("${this.brend}:VideoCombo has ${channelsList.size} channels adjusted")
        } else {
            println("${this.brend}:VideoCombo has no channels adjusted")
        }

        if (isTurnedOn) {
            println("${this.brend}:VideoCombo is turned on")
            val channelName = channelsList[currentCannel!!].name
            println("${this.brend}:Current channel is $channelName")
            println("")
        } else {
            println("${this.brend}:VideoCombo is turned off")
        }
    }
}