// We can easily throw exceptions:
throw new IllegalArgumentException("foobar")


// We can catch the stuff with some case clauses
try {
  throw new IllegalArgumentException("foobar")
}
catch {
  case npe : NullPointerException => println("NullPointerException catched")
  case iae : IllegalArgumentException => println("IllegalArgumentException catched")
  case _ => println("Unknwon error raised")
}


// Also we can define a finally block
try {
  throw new IllegalArgumentException("foobar")
}
catch {
  case npe : NullPointerException => println("NullPointerException catched")
  case iae : IllegalArgumentException => println("IllegalArgumentException catched")
  case _ => println("Unknwon error raised")
}
finally {
  println("Some finally code")
}


