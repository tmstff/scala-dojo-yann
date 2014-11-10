package section7

object Implicts2 extends App {

  def foo1(x: Int)(implicit y: Int, z: Double) = {
    def foo2(a: Int)(implicit b: Int) = {
      x + y
    }
    foo2(x) + z
  }

  implicit val x: Int = 5
  implicit val y: Double = 5

  println(foo1(10))


//  val f = foo1 _
//  val someOtherf = f(5)
//  val list = List(10, 25, 35, 45)
//  println(list.filter(i => 15 == someOtherf(i)))


}
