package section2

import collection.mutable
import scala.annotation.tailrec
import scala.Predef._

object Section2 {

  // Arrays
  def loud(input: Array[String]): Array[String] = input.map(_.toUpperCase)

  // higher order functions
  def concatenate(input: Array[String]): String = input.foldLeft("")(_ + " " + _).trim

  // imperative
  def concatenate2(input: Array[String]): String = {
    val builder = mutable.StringBuilder.newBuilder
    for(str <- input) {
      builder ++= str ++= " "
    }
    builder.toString().trim
  }

  // direct API
  def concatenate3(input: Array[String]): String = input.mkString(" ")

  // Seq and List
  def loud(input: Seq[String]): Seq[String] = input.map(_.toUpperCase)

  def extractWords(input: Seq[String]): Seq[String] = {
    input.map(str => str.split(" ")).flatten
    // shorter:
    // input.flatMap(f => f.split(" "))
  }

  def extractWords3(input: Seq[String]): Seq[String] = {
    for {
      str <- input
      seq <- str.split(" ")
    } yield {
      seq
    }
  }

  // tail recursive style
  def extractWords4(input: Seq[String]): Seq[String] = {
    @tailrec
    def step(actual: List[String], elements: Seq[String]): Seq[String] = {
      if(elements.isEmpty) actual
      else step(actual ::: elements.head.split(" ").toList, elements.tail)
    }

    step(Nil, input)
  }

  def extractWords5(input: Seq[String]): Seq[String] = {
    val list = mutable.ListBuffer.newBuilder[String]
    for(str <- input) {
      list ++= str.split(" ").toList
    }

    list.result()
  }

  // Map
  def loud(input: Map[String, String]): Map[String, String] = input.map(t => (t._1.toUpperCase, t._2.toUpperCase))

  // Functional style
  def counts2(input: Seq[String]): Map[String, Int] = input.flatMap(_.split(" ")).toList.groupBy((word: String) => word).mapValues(_.length)

  // variable immutable map
  def counts3(input: Seq[String]): Map[String, Int] = {
    var result: Map[String, Int] = Map()
    for(word <- extractWords(input)) {
      result.get(word) match {
        case Some(counts) => result += word -> (counts + 1)
        case None => result += word -> 1
      }
    }
    result
  }

  // static mutable map
  def counts(input: Seq[String]): Map[String, Int] = {
    val result: mutable.Map[String, Int] = mutable.Map()
    for(word <- extractWords(input)) {
      result.get(word) match {
        case Some(counts) => result += word -> (counts + 1)
        case None => result += word -> 1
      }
    }
    result.toMap
  }

  val buffer: mutable.HashSet[(Int, Char)] = new mutable.HashSet

  def addTriedCharacter(wordId: Int, character: Char): Unit = buffer += ((wordId, character))

  def isCharacterAlreadyTried(wordId: Int, character: Char): Boolean = buffer.contains((wordId, character))
}