package section4

case class Passenger(hasTicket: Boolean)

case class Train(var passengers: List[Passenger]) {
  def addPassenger(passenger: Passenger) = this.copy(passenger :: passengers)
}

class FastTrain(var speed: Int = 300) extends Train(Nil)
class Plane(var maxHeight: Int)



trait Conductor {
  this: Train =>
  def findFareDodgers: Int = passengers.count(p => !p.hasTicket)
}

object SelfType extends App {
  val train = new Train(
    List(Passenger(true), Passenger(false), Passenger(true), Passenger(false))
  ) with Conductor

  val fastTrain = new FastTrain with Conductor
  // Does not compile
  //val plane = new Plane(10000) with Conductor

  println(train.findFareDodgers)
  println(fastTrain.findFareDodgers)
}
