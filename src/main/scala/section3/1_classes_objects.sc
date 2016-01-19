// Class with a private var
// Accessing it through public methods
class ChecksumAccumulator {
  private var sum: Int = 0
  def add(b: Byte) { sum += b }
  def checksum: Int = ~(sum & 0xFF) + 1
}

val ref = new ChecksumAccumulator
ref.add(23)
ref.checksum

ref.add(10)
ref.checksum

// ------------------------------
// Class with constructor arguments
// With the 'var' prefix, the variable is public
class ConstructorClass(private val x: Int, var y: Int, val z: Int = 20) {

  // All statements between the class braces are executed while constructing.
  println(s"Value $x set as value")

  // We can define another typed constructor
  def this(x: String, y: String) {
    this(x.toInt, y.toInt, 10)
  }

  def sum = x+y+z
}

new ConstructorClass(1, 2)
new ConstructorClass("1", "2")

val ref2 = new ConstructorClass(1, 2, 3)
val ref3 = new ConstructorClass(1, 2, 3)

// false... You have to override equals like in java
ref2 == ref3

// Call the public method
ref2.sum

// Override the public mutable field 'y'
ref2.y = 10
ref2.sum

// Access the immutable public field 'z'
ref2.z


// ---------------------------
// Access definitions
class Car() {
  // Only accessible from within the this scope
  private[this] def isOnTestBench(): Boolean = {
    println("Shutting down turbo boost. Switching to lame duck mode.")
    true
  }

  // Private is class private but not object private
  private def initAirbags {
    println("PUFFF!")
  }

  def startEngine(): Unit = {
    println("Starting engine")
    isOnTestBench()
  }

  def crashWith(other: Car) {
    other.initAirbags
  }
}

// Objects are static elements in scala.
// Like java classes with static fields and methods
object ThisIsAStaticObject {
  var someField = 42

  def printField = println(s"This is the field: $someField.")
}


ThisIsAStaticObject.printField
ThisIsAStaticObject.someField = 123
ThisIsAStaticObject.printField
