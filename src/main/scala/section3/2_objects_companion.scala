package playground

object ObjectCompanions extends App {
  val r = new Rocket

  Rocket.chooseStrategy(r)
  r.refuel()
  Rocket.chooseStrategy(r)
}

class Rocket {
  private def canGoHomeAgain = Rocket.fuel > 20

  def refuel() = Rocket.fuel = 100
}

object Rocket {
  private var fuel = 10

  def chooseStrategy(rocket: Rocket) {
    if(rocket.canGoHomeAgain) {
      goHome()
    } else {
      pickAStar()
    }
  }

  def goHome() = println("Going home!")
  def pickAStar() = println("To the stars and far beyond!")
}





