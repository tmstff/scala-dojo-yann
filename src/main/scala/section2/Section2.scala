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

  // Functional style
  def extractWords(input: Seq[String]): Seq[String] = {
    input.map(str => str.split(" ")).flatten
    // shorter:
    // input.flatMap(f => f.split(" "))
  }

  // for comprehension
  def extractWords2(input: Seq[String]): Seq[String] = {
    for {
      str <- input
      seq <- str.split(" ")
    } yield {
      seq
    }
  }

  // tail recursive style
  def extractWords3(input: Seq[String]): Seq[String] = {
    @tailrec
    def step(actual: List[String], elements: Seq[String]): Seq[String] = {
      if(elements.isEmpty) actual
      else step(actual ::: elements.head.split(" ").toList, elements.tail)
    }

    step(Nil, input)
  }

  def extractWords4(input: Seq[String]): Seq[String] = {
    val list = mutable.ListBuffer.newBuilder[String]
    for(str <- input) {
      list ++= str.split(" ").toList
    }

    list.result()
  }

  // Map using tuple accessor
  def loud(input: Map[String, String]): Map[String, String] = input.map(t => (t._1.toUpperCase, t._2.toUpperCase))

  // Map using iteration over keys
  def loud2(input: Map[String, String]): Map[String, String] = {
    var temp = Map[String,String]()
    input.keys.foreach{x =>
      temp += (x.toUpperCase -> input.getOrElse(x,"").toUpperCase)
    }

    temp
  }

  // Functional style
  def counts(input: Seq[String]): Map[String, Int] = input.flatMap(_.split(" ")).toList.groupBy((word: String) => word).mapValues(_.length)

  // variable immutable map with pattern match
  def counts2(input: Seq[String]): Map[String, Int] = {
    var result: Map[String, Int] = Map()
    for(word <- extractWords(input)) {
      result.get(word) match {
        case Some(counts) => result += word -> (counts + 1)
        case None => result += word -> 1
      }
    }
    result
  }

  // variable immutable Map semi functional style
  def counts3(input: Seq[String]): Map[String, Int] = {
    var tmp: Map[String,Int] = Map()
    val res: Seq[String] = input.flatMap(x => x.split(" "))
    res.foreach {x => tmp += x -> res.count(y => x == y)}
    tmp
  }

  // static mutable map
  def counts4(input: Seq[String]): Map[String, Int] = {
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