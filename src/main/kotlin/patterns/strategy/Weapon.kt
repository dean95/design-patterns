package patterns.strategy

interface Weapon {

    fun useWeapon()
}

class Sword : Weapon {
    override fun useWeapon() {
        println("Sword")
    }
}

class Knife : Weapon {
    override fun useWeapon() {
        println("Knife")
    }
}

class Axe : Weapon {
    override fun useWeapon() {
        println("Axe")
    }
}

class Gun : Weapon {
    override fun useWeapon() {
        println("Gun")
    }
}
