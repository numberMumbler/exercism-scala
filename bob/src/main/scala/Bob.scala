object Bob {
  def response(statement: String): String = statement match {
    case s if isYelling(s) && isQuestion(s) =>
      "Calm down, I know what I'm doing!"
    case s if isYelling(s)  => "Whoa, chill out!"
    case s if isQuestion(s) => "Sure."
    case s if isBlank(s)    => "Fine. Be that way!"
    case _                  => "Whatever."
  }

  def isYelling(statement: String): Boolean =
    statement == statement.toUpperCase && statement != statement.toLowerCase

  def isQuestion(statement: String): Boolean =
    statement.trim().endsWith("?")

  def isBlank(statement: String): Boolean =
    statement.trim == ""
}
