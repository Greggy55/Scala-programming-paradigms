package lab.lab8

class Specjalista(imie: String, nazwisko: String, pesel: String, placa: Float, private var _premia: Float)
  extends Pracownik(imie, nazwisko, pesel, placa)
{
  def dajPodwyzkeZPremii(): Unit =
  {
    super.placa += _premia
  }

  def premia: Float =
  {
    _premia
  }

  def premia_=(new_premia: Float): Unit =
  {
    require(0 <= new_premia, s"new_placa=$new_premia")
    _premia = new_premia
  }

  override def toString: String =
  {
    "\nSpecjalista{" +
      "\n\tpremia=" + _premia +
      super.toString +
      "\n}"
  }
}
