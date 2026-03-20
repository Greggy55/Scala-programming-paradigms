package lab.lab8

class Pracownik(val imie: String, val nazwisko: String, val pesel: String, private var _placa: Float)
{
  def dajPodwyzke(procent: Float): Unit =
  {
    if (procent < 0 || procent > 1)
    {
      throw new IllegalArgumentException("Procent podwyzki musi byc miedzy w przedziale [0,1]")
    }

    _placa *= (1.0f + procent)
  }

  def placa: Float =
  {
    _placa
  }

  def placa_=(new_placa: Float): Unit =
  {
    require(0 <= new_placa, s"new_placa=$new_placa")
    _placa = new_placa
  }

  override def toString: String =
  {
    "\nPracownik{" +
      "\n\timie='" + imie + '\'' +
      ", \n\tnazwisko='" + nazwisko + '\'' +
      ", \n\tpesel='" + pesel + '\'' +
      ", \n\tplaca=" + placa + "\n}"
  }
}
