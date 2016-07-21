package section1

import java.io.InputStream

import org.scalatest.FunSuite
import section1.Section1.withFiles

class Section1Test extends FunSuite {

  test("Section1 greets the world") {
    assert(Section1.message === "Hello, World")
  }

  test("Section1 wants to be alone") {
    assert(Section1.greeting === "Hello, World")
    // First uncomment following line:
    //Section1.greeting = "Leave me alone, world!"
    assert(Section1.greeting === "Leave me alone, world!")
  }

  test("Section1 can calculate the max of 2 numbers") {
    assert(Section1.max(0, 3) === 3)
    assert(Section1.max(0, -3) === 0)
  }

  test("The expression is a mix from methods, values and lazy values") {
    assert(Section1.expr() === "xzyz")
  }

  test("'newConst' function using call by name can be called with function 'exception'") {
    assert(Section1.newConst(2, Section1.exception) === 2)
    assert(Section1.newConst(4, Section1.exception) === 4)
  }

  test("A 'someIntFunction' function returns a new function which will multiply its parameter with the first parameter of 'someIntFunction'") {
    val function = Section1.someIntFunction(3)
    assert(function(4) === 12)

    // Somewhere this should happen: 3 * 4
  }

  test("read files with currying") {
    // given
    import scala.collection.mutable.ListBuffer
    val filesContents = ListBuffer.empty[String]

    writeFile( filePath = "/tmp/test1", content = "a" )
    writeFile( filePath = "/tmp/test2", content = "b" )

    // when
    withFiles("/tmp/test1", "/tmp/test2") {
      stream => filesContents += stringOf(stream)
    }

    // then
    assert( filesContents(0) === "a" )
    assert( filesContents(1) === "b" )
  }

  def writeFile(filePath: String, content: String) = {
    import java.io._
    val pw = new PrintWriter(new File( filePath ))
    pw.write( content )
    pw.close
  }

  def stringOf(is: InputStream) = scala.io.Source.fromInputStream(is).mkString
}
