package lab.lab8

enum Status
{
  case WPrzygotowaniu, WToku, Zakonczone
}

enum Tryb
{
  case Normalny, Pilny
}

class Zadanie(val nazwa: String, val tryb: Tryb)
{
  def uruchom(pracownik: Pracownik): Unit =
  {
    if (_status ne Status.WPrzygotowaniu)
    {
      throw new IllegalStateException("Nie mozna uruchomic zadania ktore nie jest w przygotowaniu")
    }

    _pracownik = Option(pracownik)
    _status = Status.WToku
  }

  def zakoncz(): Unit =
  {
    if (_status ne Status.WToku)
    {
      throw new IllegalStateException("Nie mozna zakonczyc zadania ktore nie jest w toku")
    }

    //_pracownik = Option(null)
    _status = Status.Zakonczone
  }

  override def toString: String =
  {
    "\nZadanie{" +
      "\n\tnazwa='" + nazwa + '\'' +
      ", \n\ttryb='" + tryb + '\'' +
      ", \n\tstatus='" + _status + '\'' +
      (
        if (_pracownik.isDefined)
          ", \n\tpracownik=" + _pracownik.get.pesel
        else
          ""
      ) +
      "\n}"
  }

  def status: Status =
  {
    _status
  }

  def pracownik: Option[Pracownik] =
  {
    _pracownik
  }

  private var _status: Status = Status.WPrzygotowaniu
  private var _pracownik: Option[Pracownik] = None
}
