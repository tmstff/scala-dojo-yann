
val list = List(2, 4, 5)

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
