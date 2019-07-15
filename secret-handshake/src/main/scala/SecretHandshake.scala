object SecretHandshake {
  private val commandLookup = List(
    (0, (decodedEvents: List[String]) => "wink" :: decodedEvents),
    (1, (decodedEvents: List[String]) => "double blink" :: decodedEvents),
    (2, (decodedEvents: List[String]) => "close your eyes" :: decodedEvents),
    (3, (decodedEvents: List[String]) => "jump" :: decodedEvents),
    (4, (decodedEvents: List[String]) => decodedEvents.reverse)
  ).toMap

  def commands(code: Int): List[String] = {
    (0 to commandLookup.keys.max)
      .foldLeft(List[String]()) { (decodedEvents, commandBit) =>
        applyCommand(code, decodedEvents, commandBit)
      }
      .reverse
  }

  private def applyCommand(code: Int,
                           decodedEvents: List[String],
                           commandBit: Int): List[String] =
    commandLookup.get(commandBit) match {
      case Some(f) if hasCommand(code, commandBit) => f(decodedEvents)
      case _                                       => decodedEvents
    }

  private def hasCommand(code: Int, commandBit: Int) =
    (code & math.pow(2, commandBit).toInt) > 0
}
