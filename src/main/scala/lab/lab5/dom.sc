import scala.annotation.tailrec

def calkuj(foo: Double => Double, rng: (Double, Double), accur: Int) = {
  def sigma(f: Int => Double, n: Int) = {
    @tailrec
    def sum(i: Int, res: Double): Double = {
      if i == n then res
      else sum(i + 1, res + f(i + 1))
    }

    sum(0, f(0))
  }

  val h = (rng._2 - rng._1) / accur
  sigma((x: Int) => h / 2 * (foo(rng._1 + (x+1) * h) + foo(rng._1 + x * h)), accur - 1)
}

calkuj((x: Double) => 2*x+1, (-1.0, 3.0), 100)
calkuj((x: Double) => 2*Math.sin(x)+1, (-1.0, 3.0), 100)
calkuj((x: Double) => Math.sin(x), (-1.0, 3.0), 100)

calkuj((x: Double) => Math.sin(x), (0.0, 1.0), 1)
calkuj((x: Double) => Math.sin(x), (0.0, 1.0), 10)
calkuj((x: Double) => Math.sin(x), (0.0, 1.0), 100)

calkuj((x: Double) => x, (0.0, 1.0), 100)
calkuj((x: Double) => 2*x+1, (0.0, 1.0), 100)
calkuj((x: Double) => 5+x/2, (-10.0, 10.0), 100)
calkuj((x: Double) => 1.0, (0.0, 1.5), 100)
