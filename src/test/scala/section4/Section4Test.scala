package section4

import org.scalatest.{Matchers, FunSuite}
import section4.Section4._

class Section4Test extends FunSuite with Matchers {

  test("a custom book should be convertible in a json notation") {
    val book: Book = getABook("Programming in Scala", 852)

    book shouldBe a [Book]
    book shouldBe a [JsonConvertible]

    // Only to make the tests compilable without implementation.
    // We also can call house.toJson
    val jsonable: JsonConvertible = book.asInstanceOf[JsonConvertible]
    jsonable.toJson shouldBe """{"title":"Programming in Scala","pages":852}"""
  }

  test("a custom house should be convertible in a json notation") {
    val house: House = getAHouse(4, 2, "Fakestreet")

    house shouldBe a [House]
    house shouldBe a [JsonConvertible]

    // Only to make the tests compilable without implementation.
    // We also can call house.toJson
    val jsonable: JsonConvertible = house.asInstanceOf[JsonConvertible]
    jsonable.toJson shouldBe """{"rooms":4,"floors":2,"street":"Fakestreet"}"""
  }


}
