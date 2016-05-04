package section4

import org.scalatest.{FunSuite, Matchers}
import section4.Section4._
import section4.Section4.Book
import section4.Section4.House
import org.scalatest.matchers.{BePropertyMatchResult, BePropertyMatcher}
import section4.Section4.{Cigarettes, LaxistStore, NoIdException, Store, UnderAgeException, LaxistStore => _, _}

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

  test("a customer under 18 is not allowed to buy cigarettes") {
    intercept[UnderAgeException] {
      new Store().buyCigarettes(Customer(15))
    }
  }

  test("a customer not allowed to buy cigarettes should be informed why") {
    val thrown = the [UnderAgeException] thrownBy {
      new Store().buyCigarettes(Customer(15))
    }
    thrown.getMessage shouldEqual "Customer must be older than 18 but was 15"
  }

  test("a customer with 18 is allowed to buy cigarettes if he can show an ID") {
    new Store().buyCigarettes(Customer(18, true)) shouldBe a [Cigarettes]
  }

  test("a customer with 18 is not allowed to buy cigarettes if he cannot show an ID") {
    intercept[NoIdException] {
      new Store().buyCigarettes(Customer(18, false))
    }
  }

  test("a customer's age must be positive") {
    intercept[IllegalArgumentException] {
      Customer(-2)
    }
  }

  test("a customer under 18 is not allowed to buy cigarettes, even in a laxist store") {
    intercept[UnderAgeException] {
      new LaxistStore().buyCigarettes(Customer(15))
    }
  }

  test("a customer over 18 is allowed to buy cigarettes, even without ID in a laxist store") {
    new LaxistStore().buyCigarettes(Customer(18, false)) shouldBe a [Cigarettes]
  }
}

trait CustomMatcher {
  class IsAJsonConvertibleMatcher extends BePropertyMatcher[Any] {
    def apply(left: Any) = BePropertyMatchResult(left.isInstanceOf[JsonConvertible], "jsonConvertible")
  }
  val jsonConvertible= new IsAJsonConvertibleMatcher
}
