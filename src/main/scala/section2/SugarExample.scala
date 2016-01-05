package section2


object SugarExample {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List(1, 2)

    for {
      x <- list1
      if x > 1
      y <- list2
    } yield x*y
  }
}
