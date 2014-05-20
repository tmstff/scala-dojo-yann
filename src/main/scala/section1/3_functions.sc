(x: Int) => println(x)

// A variable of type (Int, Int) => Int and a function value
val g: (Int, Int) => Int = (x: Int, y: Int) => x+y

// short form
val gg = (x: Int, y: Int) => x+y
g(1, 2)
// method returns a function of type (Int, Int) => Int
def f = (x: Int, y: Int) => x+y
f(1, 2)

// Using function values as parameters
def makeSomethingWithInt(x: Int, f: (Int) => Int) = f(x)
makeSomethingWithInt(8, (x: Int) => x * 2) // long
makeSomethingWithInt(8, (x) => x * 2) // short
makeSomethingWithInt(8, _ * 2) // shorter with wildcard

makeSomethingWithInt(8, (x: Int) => {
  println(x)
  x
})


// Using a function value for many purposes
val someFunc = (x: Int) => x*2
makeSomethingWithInt(8, someFunc)

val list = List(1, 2, 3)
list.map(someFunc).foreach(println)

// Call by name vs. call by value
def someConst(): Int = {
  println("someConst called")
  1
}
def someMethod(x: () => Int): Int = {
  println("someMethod called")
  x()
}

someMethod(someConst)


// Some special: Getting the 'function' of the 'method'
def sum(x: Int, y: Int):Int = x+y
val a = sum _
a(1,2)

