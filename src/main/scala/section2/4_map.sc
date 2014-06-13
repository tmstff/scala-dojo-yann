import scala.collection.mutable

// Method '->' creates a 2 tuple:
// -> is not a language feature!
// It's only a programmatic implicit conversion of the package PreDef
val element = "three" -> "!"

// Simple Maps
val firstMap = Map(("one","hallo"), "two" -> "welt", element)
println(firstMap("one"))

// Concatenations
val a_map = firstMap + ("three" -> "foo")

val b_map = a_map - "three"


// Mutable Maps
val mutableMap: mutable.Map[String, Int]  = mutable.Map()
mutableMap += ("foo" -> 1) += ("bar" -> 2)
val newMutableMap = mutableMap + ("baz" -> 3)


println(newMutableMap)
println(mutableMap)






