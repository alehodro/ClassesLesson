data class Event(val type: String)

class Subscriber(val name: String, var events: List<Event>) : SubscriberInterface {
    init {
        println("Создан подписчик $name")
    }
    override fun update(publisher: String, event: Event) {
        println("Подписчик $name уведомлен о событии ${event.type} в издателе $publisher")
    }

}

interface SubscriberInterface {
    fun update(publisher: String, event: Event)
}

interface PublisherInterface {
    fun subscribe(subscriber: Subscriber)
    fun unsubscribe(subscriber: Subscriber)
}


class Publisher(val name: String) : PublisherInterface {
    val subscribers = mutableListOf<Subscriber>()
    var state: Event? = null

    fun changeState(event: Event) {
        state = event
        notifySubscriber(event)
    }

    override fun subscribe(subscriber: Subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber)
            println("New subscriber ${subscriber.name} added, for events:(${subscriber.events}) in $name publisher")
        } else {
            val index = subscribers.indexOf(subscriber)
            subscribers[index].events = subscriber.events
            println("Events list: (${subscriber.events}) has been updated for subscriber ${subscriber.name} in $name publisher")
        }
    }

    override fun unsubscribe(subscriber: Subscriber) {
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber)
        } else {
            println("Not found")
        }
    }

    private fun notifySubscriber(event: Event) {
        val subscribersToNotify = subscribers.filter {
            it.events.contains(event)
        }
        subscribersToNotify.forEach { it.update(this.name,event)}
    }

}

