import scala.collection.mutable

// Simple Maps
val firstMap = Map("one" -> "hallo", "two" -> "welt")
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






