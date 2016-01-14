import scala.collection.mutable

/****
 * Maps
 ****/

// Immutable Map
// Each entry is a Tuple2 with a key and value
// We can define an entry directly as tuple or with the implicit arrow notation
val firstMap = Map( ("one", "hallo"), "two" -> "welt")
println(firstMap("one"))

// Concatenations
val a_map = firstMap + ("three" -> "foo")
val b_map = a_map - "three"

// Mutable counterpart
val mutableMap: mutable.Map[String, Int]  = mutable.Map()
mutableMap += ("foo" -> 1) += ("bar" -> 2)
val newMutableMap = mutableMap + ("baz" -> 3)

println(newMutableMap)
println(mutableMap)

// Outlook:
// If you ask how such statements
//   "key" -> 123, or 1 to 5
// are possible. These are implicit conversions. Like the autoboxing known from java, scala allows own definitions
// of these conversions. So in the above example, the String "key" is implicit converted to an object of the class
// ArrowAssoc of some type A. This object has the '->' method, which takes a value of some type B and returns a
// tuple of type A, B.
//
// For more information how to write your own conversions see section 7.






