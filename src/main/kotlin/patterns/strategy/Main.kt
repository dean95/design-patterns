package patterns.strategy

private fun main() {
    val queen = Queen()
    queen.display()
    queen.fight()
    queen.setWeapon(Axe())
    queen.fight()

    println("---------")

    val king = King()
    king.display()
    king.fight()
    king.setWeapon(Gun())
    king.fight()
}
