object Etl {
  def transform(scoreToLetters: Map[Int, Seq[String]]): Map[String, Int] =
    scoreToLetters.flatMap {
      case (score: Int, letters: Seq[String]) =>
        letters.map(letter => (letter.toLowerCase, score))
    }.toMap
}
