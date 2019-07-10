object NumberType extends Enumeration {
  val Perfect, Abundant, Deficient = Value
}

object PerfectNumbers {
  def classify(n: Int): Either[String, NumberType.Value] =
    aliquotSum(n) match {
      case _ if n < 1 =>
        Left("Classification is only possible for natural numbers.")
      case x if x == n => Right(NumberType.Perfect)
      case x if x > n  => Right(NumberType.Abundant)
      case x if x < n  => Right(NumberType.Deficient)
    }

  def aliquotSum(n: Int) =
    (1 to math.sqrt(n).toInt)
      .filter { n % _ == 0 }
      .map {
        case 1 if n == 1                        => 0
        case x if x == 1 || math.pow(x, 2) == n => x
        case x                                  => x + (n / x).toInt
      }
      .sum
}
