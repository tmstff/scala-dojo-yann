import scala.collection.mutable

/****
 * Arrays
 ****/

val array = new Array[Int](10)
array(0) = 42
array(1) = 43
println(array.toList)
//array(11) = 45

val newArray = Array(1, 2, 3, 4, 5)

// Immutable Lists - Every following operation in the list returns a new list object
val list = List(1, 2, 3, 4, 5, 6)
println(list(4))

// PS: This standalone 'Array' or 'List' is the companion object of the Array/List class. See section 3.

// List concatenations
val addList_1 = list :+ 7
val addList_2 = 0 :: list

// Creation
val emptyList = Nil // or List() as companion object
val newList = -2 :: -1 :: 0 :: Nil
val concatList = newList ::: list

// :: or ::: are prefix operators -- Operator names, which ends with a ':' can switch there parameter. Equivalent to Nil.::(0).::(-1).::(-2)

// Head, tail
val head = concatList.head
val tail = concatList.tail

//Some collection api stuff
concatList.filter(p => p > 0)
concatList.map(p => p + 2)
concatList.mkString(",")
concatList.foldLeft(0)((sum, element) => sum + element)

//flatMap
val nestedList = List(List("Hallo", "Welt", "."), List("Hello", "world", "."))
nestedList.flatten

val mappedList = nestedList.map(l => l.map(s => s.length))
mappedList.flatten

nestedList.flatMap(l => l.map(s => s.length))


// Beside the immutable collections there is a whole package of mutable counterparts.
// e.g. the mutable ListBuffer
val listBuffer  = mutable.ListBuffer[String]()
listBuffer += "hallo"
listBuffer += "welt"
"!" +=: listBuffer
println(listBuffer.toList)


