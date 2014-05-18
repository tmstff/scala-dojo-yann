import scala.collection.mutable.HashSet
val input = Seq("Scala is fun", "Scala is even more is", "fun is more", "more is less")

val A = input.flatMap(_.split(" "))

val B = A.toList

val C = B.groupBy(word => word)


val D = C.mapValues(list => list.length)


val buffer: HashSet[(Int, String)] = new HashSet[(Int, String)]

buffer += ((1, "hallo"))
println(buffer)
buffer += ((1, "hallo"))
println(buffer)
buffer += ((2, "hallo"))
println(buffer)







