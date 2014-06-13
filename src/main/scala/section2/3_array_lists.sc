import scala.collection.mutable
// Arrays
val array = new Array[Int](10)

// Calling the syntactic sugar function 'update'
array(0) = 42
array(1) = 43
println(array.toList)

// Calling the syntactic sugar function 'apply'
println(array(1))

// Index out of bound!
array(11) = 45

// Creating an array with the static companion object
val newArray = Array(1, 2, 3, 4, 5)

// Lists
val list = List(1, 2, 3, 4, 5, 6)
println(list(4))

// Concatenations
val addList_1 = list :+ 7
val addList_2 = 0 :: list

// Creation
val emptyList = Nil
val newList = -2 :: -1 :: 0 :: Nil // Prefix operator!
val concatList = newList ::: list

// Head, tail - good for recursive functions
val head = concatList.head
val tail = concatList.tail

//Some collection api stuff
concatList.filter(p => p > 0)
concatList.map(p => p + 2)
concatList.mkString(",")
concatList.foldLeft(0)((sum, element) => sum + element)

//flatMap
val nestedList = List(List("Hallo", "Welt", "."), List("Hello", "world", "."))

// single map and flatten
val mappedList = nestedList.map(l => l.map(s => s.length))
mappedList.flatten

// flatMap!
nestedList.flatMap(l => l.map(s => s.length))

// Some mutable lists
val listBuffer  = mutable.ListBuffer[String]()
listBuffer += "hallo"
listBuffer += "welt"
"!" +=: listBuffer // Adding the element directly to the mutable list.

println(listBuffer.toList)



