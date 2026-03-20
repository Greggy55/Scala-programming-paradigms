import scala.annotation.tailrec

/*
Napisz funkcję accumulate, która agreguje elementy listę wejściową,
według zadanej funkcji, oraz wartosc poczatkowej akumulator
do pojedynczej wartości.
Przygotuje wersję funkcji w rekrusji ogonowej i klasycznej
   Przykład:
   wywołanie: accumulate sum [3;6;8;9;13] 0;;
   wynik    : 39
   Punkty: 4 (język Scala) ( 2 punkty za wersje rekursją ogonową ,
   2 punkty za wersje z rekursją klasyczną)
 */

@tailrec
def accumulate[A](foo: (A,A) => A)(xs: List[A])(acc: A): A = {
  xs match {
    case Nil => acc
    case hd :: tl => accumulate(foo)(tl)(foo(acc, hd))
  }
}

def accumulate_notail[A](foo: (A,A) => A)(xs: List[A])(acc: A): A = {
  xs match {
    case Nil => acc
    case hd :: tl => foo(acc, accumulate(foo)(tl)(hd))
  }
}

val sum = (x: Int, y: Int) => x + y
val xs = List(3,6,8,9,13)
val acc = 0

accumulate(sum)(xs)(acc)
accumulate_notail(sum)(xs)(acc)
