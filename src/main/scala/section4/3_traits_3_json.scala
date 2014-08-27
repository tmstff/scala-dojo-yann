package section4

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.annotation.{JsonIgnore, PropertyAccessor}
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
 * This is an example how to use traits to mixin json converting
 */

/**
 * We define our trait Json which can convert the class it was mixed in to
 * a json string. We use the jackson mapper and therefore must ignore some
 * fields.
 */
trait Json {
  @JsonIgnore
  val mapper = new ObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)

  @JsonIgnore
  def toJson: String = mapper.writeValueAsString(this)
}

/**
 * We define two simple case classes. At this point they do not know
 * of any json mangling.
 */
case class Address(street: String, city: String)
case class Customer(name: String, surname: String, address: Option[Address])

/**
 * We now can create some instances of the case classes and mixin on the fly the
 * json support. We also had mixin the json support directly to the class definition
 */
object JsonTraitMixin extends App {
  val address = new Address("Fakestreet", "Bonn") with Json
  val person = new Customer("Max", "Mustermann", Some(address)) with Json

  println(address.toJson)
  println(person.toJson)
}


/**
 * The above example can only convert our instances to json string. In this example we use
 * a type parametrised companion trait to enhance the companion objects.
 *
 * This one way to do this. We could also define a central object and give them the class type
 * at method call
 */
trait CompanionJson[T] extends Json {
  val companionClassType: Class[_ <: T]
  def fromJson(json: String): T = mapper.readValue(json, companionClassType)
}

/**
 * The companion object for the Address class. We must instantiate a prototype class, because otherwise
 * we get the object type and not the class type. This is some kind of unattractive
 */
object Address extends CompanionJson[Address] {
  val companionClassType: Class[_ <: Address] = Address("", "").getClass
}

object Customer extends CompanionJson[Customer] {
  val companionClassType: Class[_ <: Customer] = Customer("", "", None).getClass
}

object JsonTraitCompanionMixin extends App {
  val address = new Address("Fakestreet", "Bonn") with Json
  val person = new Customer("Max", "Mustermann", Some(address)) with Json

  val customer: Customer = Customer.fromJson("""{"name":"Max","surname":"Mustermann","address":{"street":"Moltkestraße","city":"Bonn"}}""")
  println("Name: " + customer.name + " " + customer.surname)
  println(Address.fromJson("""{"street":"Fakestreet","city":"Bonn"}"""))
}
