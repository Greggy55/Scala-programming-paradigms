package lab.lab10.dom

import lab.lab10.zad1.Debug

trait Debug
{
  def debugName(): Unit =
  {
    println("Klasa: " + getClass.getName)
  }
}

class Point(xv: Int, yv: Int) extends Debug {

  var x: Int = xv

  var y: Int = yv

  var a: String = "test"

}

@main
def main(): Unit =
{
  var p: Point = new Point(3, 4)

  p.debugName()
}

