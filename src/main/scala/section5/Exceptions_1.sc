// We can easily throw exceptions:
throw new IllegalArgumentException("foobar")



// We can catch the exception with some case clauses
try {
  throw new IllegalArgumentException("foobar")
} catch {
  case npe : NullPointerException => println("NullPointerException catched")
  case iae : IllegalArgumentException => println("IllegalArgumentException catched")
  case _ : Throwable => println("Unknwon error raised")
}

// Also we can define a finally block
try {
  throw new IllegalArgumentException("foobar")
} catch {
  case npe : NullPointerException => println("NullPointerException catched")
  case iae : IllegalArgumentException => println("IllegalArgumentException catched")
  case _ : Throwable => println("Unknown error raised")
} finally {
  println("Some finally code")
}

// By the way:
// The case block is just a partial function.
// So, we can reuse a generic catch block
val exceptionHandler = PartialFunction[Throwable, Unit] {
  case e : IllegalArgumentException => println("foobar!")
}

try {
  throw new IllegalArgumentException("foobar")
} catch exceptionHandler




