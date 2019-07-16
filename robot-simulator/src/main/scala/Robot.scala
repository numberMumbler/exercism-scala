object Bearing extends Enumeration {
  val North, East, South, West = Value
}

case class Robot(bearing: Bearing.Value, coordinates: Tuple2[Int, Int]) {
  private val StepRight = 1
  private val StepLeft = -1
  private val RightCode = "R"
  private val LeftCode = "L"
  private val AdvanceCode = "A"

  private val advanceValues = Map(
    Bearing.North -> (0, 1),
    Bearing.East -> (1, 0),
    Bearing.South -> (0, -1),
    Bearing.West -> (-1, 0)
  )

  def turnRight: Robot = copy(bearing = updateBearing(StepRight))

  def turnLeft: Robot = copy(bearing = updateBearing(StepLeft))

  def advance: Robot = advanceValues.get(this.bearing) match {
    case Some(update) => copy(coordinates = add(this.coordinates, update))
    case _            => this
  }

  def simulate(instructions: String): Robot =
    instructions
      .split("")
      .foldLeft(this) {
        case (robot, RightCode)   => robot.turnRight
        case (robot, LeftCode)    => robot.turnLeft
        case (robot, AdvanceCode) => robot.advance
        case (robot, _)           => robot
      }

  private def updateBearing(amount: Int): Bearing.Value = {
    /*
     * Assumes Bearing values have consecutive IDs and adjacent directions have adjacent IDs
     */
    val updatedBearingId = (this.bearing.id + amount + Bearing.values.size) % Bearing.values.size
    Bearing(updatedBearingId)
  }

  private def add(a: Tuple2[Int, Int], b: Tuple2[Int, Int]): Tuple2[Int, Int] =
    (a._1 + b._1, a._2 + b._2)
}
