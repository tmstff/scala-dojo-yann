package section4

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.annotation.{JsonIgnore, PropertyAccessor}
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import scala.reflect.{ClassTag, classTag}

trait Json {
  @JsonIgnore
  val mapper = new ObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)

  @JsonIgnore
  def toJson: String = mapper.writeValueAsString(this)

  @JsonIgnore
  def fromJson[A : ClassTag](json: String) = mapper.readValue(json, classTag[A].runtimeClass)
}

case class Address(street: String, city: String) extends Json
case class Person2(name: String, surname: String, address: Address)

object Address extends Json

object JsonTraitMixin extends App {
  val address = new Address("Fakestreet", "Bonn")
  val person = new Person2("Max", "Mustermann", address) with Json

  println(address.toJson)
  println(person.toJson)
  println(Address.fromJson[Address](address.toJson))
}
