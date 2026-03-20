/* [A, B, C, D](f: (A, B, C) => D): (A => B => C => D) */

def curry3[A, B, C, D](f: ((A, B, C)) => D): A => B => C => D =
  a => b => c => f((a,b,c))

def foo (p: (Int, Int, Int)) = p._1 + p._2 + p._3

curry3(foo)
curry3(foo) (1)(10)(100)

def curry3l[A, B, C, D](f: ((A, B, C)) => D): A => B => C => D =
  (a: A) => (b: B) => (c: C) => f((a, b, c))

curry3l(foo)
curry3l(foo) (1)(10)(100)
/* curry3 bierze f i zwraca serię zagnieżdżonych funkcji anonimowych*/

/*
Argument wejściowy (f: (A, B, C) => D): f to funkcja,
która przyjmuje jeden argument (krotkę Tuple3[A, B, C])
i zwraca wynik typu D.

Zwracany typ (A => B => C => D): Nasza curry3 zwraca zupełnie nową funkcję.
Ta nowa funkcja jest rozwinięta: bierze A i zwraca funkcję B => C => D,
która bierze B i zwraca funkcję C => D, która ostatecznie bierze C
i zwraca wynik D.
*/

// uncurry -----------------------

/* [A, B, C, D](f: A => B => C => D): ( ((A,B,C)) => D) */
def uncurry3[A, B, C, D](f: A => B => C => D): ((A, B, C)) => D =
  case (a, b, c) => f(a)(b)(c)


def fuu (a: Int)(b: Int)(c: Int) = a + b + c

uncurry3(fuu)
uncurry3(fuu) (1, 10, 100)

def uncurry3l[A, B, C, D](f: A => B => C => D) =
  (p: (A, B, C)) => f(p._1)(p._2)(p._3)
  
uncurry3l(fuu)
uncurry3l(fuu) (1, 10, 100)

/*
Argument wejściowy (f: A => B => C => D): f to nasza funkcja rozwinięta.

Zwracany typ ((A, B, C) => D): uncurry3 zwraca nową funkcję.
Ta nowa funkcja jest zwinięta – oczekuje jednej krotki (A, B, C)
i od razu zwraca ostateczny wynik D.
*/

