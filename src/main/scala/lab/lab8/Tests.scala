package lab.lab8

@main
def main(): Unit =
{
  var pracownicy = List[Pracownik]()

  val pracownikAdam = new Pracownik("Adam", "Adamski", "0102392435", 2000)
  val pracownikArtur = new Specjalista("Artur", "Arturski", "203924365", 5000, 555)
  val pracownikBartek = new Pracownik("Bartek", "Bartocki", "23457678789", 1000)
  val pracownikBob = new Specjalista("Bob", "Bobicki", "213557789", 4000, 666)

  pracownicy ::= pracownikAdam
  pracownicy ::= pracownikArtur
  pracownicy ::= pracownikBartek
  // pracownicy ::= pracownikBob

  var zadania = List[Zadanie]()

  val zadProgNorm = new Zadanie("Programowanie", Tryb.Normalny)
  zadProgNorm.uruchom(pracownikAdam)

  val zadDebPilny = new Zadanie("Debugowanie", Tryb.Pilny)
  zadDebPilny.uruchom(pracownikArtur)

  val zadPromNorm = new Zadanie("Promowanie", Tryb.Normalny)

  val zadProgPilny = new Zadanie("Programowanie", Tryb.Pilny)
  zadProgPilny.uruchom(pracownikBartek)
  zadProgPilny.zakoncz()

  val zadDebNorm = new Zadanie("Debugowanie", Tryb.Normalny)
  zadDebNorm.uruchom(pracownikAdam)

  zadania ::= zadProgNorm
  zadania ::= zadDebPilny
  zadania ::= zadPromNorm
  zadania ::= zadProgPilny
  // zadania ::= zadDebNorm

  val firma = new Firma(pracownicy, zadania)
  println("\n>>> przed dodaniem")
  println(firma)

  firma.dodajPracownika(pracownikBob)
  firma.dodajZadanie(zadDebNorm)
  println("\n>>> po dodaniu")
  println(firma)

  println("\n============== filtruj ================")

  println("\n>>> filtruj Programowanie _ _")
  println(firma.filtrujZadania(Some("Programowanie"), None, None))

  println("\n>>> filtruj _ WToku _")
  println(firma.filtrujZadania(None, Some(Status.WToku), None))

  println("\n>>> filtruj _ _ Adam")
  println(firma.filtrujZadania(None, None, Some(pracownikAdam)))

  println("\n>>> filtruj Programowanie Zakonczone _")
  println(firma.filtrujZadania(Some("Programowanie"), Some(Status.Zakonczone), None))

  println("\n>>> filtruj Programowanie WToku Adam")
  println(firma.filtrujZadania(Some("Programowanie"), Some(Status.WToku), Some(pracownikAdam)))

  println("\n>>> filtruj _ _ _")
  println(firma.filtrujZadania(None, None, None))

  println("\n____________ wyszukajPracownika _____________")

  var wynik: Option[Pracownik] = firma.wyszukajPracownika(pracownikBob.pesel)
  wynik.foreach(p => println("Znaleziono: " + p.imie))

  wynik = firma.wyszukajPracownika("123")
  try
  {
    val p = wynik.getOrElse(throw new IllegalStateException("Brak pracownika"))
  }
  catch
  {
    case e: IllegalStateException =>
      println(e.getMessage)
  }

  println("\n-------------- podwyzki ---------------")
  println("\n>>> przed podwyzkami...")
  println(firma)
  println("\n>>> podwyz Wszystkim Place...")
  firma.podwyzWszystkimPlace(0.1f)
  println(firma)
  println("\n>>> podwyz Place Specjaliscie...")
  firma.podwyzPlaceSpecjaliscie(pracownikBob)

  println(firma.wyszukajPracownika(pracownikBob.pesel).getOrElse("Błąd"))
}

