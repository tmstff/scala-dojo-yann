// Let assume a list of integers
val list = List(1, 2, 3, 4, 5, 6, 7)

// And two function1s which can transform the list
val double = (x: Int) => x + x
val addTwo = (x: Int) => x + 2

// We can call the map method with the two function in serial
list.map(double).map(addTwo)

// Or we can combine the two mapping functions to one new function:
val newFunction1 = double compose addTwo
val newFunction2 = double andThen addTwo
list.map(newFunction1)
list.map(newFunction2)

// The difference between compose and andThen is:
// f compose g => f(g(x))
// f andThen f => g(f(x))


// More complex example:
case class Contract(groundFee: Int)
case class Customer(name: String, contract: Contract)
case class Company(name: String, customer: Customer)

val toCustomer = (c: Company) => c.customer
val toContract = (c: Customer) => c.contract
val getFee = (c: Contract) => c.groundFee

val corpList = List(
  Company("Corp One", Customer("Max Mustermann", Contract(42))),
  Company("Maxi Corp", Customer("Hans Dampf", Contract(12)))
)

corpList.map(toCustomer).map(toContract).map(getFee)

// We can also combine these functions
val companyToFee = toCustomer andThen toContract andThen getFee
corpList.map(companyToFee)

// We can also use compose, but as we operate on different types, we must compose
// the function in the oppoite order
val companyToFee2 = getFee compose toContract compose toCustomer
corpList.map(companyToFee2)


