package section2

import collection.mutable

object Section2 {

  // Arrays

  def loud(input: Array[String]): Array[String] = input.map(_.toUpperCase)

  def concatenate(input: Array[String]): String = input.foldLeft("")(_ + " " + _).trim

  def concatenate2(input: Array[String]): String = {
    val builder = mutable.StringBuilder.newBuilder
    for(str <- input) {
      builder ++= str ++= " "
    }
    builder.toString().trim
  }

  // Seq and List

  def loud(input: Seq[String]): Seq[String] = input.map(_.toUpperCase)

  def extractWords2(input: Seq[String]): Seq[String] = input.flatMap(f => f.split(" "))

  def extractWords3(input: Seq[String]): Seq[String] = {
    for {
      str <- input
      seq <- str.split(" ")
    } yield {
      seq
    }
  }

  def extractWords(input: Seq[String]): Seq[String] = {
    val list = mutable.ListBuffer.newBuilder[String]
    for(str <- input) {
      list ++= str.split(" ").toList
    }

    list.result()
  }

  // Map

  def loud(input: Map[String, String]): Map[String, String] = input.map(t => (t._1.toUpperCase, t._2.toUpperCase))

  def counts(input: Seq[String]): Map[String, Int] = input.flatMap(_.split(" ")).toList.groupBy((word: String) => word).mapValues(_.length)

  val buffer: mutable.HashSet[(Int, Char)] = new mutable.HashSet

  def addTriedCharacter(wordId: Int, character: Char): Unit = buffer += ((wordId, character))

  def isCharacterAlreadyTried(wordId: Int, character: Char): Boolean = buffer.contains((wordId, character))
}