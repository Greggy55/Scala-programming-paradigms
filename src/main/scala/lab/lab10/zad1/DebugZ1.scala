package lab.lab10.zad1

import java.lang.reflect.Field

trait Debug
{
  def debugVars(): Unit =
  {
    val fields: Array[Field] = getClass.getDeclaredFields

    println(s"${fields.length} fields found:")

    for (field <- fields)
    {
      field.setAccessible(true)
      println(s"Pole: ${field.getName} => ${field.getType}, ${field.get(this)}")
      field.setAccessible(false)
    }
  }
}

class Point(xv: Int, yv: Int) extends Debug
{
  var x: Int = xv

  var y: Int = yv

  var a: String = "test"
}

@main
def main(): Unit =
{
  var p: Point = new Point(3, 4)

  p.debugVars()
}

