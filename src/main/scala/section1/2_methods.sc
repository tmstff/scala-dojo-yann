// Defining methods short and long
def sum(x: Int, y: Int):Int = x+y
sum(3, 4)

def sum2(x: Int, y: Int): Int = {
  val z = x + y
  z // The last expression is the return value
}

// Defining unit methods
def unitMethod(x: String) { // <-- no equals sign: No return value
  println(x)
}

// repeated parameter
def repeatedParameters(values: String*) = {
  values.mkString(" ")
}
repeatedParameters("Hallo", "Welt", "!!!")

// named arguments
def namedArguments(value: String, splitAt: Char) = {
  value.split(splitAt)
}

namedArguments(splitAt = '.', value = "Hallo.Welt.!!!")

// Default parameter values
def splitMethodDefault(value: String, splitAt: Char = '.') = {
  value.split(splitAt)
}
splitMethodDefault("Hallo.Welt.!!!")

//http://docs.scala-lang.org/cheatsheets/

