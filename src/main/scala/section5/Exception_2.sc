// We define a case class with the require method.
// With this method we can assert a correct paramter range
// on creation.
case class House(rooms: Int) {
  require(rooms > 0, "Rooms must be greater than 0")
}

val house = House(0)




