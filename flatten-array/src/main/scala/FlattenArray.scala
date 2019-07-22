object FlattenArray {
  def flatten(elements: List[Any]): List[Int] =
    flattenElements(elements, List()).reverse

  private def flattenElements(elements: List[Any],
                              result: List[Int]): List[Int] =
    elements match {
      case List() => result
      case (x: List[Any]) :: rest =>
        flattenElements(rest, flattenElements(x, result))
      case (x: Int) :: rest => flattenElements(rest, x :: result)
      case _ :: rest        => flattenElements(rest, result)
    }
}
