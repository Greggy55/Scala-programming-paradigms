// kalkulator

2+2
1-2*3
2.5+3.5
1 > 3
!(1>2)
(1>2) != false

//res0 + 1
//res5 + 2


// identyfikatory zmiennych

val x3 = 3+2
val napis = "Ala " + "ma " + "kota"

val x1 = 7.5
x1 + 6.0
x1 + 6


// interpolacja napisów w Scali

val age = 12
val name = "Anne"
name + " completed " + age + "."
s"$name completed $age."
s"Next year, $name will complete ${age+1}."


// Statyczne wyznaczanie zakresu identyfikatora

x1
{ val x = x1 + x1
  val y = 2
  x + x +
  { val x = 10.0
    x+y
  }
} + 1.0


// Pary i krotki

val k3 = (3+4, 2.0, 2<4)
/* W języku Scala krotki są instancjami jednej
* z klas TupleN, gdzie 2<= N <= 22, które
* mają zdefiniowane wszystkie selektory
*/
k3._1
k3._3
// krotki mozna porownywac
k3 == (8-1, 2.0, 2==2)

val k2 = (3+4, (2.0, 2<4))

k2._1
k2._2
k2._2._1


// listy

x1
val xs = 1.0 :: x1 :: 2.5 :: Nil
// listy mozna porownywac
xs == List(1.0, 7.5, 2.0+0.5)
xs.head
xs.tail
xs.length

xs ::: List(9.0, 10.0) // xs + [9.0, 10.0]
List(1,2,3).reverse
val xss = List(List(4.0, 5.0), xs,
  1.0 :: 2.0 :: 3.0 :: Nil)
xss.length

// funkcje

val double = (x:Int) => 2*x
double(6)
/* funkcja anonimowa
* = literał funkcyjny */
((x:Int) => 2*x)
((x:Int) => 2*x) (6)

val s = 2.toString // w Scali wszystko jest obiektem

def twice (x:Int) = 2*x
twice(6)
twice(2+3)
/* aplikacja funkcji do argumentu
   wiąże najmocniej
 */
twice (2)+3

// twice jest metodą, a double funkcją
val twiceF = twice _  // konwercja metoda -> funckja

def silnia (n:Int): Int =
  if n == 0 then 1
  else if n > 0 then n * silnia(n - 1)
  else throw new Exception(s"ujemny argument: $n")


silnia(4)
silnia(-4)
math.sqrt(16)
math.sqrt(2)

// w językach funkcyjnych wszystkie funkcje są jednoargumentowe
// kilka wartości można przekazać do funkcji w postaci krotki
// w Scali jest inaczej z powodu kompatybilności z Javą

// jeden argument
//(p: (Int, Int)) => p._1 + p._2
// dwa argumenty
//(x: Int, y: Int) => x + y

// mimo to wywołać można identycznie
((p: (Int, Int)) => p._1 + p._2) (4,5)
((x: Int, y: Int) => x + y) (4,5)

// ale uwaga!
((p: (Int, Int)) => p._1 + p._2) ((4,5))
// ((x: Int, y: Int) => x + y) ((4,5)) // error


// statyczne wiązanie zmiennych globalnych funkcji

val p = 10
def f(x: Int) = (x, p, x+p)
f(p)
//val p = 1000
//f(p)


// polimorfizm parametryczny

def id[A](x: A) = x
id(5)
id(3+4, "siedem")

def last[A](xs: List[A]): A =
  if xs == Nil then
    throw new Exception("pusta lista")
  else xs.reverse.head

last(List(1,3,4,2))
last(Nil)





