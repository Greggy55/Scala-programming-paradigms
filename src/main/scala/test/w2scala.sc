import scala.annotation.tailrec
// literały funkcyjne (funkcje anonimowe)

((x: Int) => x + x) (6)

val double = (x: Int) => x + x
double(6)

def double2(x: Int) = x + x
double2(6)


// funkcjonały

val f = (y: Int) => (x: Int) => x*x+y
f(2)(5) // y=2 x=5 // (f(2))(5)
val f2 = f(2)
f2(5)
val f5 = (z: Int) => f(z)(5) // funkcja wyspecjalizowana
f5(2)


// polimorfizm parametryczny
def id[A](x: A) = x
id(5)
id(3+4, "siedem")
id[String => String] (id) ("OK")
//id _


// postać zwinięta (uncurried) i rozwinięta (curried)
// w j. funkcyjnych wszystkie funkcje są jednoargumentowe

// postać zwinięta
def plus(x: Int, y: Int) = x + y
plus(4,5)
// postać rozwinięta
def add (x: Int)(y: Int) = x + y
add(4)(5)
def addF(x: Int) = (y: Int) => x + y
addF(4)(5)


// funkcje wzajemnie rekurencyjne
@tailrec // do optymalizacji
def evenR(n: Int): Boolean =
  if n == 0 then true else evenR(n - 1)
  // n % 2 == 0

@tailrec // do optymalizacji
def oddR(n: Int): Boolean =
  if n == 0 then false else oddR(n - 1)
  // n % 2 != 0

evenR(128)
oddR(128)


// rekursja ogonowa

def succ(n: Int): Int =
  if n == 0 then 1 else 1 + succ(n-1)
succ(1000000)

def succTail(n: Int) = {
  @tailrec // do optymalizacji
  def succIter(n: Int, accum: Int): Int =
    if n == 0 then accum else succIter(n-1, accum+1)
  succIter(n, 1)
}
succTail(1000000)


// dopasowanie do wzorca w definicjach zmiennych
val x = (false, 10)
val (z,y) = x

//val (false, y) = x

val xs = List("Ala", "ma", "kota")
val List(x1, x2, x3) = xs
val h::t = xs

// wzorzec z wieloznacznikiem
val (z2, _) = (false, 10)

// wzorce nie muszą być "płaskie"
val osoba = (("Kowal", 25), true)
val ((n,w),b) = osoba

// parametry funkcji są wzorcami
// niestety w Scali muszą być zmiennymi
//def f[A,B,C]((x: A, y: B), z: C) = (x,y(x,y),z)
// możemy jednak wykorzystać dopasowanie
// do wzorca w treści funkcji
// (w definicjach zmiennych)
def foo[A,B,C](k:((A,B),C)) = {
  val ((x,y),z) = k
  (x,y,(x,y),z)
}
foo((2, 5.5), List(1,2))


// wyrażenie match

def imply1(pb:(Boolean, Boolean)) =
  pb match {
    case (false, false) => true
    case (false, true) => true
    case (true, false) => false
    case (true, true) => true
  }

def imply2(pb:(Boolean, Boolean)) =
  pb match {
    case (true, false) => false
    case _ => true
  }

imply1(false, false)
imply1(false, true)
imply1(true, false)
imply1(true, true)

imply2(false, false)
imply2(false, true)
imply2(true, false)
imply2(true, true)


def zip[A,B](xs: List[A], ys: List[B]): List[(A,B)] =
  (xs, ys) match
    case (h1::t1, h2::t2) => (h1, h2)::zip(t1, t2)
    case _ => Nil

zip(List(1,2,3), List('a','b','c'))


def unzip[A,B](ps: List[(A,B)]): (List[A], List[B]) =
  ps match
    case Nil => (Nil, Nil)
    case (h1, h2) :: t =>
      val (xs1, xs2) = unzip(t)
      (h1 :: xs1, h2 :: xs2)

unzip(List((1,2),(3,4),(5,6),(7,8)))


def isLatinVowel (v: Char) =
  v match
    case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => true
    case _ => false

isLatinVowel('s')
isLatinVowel('y')


// wzorce dozorowane

def srednia(p:(Double, Double)) =
  p match
    case (x,y) if x == y => x // pattern guard
    case (x,y) => (x+y) / 2.0

srednia(5.0,5.0)
srednia(4.0,5.0)


// wzorce warstwowe (@s-p@tterns)

val (d1 @ (n1,w1),b1) = ((1, "a"),true)

def fa[A,B,C](k:((A,B),C)) =
  val (p @ (x,y),z) = k
  (x,y,p,z)

fa((1,"a"),true)

def fb[A,B,C](k:((A,B),C)) =
  k match
    case (p @ (x,y),z) => (x,y,p,z)

fb((1,"a"),true)



