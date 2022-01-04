package patterns.observer

class YoutubeSubscriber : Observer {
    override fun update() {
        println("New video available.")
    }
}
