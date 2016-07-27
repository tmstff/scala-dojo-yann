package section2

object Section2 {

  // Arrays

  def loud(input: Array[String]): Array[String] = input.map( _.toUpperCase )

  def concatenate(input: Array[String]): String = input.mkString( " " )

  // Seq and List

  def loud(input: Seq[String]): Seq[String] = input.map( _.toUpperCase )

  def extractWords(input: Seq[String]): Seq[String] = input.flatMap( _.split(" ") )

  // Map

  def loud(input: Map[String, String]): Map[String, String] =
    input.map { case (k, v) => (k.toUpperCase(), v.toUpperCase()) }

  def counts(input: Seq[String]): Map[String, Int] =
    extractWords( input ).groupBy( identity ).map{ case (k,v) => (k, v.size) }

  import scala.collection.mutable.Set
  val triedChars = Set[Tuple2[Int, Char]]()

  def addTriedCharacter(wordId: Int, character: Char): Unit =
    triedChars.add( (wordId, character) )

  def isCharacterAlreadyTried(wordId: Int, character: Char): Boolean =
    triedChars.contains( (wordId, character) )

}
