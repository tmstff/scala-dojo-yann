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

  test("a custom book from the json convertible book factory should be also a jsonConvertible") {
    val book: Book = new JsonConvertibleBookFactory().getABook("Programming in Scala", 852)

    book shouldBe a [Book]
    book shouldBe a [JsonConvertible]
  }

  test("a custom book from the json convertible book factory should be convertible to the json notation") {
    val book: Book = new JsonConvertibleBookFactory().getABook("Programming in Scala", 852)

    // Only to make the tests compilable without implementation.
    // We also can call house.toJson
    val jsonable: JsonConvertible = book.asInstanceOf[JsonConvertible]
    jsonable.toJson shouldBe """{"title":"Programming in Scala","pages":852}"""
  }

  test("a native house object should be also a JsonConvertible") {
    val house: House = House(4, 2, "Fakestreet")

    house shouldBe a [House]
    house shouldBe a [JsonConvertible]
  }

  test("a native house object should be directly convertible to the json notation on instantiation") {
    val house: House = House(4, 2, "Fakestreet")

    // Only to make the tests compilable without implementation.
    // We also can call house.toJson
    val jsonable: JsonConvertible = house.asInstanceOf[JsonConvertible]
    jsonable.toJson shouldBe """{"rooms":4,"floors":2,"street":"Fakestreet"}"""
  }

  test("BookStore should calculate a correct earning") {
    // Hint: Actually, the earnings are calculated randomly.
    // Try to refactor the implementation and use an injected test mock.
    val bookStore = new BookStore
    bookStore.buyABook("Book1")
    bookStore.buyABook("Book2")

    bookStore.actualEarnings shouldBe 40
  }
}

trait CustomMatcher {
  class IsAJsonConvertibleMatcher extends BePropertyMatcher[Any] {
    def apply(left: Any) = BePropertyMatchResult(left.isInstanceOf[JsonConvertible], "jsonConvertible")
  }
  val jsonConvertible= new IsAJsonConvertibleMatcher
}
