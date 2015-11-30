package monads.motivation


object ScalaBillCalculator {

  /** We can use the Option monad to capsule the possible
    * null references and the null handling.
    */
  def calculateBillForUser(user: User): Int = {
    /** Option offers a type constructor.
      * We get an object of the type Option[User].
      * This object is now either of the subtype Some, of the reference is not null
      * or None if the reference is null.
      */
    val mayUser: Option[User] = Option(user)

    /** Now Option has some methods to transform the internal value and type.
      * flatMap transforms the type T to an Option[U]
      * So if we want to get the contract from a user, we can use flatMap to transform the
      * User to an Option[Contract]. We have to capsule contract in an Option, cause the
      * contract reference may be null.
      */
    val mayContract: Option[Contract] = mayUser.flatMap(user => Option(user.getContract))
    val mayTariff: Option[Tariff] = mayContract.flatMap(contract => Option(contract.getTariff))

    /** The last transformation is from Tariff to Int. Cause basicFee returns a
      * primitive int, we do not need to capsule this value into an Option.
      * So, we can use map. Map transforms a type T to an type U. In this case,
      * we transform the Tariff into an Int. The return value of map is therefore
      * an Option[Int]
      */
    val mayFee: Option[Int] = mayTariff.map(tariff => tariff.basicFee())

    /** mayFee is now an Option[Int]. The value can be a Some[Int] if every reference was
      * not null or None if any reference was null.
      * We can make a pattern match on Some or None or just use getOrElse to get the calculated
      * value or the given default value if mayFee is None.
      */
    mayFee.getOrElse(0)
  }

  /**
   * Of course we can just chain the methods. ;-)
   */
  def calculateBillForUser_2(user: User): Int = {
    Option(user).
      flatMap(user => Option(user.getContract)).
      flatMap(contract => Option(contract.getTariff)).
      map(tariff => tariff.basicFee).
      getOrElse(0)
  }

  /**
   * Also we can use the for comprehension style
   */
  def calculateBillForUser_3(user: User): Int = {
    val mayTariff: Option[Int] = for {
        mayUser <- Option(user)
        contract <- Option(mayUser.getContract)
        tariff <- Option(contract.getTariff)
    } yield tariff.basicFee

    mayTariff.getOrElse(0)
  }
}
