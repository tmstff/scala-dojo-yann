// https://de.wikipedia.org/wiki/Currying
// Haskell Brooks Curry

// A function, which returns another function.
val curryAdd = (x: Int) => (y: Int) => x + y

// We define a new function, which takes a parameter and add 10 to it.
val addTen = curryAdd(10)
addTen(20)
addTen(30)

//--------------------------------------------
// We can convert a normal function into a curryied function:

// This function is a function2 with int and int to int
val nonCurryAdd: (Int, Int) => Int = (x: Int, y: Int) => x + y

// We can call the 'curried' method and convert the function 2 into
// a function1 with int to   function 1 with int to int
val newCurryAdd: Int => (Int => Int) = nonCurryAdd.curried

val addFive = newCurryAdd(5)
addFive(10)
addFive(20)


//--------------------------------------------
// We can also convert a method into a function
// with the <blank>_ operator
// And a two parameter lists method into a curried function
def methodAdd(x: Int, y: Int) = x + y
val methodToFunctionAdd: (Int, Int) => Int = methodAdd _
val methodToFunctionAddCurried = methodToFunctionAdd.curried


def twoListAdd(x: Int)(y: Int) = x + y
val twoListFuncAdd: Int => (Int => Int) = twoListAdd _
val addtwo = twoListFuncAdd(2)


