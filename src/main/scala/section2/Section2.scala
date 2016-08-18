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


object Section2Ilja {
  // Arrays
  def loud(input: Array[String]): Array[String] = input.map(i=>i.toUpperCase)
  def concatenate(input: Array[String]): String = input.mkString(" ")
  // Seq and List
  def loud(input: Seq[String]): Seq[String] = input.map(i=>i.toUpperCase)
  def extractWords(input: Seq[String]): Seq[String] = input.flatMap(i=>i.split(" "))
  // Map
  def loud(input: Map[String, String]): Map[String, String] = input.map(i=> (i._1 toUpperCase,i._2 toUpperCase))
  def counts(input: Seq[String]): Map[String, Int] = {
    def rec(ws:Seq[String],pm:Map[String,Int]):Map[String,Int]={
      ws match {
        case Nil => pm
        case head::tail=>rec(tail,pm.updated (head, pm.getOrElse(head,0)+1))
      }
    }
    rec(extractWords(input),Map())
  }
  var m:Map[Int,Char]=Map()
  def addTriedCharacter(wordId: Int, character: Char): Unit = m=m.updated(wordId,character)
  def isCharacterAlreadyTried(wordId: Int, character: Char): Boolean = character==m.getOrElse(wordId,null)
}
