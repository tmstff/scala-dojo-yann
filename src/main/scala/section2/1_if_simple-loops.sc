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