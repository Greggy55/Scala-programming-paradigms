package test

// 1. Enum / Sealed Trait (Algebraiczny Typ Danych)
enum Zwierze:
  // 2. Case Classes (Dane + darmowe metody)
  case Pies(imie: String, rasa: String)
  case Kot(imie: String, var zycia: Int) // var - zmienna liczba życia

// 3. Trait (Cecha/Zachowanie)
trait Glosny {
  def dajGlos(): String = "Hałas!"
}

// 4. Obiekt Singletonowy (Aplikacja)
object Weterynarz:
  // Metoda apply - tu niepotrzebna, ale możliwa
  def apply() = new WeterynarzKlasa

  // Metoda statyczna z Pattern Matchingiem
  def zbadaj(z: Zwierze): String =
    z match
      case Zwierze.Pies(imie, "York") => s"$imie to mały piesek."
      case Zwierze.Pies(imie, _)      => s"$imie to duży pies."
      // 5. Pattern Matching z warunkiem (Guard)
      case k: Zwierze.Kot if k.zycia > 8 => s"Kot ${k.imie} jest w pełni sił."
      case k: Zwierze.Kot => s"Kot ${k.imie} musi uważać."

// Klasa używająca Traitu (Domieszki)
class WeterynarzKlasa extends Glosny

// --- Użycie ---
// @main w stylu Scali 3
@main def start(): Unit =
  // Tworzenie bez 'new' (dzięki enum/case class)
  val burek = Zwierze.Pies("Burek", "Owczarek")

  // Równość strukturalna (==)
  val burek2 = Zwierze.Pies("Burek", "Owczarek")
  println(burek == burek2) // true!

  println(Weterynarz.zbadaj(burek))
  