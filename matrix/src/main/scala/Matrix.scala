class Matrix(rows: Vector[Vector[Int]]) {
  def row(i: Int): Vector[Int] = rows(i)

  def column(i: Int): Vector[Int] =
    rows.map { (row) =>
      row(i)
    }.toVector
}

object Matrix {
  def apply(matrixValues: String): Matrix =
    new Matrix(parseRows(matrixValues: String))

  private def parseRows(matrixValues: String) =
    matrixValues
      .split("\n")
      .map { (rowValues) =>
        rowValues
          .split(" ")
          .map { _.toInt }
          .toVector
      }
      .toVector
}
