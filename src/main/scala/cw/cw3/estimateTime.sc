import scala.annotation.tailrec

def estimateTime[A, B](f: A => B) (x: A) = {
  val startTime = System.nanoTime()
  val fx = f(x)
  val estimatedTime = (System.nanoTime() - startTime) / 1000000
  (fx, estimatedTime)
}

def add(n: Int) = {
  @tailrec
  def add_hlp(n: Int) (acc: Int): Int = {
    n match {
      case 0 => acc
      case _ => add_hlp(n - 1) (n + acc)
    }
  }
  add_hlp(n) (0)
}

val n = 1000000

add(n)
n * (n+1) / 2
estimateTime(add) (n)


