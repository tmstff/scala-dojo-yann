/****
 * The for comprehension
 *****/

val list = List(2, 4, 5)

// Filtering
// We can add a if statement behind the iterator to filter each element.
for(element <- list if element % 2 == 0) {
  println(element)
}

// Chained filter
// We can chain n filters for an iterator
for(
  element <- list
  if element % 2 == 0
  if element > 2
) {
  println(element)
}

// Nested iterations
// We can also nest iterations in one statement.
// The following statement loops over the list and for each list element over the split(' ') result array.
val names = List("Max Mustermann", "Hans Dampf")
for(
  name <- names;
  word <- name.split(" ")
) {
  println(word)
}

// Nested iterations with filter
// We can also adding a filter statement for each iterator.
// Hint: If using the for with ( - braces, you have to add a semicolon after each statement.
//       Using for with curly braces, the statements are interpreted as code block.
for {
  name <- names
  if name.startsWith("H")
  word <- name.split(" ")
  if word.length > 4
} {
  println(word)
}

// Yielding result to a list
// For each nested iteration, the yield block is executed. The result in this example is a list of the word length.
val filteredNames =
  for(
    name <- names;
    word <- name.split(" ")
  ) yield {
    word.length
  }
