package section3

import java.util.Calendar

object CompanionFactoryMethod extends App {
  // we use the objects apply method and the
  // direct call notation as factory
  val car = Car("blue", 14)
  println(car.colour)
  println(car.actualTires)
}

// We define a normal class 'Car'
class Car(var colour: String, age: Int) {

  private var tires = "summer"

  def actualTires = tires

  def switchTires = {
    tires = if(tires == "summer") "winter" else "summer"
  }
}

// Also an companion object for 'Car' with the method 'apply'
object Car {

  // This method is implemented as factory method.
  // Now the object can be used with this notation: Car('#colour', 42)
  def apply(colour: String, age: Int) = {
    val car = new Car(colour, age)
    val month = Calendar.getInstance().get(Calendar.MONTH)

    if (month > 9 || month < 3) {
      car.switchTires
    }

    car
  }
}
