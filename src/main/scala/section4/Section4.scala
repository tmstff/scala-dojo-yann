package section4

import com.fasterxml.jackson.annotation.{PropertyAccessor, JsonIgnore}
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility

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
  case class House(rooms: Int, floors: Int, street: String)

  // Returns a new Book object
  def getABook(title: String, pages: Int): Book = ???

  // Returns a new House object
  def getAHouse(rooms: Int, floors: Int, street: String): House = ???


}
