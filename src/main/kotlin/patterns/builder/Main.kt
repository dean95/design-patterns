package patterns.builder

class Hamburger private constructor(
    val cheese: Boolean,
    val beef: Boolean,
    val onions: Boolean
) {
    class Builder {
        private var cheese: Boolean = false
        private var beef: Boolean = false
        private var onions: Boolean = false

        fun cheese(value: Boolean) = apply { cheese = value }
        fun beef(value: Boolean) = apply { beef = value }
        fun onions(value: Boolean) = apply { onions = value }

        fun build() = Hamburger(cheese, beef, onions)
    }

    override fun toString(): String =
        "$cheese $beef $onions"
}

private fun main() {
    val hamburger = Hamburger.Builder()
        .cheese(true)
        .onions(true)
        .build()

    println(hamburger)
}
