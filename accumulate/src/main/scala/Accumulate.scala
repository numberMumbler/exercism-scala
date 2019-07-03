class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] =
    accumulateHelper(f, list, List())
    
  @annotation.tailrec
  private def accumulateHelper[A, B](f: (A) => B, list: List[A], result: List[B]): List[B] =
    list match {
      case List() => result.reverse
      case _      => accumulateHelper(f, list.tail, f(list.head) :: result)
    }
}
