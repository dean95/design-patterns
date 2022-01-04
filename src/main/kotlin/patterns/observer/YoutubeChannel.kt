package patterns.observer

class YoutubeChannel : Observable {

    private val observers = mutableListOf<Observer>()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObserver() {
        observers.forEach(Observer::update)
    }

    fun releaseNewVideo(video: String) {
        println("New video released: $video")
        notifyObserver()
    }
}
