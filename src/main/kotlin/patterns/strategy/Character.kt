package patterns.strategy

abstract class Character {

    private var weapon: Weapon = Knife()

    fun fight() = weapon.useWeapon()

    fun setWeapon(newWeapon: Weapon) {
        weapon = newWeapon
    }

    abstract fun display()
}

class King : Character() {
    override fun display() {
        println("King")
    }
}

class Queen : Character() {
    override fun display() {
        println("Queen")
    }
}

class Knight : Character() {
    override fun display() {
        println("Knight")
    }
}
