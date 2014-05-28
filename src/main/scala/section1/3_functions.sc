// Skeleton of a function
  (x: Int, y: Int) => x+y
// |   |   |   |    |    |
// |   |   |   |    +----+
// |   |   |   |      |
// |   |   |   |      function body
// |   |   |   |
// |   |   |   |
// |   |   |   second parameter type
// |   |   |
// |   |   second parameter name
// |   |
// |   first parameter type
// |
// first parameter name

// A value of type (Int, Int) => Int and a function value
val g: (Int, Int) => Int   =   (x: Int, y: Int) => x+y
//     |                |      |                      |
//     +----------------+      +----------------------+
//       |                       |
//       The function type       |
//                               |
//                               function body

// short form
val gg = (x: Int, y: Int) => x+y
gg(1, 2) // Gets the value of gg and then calls the given function

// This is a method which returns a function of type (Int, Int) => Int
def f = (x: Int, y: Int) => x+y
f(1, 2) // Calls the def and then the returned function

// Using function values as parameters
def makeSomethingWithInt(x: Int, f: (Int) => Int) = f(x)
makeSomethingWithInt(8, (x: Int) => x * 2) // long
makeSomethingWithInt(8, (x) => x * 2) // short
makeSomethingWithInt(8, x => x * 2) // shorter
makeSomethingWithInt(8, _ * 2) // even shorter with wildcard. Per parameter one wildcard!

// Function value with multi line body
makeSomethingWithInt(8, (x: Int) => {
  println(x)
  x
})



// Using a function value for many purposes
val list = List(1, 2, 3)

val someFunc = (x: Int) => x*2
makeSomethingWithInt(8, someFunc)
list.map(someFunc).foreach(println)



// Some special: Getting the 'function' of the 'method'
def sum(x: Int, y: Int):Int = x+y
val a = sum _ //<---- ' _'
a(1,2)

