package lab.lab8

class Firma(var pracownicy: List[Pracownik], var zadania: List[Zadanie])
{
  def dodajPracownika(pracownik: Pracownik): Boolean =
  {
    pracownicy = pracownik :: pracownicy
    true
  }


  def dodajZadanie(zadanie: Zadanie): Boolean =
  {
    zadania = zadanie :: zadania
    true
  }

  def wyszukajPracownika(pesel: String): Option[Pracownik] =
  {
    pracownicy.find(p => p.pesel == pesel)
  }

  def podwyzWszystkimPlace(procent: Float): Unit =
  {
    pracownicy.foreach(p => p.dajPodwyzke(procent))
  }

  def podwyzPlaceSpecjaliscie(specjalista: Specjalista): Unit =
  {
    wyszukajPracownika(specjalista.pesel) match
    {
      case None =>
      case Some(p) => p.asInstanceOf[Specjalista].dajPodwyzkeZPremii()
    }
  }

  def filtrujZadania(nazwa: Option[String], status: Option[Status], pracownik: Option[Pracownik]): List[Zadanie] =
  {
    zadania
      .filter
      {
        zad =>
        nazwa.forall(_ == zad.nazwa) &&
          status.forall(_ == zad.status) &&
          pracownik.forall(p => zad.pracownik.contains(p))
      }
      .sorted(zadania_comparator)
  }

  override def toString: String = "\nFirma{" + "\n\tpracownicy=" + pracownicy + ", \n\tzadania=" + zadania + "\n}"

  private val zadania_comparator: Ordering[Zadanie] = Ordering.by[Zadanie, Int](_.tryb.ordinal).reverse
}