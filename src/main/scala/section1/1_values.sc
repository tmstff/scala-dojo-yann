2.toString

2 + 2
2.+(2)
2 toString()
3.3

true
true.toString

// Object equality
val l = List(1, 2, 3)
val ll = List(1, 2, 3)
l == ll

// defining a immutable value
val x: String = "hello world"

// short form
val xx = "hallo other world"

// variables can be reassigned
var y: String = "This is a var"
y = "Another value"
// Lazy val init on first read
lazy val z = {
  println("Z initialized")
  Thread.sleep(5000)
  42
}
println("Making some very important stuff which has to be fast")
Thread.sleep(1000)
println(z)

// Non lazy val init on deceleration
val zz = {
  println("Initializing some sloooooow zz")
  Thread.sleep(5000)
  42
}

println("Making some very important stuff which has to be fast")
Thread.sleep(1000)
println(z)
