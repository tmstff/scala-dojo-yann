val list1 = List(1, 2, 3)
val list2 = List(1, 2)

// A for comprehension is just syntactic sugar
// for the generic collection api of scala and
// uses map, flatMap and withFilter

// This for comprehension is completely equals...
for {
  x <- list1
  y <- list2
} yield x*y

// ...to this:
val result2 = list1.flatMap(x => list2.map(y => x*y))

// Also filters are mapped...
for {
  x <- list1
  if x == 1
  y <- list2
} yield x*y

// ...to a functional style:
list1.withFilter(x => x == 1).flatMap(x => list2.map(y => x*y))


// foreach counter from the beginning:
for(i <- 1 to 3) println(i)

// The implicit method (comes later!) converts the Int 1 and its parameter
// to a collection of type Range with (1, 2, 3)
// This collection can be traversed by map, flatMap, filter what else...
val range = 1.to(3)
range.map(x => println(x))


//
// A pre compiled Scala for comprehension without syntactic sugar:
//---------------------------------------------------------------------------
//
/*
private[this] val list1: List[Int] = immutable.this.List.apply[Int](1, 2, 3);
<stable> <accessor> def list1: List[Int] = Foo.this.list1;

private[this] val list2: List[Int] = immutable.this.List.apply[Int](1, 2);
<stable> <accessor> def list2: List[Int] = Foo.this.list2;

Foo.this.list1.withFilter(((x: Int) => x.==(1))).flatMap[Int, List[Int]](((x: Int) => Foo.this.list2.map[Int, List[Int]](((y: Int) => x.*(y)))(immutable.this.List.canBuildFrom[Int])))(immutable.this.List.canBuildFrom[Int])
/*

/*
 Which is this:
 list1.withFilter(x => x == 1).flatMap(x => list2.map(y => x*y))
*/

/*
  You can print the syntactic sugar less code with
  --> scalac -Xprint:typer Foo.scala
*/