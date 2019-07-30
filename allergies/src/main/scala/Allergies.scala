import Allergen.Allergen

object Allergies {
  def allergicTo(allergen: Allergen, allergyScore: Int): Boolean =
    (allergen.id & allergyScore) > 0

  def list(allergyScore: Int): List[Allergen] =
    Allergen.values
      .filter(allergicTo(_, allergyScore))
      .toList
}
