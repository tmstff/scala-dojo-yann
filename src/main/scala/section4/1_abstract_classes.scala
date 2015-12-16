package section4

// a simple abstract class
// with an abstract method
abstract class Car {
  // We can define abstract methods like in java
  def startEngine: String

  // But we can also define abstract FIELDS
  val color: String

  // And predefine some fields
  val tireCount: Int = 4
}

// We can extend a sub class but must implement the startEngine method and
// implement the color field with a value
class Bmw(fuel: Int) extends Car {

  def startEngine: String = "WWRRRRÖÖÖÖÖAAAAAAAAMMMMMMMMMMMM!!!"

  val color = "blue"  // This is a field "implementation"
}

// We extends an abstract fueled car with a new constructor argument
abstract class FueledCar(fillingLevel: Int) extends Car {
  // We set the color implementation as final.
  // So no inherited class can override it. Like in Java.
  final val color: String = "blue"
}

// We can override the tireCount method
// In scala me MUST add the prefix override
// We also must give the inherited class a constructor argument
// This PiaggioApe is final. It can not be inherited!
final class PiaggioApe extends FueledCar(40) {
  // Implements the startEngine METHOD as a VALUE!
  // This ist possible. But you can not implement a val
  // definition with a method, cause the scala compiler
  // checks if the implementation is a strict immutable value
  // So: def -> var
  //     def -> val
  //     var -> val
  //     var -> def
  val startEngine: String = "Töf töf töf töf töf töf töf..."

  // Here we override the pre defined value.
  override val tireCount = 3

  // We can not override the color cause it's final.
  // override def color = "green"
}














