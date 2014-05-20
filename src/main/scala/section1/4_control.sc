// IF expression
val x = 12

// Everything is a function
val value =
  if (x == 42) "hallo"
  else "nee"

// While loops
var y = 1
while(y != 4) {
  println(y)
  y += 1
}

var z = 1
do {
  println(z)
  z += 1
} while(z != 4)

// foreach loop
val list = List(2, 4, 5)
for(element <- list) {
  println(element)
}

// for with range
for(i <- 0 to 5) {
  println(i)
}

// Filtering
for(element <- list if element % 2 == 0) {
  println(element)
}

// Chained filter
for(
  element <- list
  if element % 2 == 0
  if element > 2
) {
  println(element)
}

// Nested iterations
val names = List("Hallo Welt", "Lala world !!!")

for(
  name <- names;
  word <- name.split(" ")
) {
  println(word)
}

// Nested iterations with filter
for{
  name <- names
  if name.startsWith("H")
  word <- name.split(" ")
  if word.length > 4
} {
  println(word)
}

// Yielding result to a list
val filteredNames =
  for(
    name <- names;
    word <- name.split(" ")
  ) yield {
    word.length
  }













