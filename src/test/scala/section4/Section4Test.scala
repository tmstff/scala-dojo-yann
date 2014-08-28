package section4

import org.scalatest.{Matchers, FunSuite}
import section4.Section4._
import section4.Section4.Book
import section4.Section4.House
import org.scalatest.matchers.{BePropertyMatchResult, BePropertyMatcher}

class Section4Test extends FunSuite with Matchers with CustomMatcher {

  test("a native Book instance should not be convertible to json") {
    val nativeBook: Book = Book("Programming in Scala", 852)
    nativeBook shouldNot be a jsonConvertible
  }

  test("a custom book from getABook should be convertible to the json notation") {
    val book: Book = getABook("Programming in Scala", 852)

    book shouldBe a [Book]
    book shouldBe a [JsonConvertible]

    // Only to make the tests compilable without implementation.
    // We also can call house.toJson
    val jsonable: JsonConvertible = book.asInstanceOf[JsonConvertible]
    jsonable.toJson shouldBe """{"title":"Programming in Scala","pages":852}"""
  }

  test("a custom house should be directly convertible to the json notation on instantiation") {
    val house: House = House(4, 2, "Fakestreet")

    house shouldBe a [House]
    house shouldBe a [JsonConvertible]

    // Only to make the tests compilable without implementation.
    // We also can call house.toJson
    val jsonable: JsonConvertible = house.asInstanceOf[JsonConvertible]
    jsonable.toJson shouldBe """{"rooms":4,"floors":2,"street":"Fakestreet"}"""
  }
}

trait CustomMatcher {
  class IsAJsonConvertibleMatcher extends BePropertyMatcher[Any] {
    def apply(left: Any) = BePropertyMatchResult(left.isInstanceOf[JsonConvertible], "jsonConvertible")
  }
  val jsonConvertible= new IsAJsonConvertibleMatcher
}
