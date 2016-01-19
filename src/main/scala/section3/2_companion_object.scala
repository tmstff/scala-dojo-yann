package playground

// We define an App object as start point
object ObjectCompanionsApp {
  def main(args: Array[String]): Unit = {
    val rocket = new Rocket

    Rocket.startRocket(rocket)
    Rocket.startRocket(rocket)
    rocket.refuel()
    Rocket.startRocket(rocket)
  }
}


// The class Rocket knows for itself if it can go home again
// Others can refuel the rocket.
class Rocket {
  private var fuel = 50

  def refuel() = fuel = 100

  private def mustGoHome = fuel <= 20

  private def goHome() = {
    println("We must go home.")
    fuel = 0
  }

  private def pickAStar() = {
    println("To the stars and far beyond!")
    fuel -= 30
    Rocket.visitedStars += 1
  }
}

// We define an companion object for the class Rocket
// The Rocket object has access to the private fields of the
// Rocket class. So it knows if the Rocket can go home again.
object Rocket {
  private var visitedStars: Int = 0

  def startRocket(rocket: Rocket) {
    // Private access to the given rocket instance.
    if(rocket.mustGoHome) {
      rocket.goHome()
    } else {
      rocket.pickAStar()
    }
  }


}





