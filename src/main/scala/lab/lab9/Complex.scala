package lab.lab9

import scala.annotation.targetName
import scala.math

final case class Complex(x: Double, y: Double)
{
  def is_zero(): Boolean =
  {
    x == 0.0 & y == 0.0
  }

  def copy(): Complex =
  {
    Complex(x, y)
  }

  @targetName("addition")
  def +(other: Complex): Complex =
  {
    Complex(this.x + other.x, this.y + other.y)
  }

  @targetName("subtraction")
  def -(other: Complex): Complex =
  {
    Complex(this.x - other.x, this.y - other.y)
  }

  @targetName("multiplication")
  def *(other: Complex): Complex =
  {
    Complex(this.x * other.x, this.x * other.y)
  }

  @targetName("division")
  def /(other: Complex): Complex =
  {
    (other.x, other.y) match
    {
      case (_,0) => throw new ArithmeticException("Division by zero.")
      case (x2,y2) => Complex(x / x2, y / y2)
    }
  }

  def conjugate(): Complex =
  {
    Complex(x, -y)
  }

  private def round(num: Double)(prec: Int): Double =
  {
    val shift = math.pow(10, prec)
    (shift * num).round / shift
  }

  override def toString: String =
  {
    def rStr(x: Double) = round(x)(2)
    (rStr(x), rStr(y)) match
    {
      case (0, 0) => "0"
      case (x, 0) => x.toString
      case (0, y) => y.toString + "i"
      case (x, y) =>
        if y > 0 then x.toString + " + " + y.toString + "i"
        else x.toString + " - " + (-y).toString + "i"
    }
  }
}

@main
def test(): Unit =
{
  val a = Complex(1, 2)
  val b = Complex(2, 3)
  val c = Complex(-1, -1)
  val zero = Complex(0, 0)

  println(a)
  println(b)
  println(c)
  println(zero)

  println(a + b)
  println(a - b)
  println(a * b)
  println(a / b)

  println(a - c)
  println(a - c)
  println(a - c)
  println(a - c)

  println(a.conjugate())
  println(b.conjugate())
  println(c.conjugate())
  println(zero.conjugate())

  println(a + zero)
  println(c * zero)
  try
  {
    println(b / zero)
  }
  catch
  {
    case e: ArithmeticException => println(e.toString)
  }

  val a_cpy = a.copy()
  val c_cpy = c.copy()

  println(a == a_cpy)
  println(c == c_cpy)
  println(a == b)
  println(a == c)
}

