package playground

// We define an App object as start point
object ObjectCompanionsApp extends App {
  val r = new Rocket

  Rocket.chooseStrategy(r)
  r.refuel()
  Rocket.chooseStrategy(r)
}


// The class Rocket knows for itself if it can go home again
// Others can refuel the rocket.
class Rocket {
  private def canGoHomeAgain = Rocket.fuel > 20

  def refuel() = Rocket.fuel = 100
}

// We define an compantion object for the class Rocket
// The Rocket object has access to the private fields of the
// Rocket class. So it knows if the Rocket can go home again.
object Rocket {
  private var fuel = 10

  def chooseStrategy(rocket: Rocket) {
    // Private access to the given rocket instance.
    if(rocket.canGoHomeAgain) {
      goHome()
    } else {
      pickAStar()
    }
  }

  def goHome() = println("Going home!")
  def pickAStar() = println("To the stars and far beyond!")
}





