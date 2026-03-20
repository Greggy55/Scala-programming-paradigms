package lab.lab10.zad2

import java.lang.reflect.Field

object Debug
{
  def fields(obj: Object): Unit =
  {
    val fields: Array[Field] = obj.getClass.getDeclaredFields

    println(s"${fields.length} fields found:")

    for (field <- fields)
    {
      field.setAccessible(true)
      println(s"Pole: ${field.getName} => ${field.getType}, ${field.get(obj)}")
      field.setAccessible(false)
    }
  }
}

class Point(xv: Int, yv: Int)
{
  var x: Int = xv

  var y: Int = yv

  var a: String = "test"
}

@main
def main(): Unit =
{
  var p: Point = new Point(3, 4)
  Debug.fields(p)
}
