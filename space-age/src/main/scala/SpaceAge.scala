object SpaceAge {
  val SecondsPerEarthYear = 31557600.0
  val EarthToEarth = 1.0
  val EarthToMercury = 0.2408467
  val EarthToVenus = 0.61519726
  val EarthToMars = 1.8808158
  val EarthToJupiter = 11.862615
  val EarthToSaturn = 29.447498
  val EarthToUranus = 84.016846
  val EarthToNeptune = 164.79132

  /** Converts seconds to years on Earth */
  def onEarth(seconds: Double): Double =
    convertToYears(seconds, EarthToEarth)

  /** Converts seconds to years on Mercury */
  def onMercury(seconds: Double): Double =
    convertToYears(seconds, EarthToMercury)

  /** Converts seconds to years on Venus */
  def onVenus(seconds: Double): Double =
    convertToYears(seconds, EarthToVenus)

  /** Converts seconds to years on Mars */
  def onMars(seconds: Double): Double =
    convertToYears(seconds, EarthToMars)

  /** Converts seconds to years on Jupiter */
  def onJupiter(seconds: Double): Double =
    convertToYears(seconds, EarthToJupiter)

  /** Converts seconds to years on Saturn */
  def onSaturn(seconds: Double): Double =
    convertToYears(seconds, EarthToSaturn)

  /** Converts seconds to years on Uranus */
  def onUranus(seconds: Double): Double =
    convertToYears(seconds, EarthToUranus)

  /** Converts seconds to years on Neptune */
  def onNeptune(seconds: Double): Double =
    convertToYears(seconds, EarthToNeptune)

  /**
    * Converts seconds to years given some conversion factor
    */
  private def convertToYears(seconds: Double,
                             earthYearsPerTarget: Double): Double =
    seconds / SecondsPerEarthYear / earthYearsPerTarget
}
