package section2

import collection.mutable

object Section2 {

  // Arrays

  def loud(input: Array[String]): Array[String] = input.map(_.toUpperCase)

  def concatenate(input: Array[String]): String = input.foldLeft("")(_ + " " + _).trim

  // Seq and List

  def loud(input: Seq[String]): Seq[String] = input.map(_.toUpperCase)

  def extractWords(input: Seq[String]): Seq[String] = input.flatMap(f => f.split(" "))

  // Map

  def loud(input: Map[String, String]): Map[String, String] = input.map(t => (t._1.toUpperCase, t._2.toUpperCase))

  def counts(input: Seq[String]): Map[String, Int] = input.flatMap(_.split(" ")).toList.groupBy((word: String) => word).mapValues(_.length)

  val buffer: mutable.HashSet[(Int, Char)] = new mutable.HashSet

  def addTriedCharacter(wordId: Int, character: Char): Unit = buffer += ((wordId, character))

  def isCharacterAlreadyTried(wordId: Int, character: Char): Boolean = buffer.contains((wordId, character))
}