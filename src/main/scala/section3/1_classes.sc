// Class with public and private vals and vars
// Accessing a private val through a field look alike
// method
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


// Class with constructor arguments
// With the 'var' prefix, the variable is public
class ConstructorClass(private val x: Int, var y: Int, val z: Int) {
  // All statements are executed while constructing
  println(s"Value $x set as value")
  def sum = x+y+z
}
val ref2 = new ConstructorClass(1, 2, 3)
val ref3 = new ConstructorClass(1, 2, 3)

// false... You have to override equals like in java
ref2 == ref3

ref2.sum

ref2.y = 10
ref2.sum

ref2.z
