import scala.annotation.tailrec

def root3 (a: Double) =
  @tailrec
  def root3Iter(x: Double): Double =
    if math.abs(math.pow(x,3) - a) <= 1e-15 * math.abs(a) then x
    else root3Iter (x + (a / math.pow(x,2) - x) / 3)
  root3Iter(if a > 1 then a/3 else a)

root3(-27)
root3(0)
root3(1)
root3(8)
root3(27)
root3(math.pow(1024,3))
root3(0.001)
root3(1e308)

// każda iteracja mniej więcej
// podwaja liczbę poprawnych cyfr
// T(n) = O(log log 1/e) ~= O(1) amortyzowane
// P(n) = O(1) ogonowa

val root3f: Double => Double = a =>
  lazy val root3Iter: Double => Double = x =>
    if math.abs(math.pow(x, 3) - a) <= 1e-15 * math.abs(a) then x
    else root3Iter(x + (a / math.pow(x, 2) - x) / 3)
  root3Iter(if a > 1 then a / 3 else a)

root3f(-27)
root3f(0)
root3f(1)
root3f(8)
root3f(27)
root3f(math.pow(1024,3))
root3f(0.001)
root3f(1e308)


val root3f2: Double => Double = a =>
  @tailrec
  def root3Iter(x: Double): Double =
    if math.abs(math.pow(x, 3) - a) <= 1e-15 * math.abs(a) then x
    else root3Iter(x + (a / math.pow(x, 2) - x) / 3)
  root3Iter(if a > 1 then a / 3 else a)

root3f2(-27)
root3f2(0)
root3f2(1)
root3f2(8)
root3f2(27)
root3f2(math.pow(1024,3))
root3f2(0.001)
root3f2(1e308)
