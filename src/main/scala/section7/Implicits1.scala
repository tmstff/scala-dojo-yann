package section7

object Implicits1 extends App {
  // Simple example
  // We have an plain java integer
  val i: java.lang.Integer = 4


  // and a scala Double
  val j: Double = 1.5

  // No why has the java integer object the '+' method which can
  // take the scala Double, add it an return in a scala Double?
  val x: Double = i + j

  // The answer lies in the PreDef object, which is always in the scala
  // compile scope:
  /*
    implicit def Integer2int(x: java.lang.Integer): Int         = x.intValue
   */
  // This implicit method takes the java Integer and converts it to scala int.
  // So, the compiler knows of this method. In our example the compiler needs to
  // convert the Integer to something which has the method 'x(value: Double)'
  // and that's an int.

  // When we let the compiler show us the sugarless code we get:
  // The 4 literal is converted with scala.this.Predef.int2Integer(4) to an java Integer
  // Then, the i java Integer value will be back converted to a scala int with
  // scala.this.Predef.Integer2int(Implicits1.this.i()) and this object has the "+"-method.
  /*
    private[this] val i: Integer = _;

    <stable> <accessor> def i(): Integer = Implicits1.this.i;

    private[this] val j: Double = _;

    <stable> <accessor> def j(): Double = Implicits1.this.j;

    private[this] val x: Double = _;

    <stable> <accessor> def x(): Double = Implicits1.this.x;

    final <synthetic> def delayedEndpoint$Implicits1$1: Unit = {
      Implicits1.this.i = scala.this.Predef.int2Integer(4);
      Implicits1.this.j = 1.5;
      Implicits1.this.x = scala.this.Predef.Integer2int(Implicits1.this.i()).+(Implicits1.this.j());
      ()
    };
  */
}

