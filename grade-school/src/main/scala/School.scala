class School {
  type DB = Map[Int, Seq[String]]

  private var database: DB = Map()

  def add(name: String, g: Int) = {
    val updatedNames = grade(g) ++ List(name)
    database = database + (g -> updatedNames)
  }

  def db: DB = database

  def grade(g: Int): Seq[String] = database.getOrElse(g, List())

  def sorted: DB =
    database.keys.toList.sorted
      .map(g => (g -> grade(g).sorted))
      .toMap
}
