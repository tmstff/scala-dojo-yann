package section4

import com.fasterxml.jackson.annotation.{JsonIgnore, PropertyAccessor}
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import scala.util.Random

object Section4 {

  trait JsonConvertible {
    @JsonIgnore
    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)

    @JsonIgnore
    def toJson: String = mapper.writeValueAsString(this)
  }

  case class Book(title: String, pages: Int)
  case class House(rooms: Int, floors: Int, street: String) extends JsonConvertible

  trait BookFactory {
    def getABook(title: String, pages: Int): Book
  }

  class JsonConvertibleBook(t: String, p: Int) extends Book(t, p) with JsonConvertible

  class JsonConvertibleBookFactory extends BookFactory {
    def getABook(title: String, pages: Int): Book = new Book(title, pages) with JsonConvertible
  }

  class BookCatalogue {
    val bookFactory: BookFactory = new JsonConvertibleBookFactory
    val catalogue = Map(
      "Book1" -> bookFactory.getABook("Book1", 100),
      "Book2" -> bookFactory.getABook("Book2", 150),
      "Book3" -> bookFactory.getABook("Book3", 200),
      "Book4" -> bookFactory.getABook("Book4", 250),
      "Book5" -> bookFactory.getABook("Book5", 300),
      "Book6" -> bookFactory.getABook("Book6", 350),
      "Book7" -> bookFactory.getABook("Book7", 400)
    )

    def getBook(title: String) = catalogue(title)
  }

  class PriceResolver {
    def getPrice(book: Book): Int = Random.nextInt % 30
  }

  class BookStore(private val priceResolver: PriceResolver = new PriceResolver) {
    private val bookCatalogue: BookCatalogue = new BookCatalogue
    private var earnings: Int = 0

    def buyABook(title: String): Book = {
      val book = bookCatalogue.getBook(title)
      earnings = earnings + priceResolver.getPrice(book)
      book
    }

    def actualEarnings = earnings
  }

  class Cigarettes
  case class UnderAgeException(message: String) extends Exception(message)
  case class NoIdException(message: String) extends Exception(message)

  case class Customer(age: Int, haveId: Boolean = false) {
    require(age >= 0)
  }

  class Store {
    @throws[UnderAgeException]
    @throws[NoIdException]
    def buyCigarettes(customer: Customer): Cigarettes = customer match {
      case Customer(age, _) if age < 18 => throw new UnderAgeException(s"Customer must be older than 18 but was ${age}")
      case Customer(_, false) => throw new NoIdException("Customer has no valid id")
      case _ => new Cigarettes
    }
  }


  class LaxistStore extends Store {
    @throws[UnderAgeException]
    override def buyCigarettes(customer: Customer): Cigarettes = customer match {
      case Customer(age, _) if age < 18 => throw new UnderAgeException(s"Customer must be older than 18 but was ${age}")
      case _ => new Cigarettes
    }
  }

}
