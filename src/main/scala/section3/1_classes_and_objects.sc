// Class with public and private vals and vars
// Accessing a private val through a field look alike
// method
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum: Int = ~(sum & 0xFF) + 1
}
val foo = new ChecksumAccumulator
foo.add(23)
foo.checksum

foo.add(10)
foo.checksum


