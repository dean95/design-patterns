package observer

private fun main() {
    val youtubeChannel = YoutubeChannel()

    val subscriber1 = YoutubeSubscriber()
    val subscriber2 = YoutubeSubscriber()
    val subscriber3 = YoutubeSubscriber()

    youtubeChannel.addObserver(subscriber1)
    youtubeChannel.addObserver(subscriber2)
    youtubeChannel.addObserver(subscriber3)
    youtubeChannel.addObserver { println("New video available") }

    youtubeChannel.releaseNewVideo("Design Patterns : Observer pattern")
}
