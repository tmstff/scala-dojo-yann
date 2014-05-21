// primitive types are also objects
2.toString

true
true.toString

// There are no operators. Only methods.
2 + 2
2.+(2)
2 toString()
3.3

// Object equality
val l = List(1, 2, 3)
val ll = List(1, 2, 3)

// Equals values
l == ll

// Equals reference
l eq ll

// Tuples
val tuple = (1, "hallo", 3.3)
println(tuple._1)
println(tuple._2)
println(tuple._3)

// defining an immutable "value" (val)
val x: String = "hello world"
// short form
val xx = "hallo other world"

// "variables" (var) can be reassigned
var y: String = "This is a var"
y = "Another value"

// lazy init on first read with lazy val
lazy val z = {
  println("Z initialized")
  Thread.sleep(5000)
  42
}
println("Making some very important stuff which has to be fast")
Thread.sleep(1000)
println(z)


// non lazy init on declaration with val
val zz = {
  println("Initializing some sloooooow zz")
  Thread.sleep(5000)
  42
}


println("Making some very important stuff which has to be fast")
Thread.sleep(1000)
println(z)
