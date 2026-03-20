
def insertionsort[A](comp: (A, A) => Boolean)(xs: List[A]): List[A] = {
  def insert(elem: A, sortedList: List[A]): List[A] = sortedList match {
    case Nil => List(elem)
    case h :: t =>
      if (comp(elem, h)) elem :: sortedList
      else h :: insert(elem, t)
  }
  xs.foldLeft(List.empty[A])((acc, elem) => insert(elem, acc))
}

def insertionsort2[A](comp: (A, A) => Boolean)(xs: List[A]): List[A] = {
  def insert(comp: (A, A) => Boolean, elem: A, xs: List[A]): List[A] = {
    xs match {
      case Nil => List(elem)
      case h :: t =>
        if (comp(elem, h)) elem :: xs
        else h :: insert(comp, elem, t)
    }
  }

  @scala.annotation.tailrec
  def fd_left(xs: List[A], acc: List[A]): List[A] = {
    xs match {
      case Nil => acc
      case h :: t => fd_left(t, insert(comp, h, acc))
    }
  }

  fd_left(xs, Nil)
}


val lst2 = List(5, 9, 1, 8, 2, 7, 3, 6, 4, 5)
val cmp: (Int, Int) => Boolean = (a, b) => a < b

insertionsort(cmp)(lst2)
insertionsort2(cmp)(lst2)

val listaStudentow = List((3, "Ewa"), (5, "Adam"), (3, "Bartek"), (4, "Czesia"), (5, "Dawid"))

val porownajOceny: ((Int, String), (Int, String)) => Boolean = (s1, s2) => s1._1 < s2._1

val wynikInsert = insertionsort(porownajOceny)(listaStudentow)
println(wynikInsert)
// List((3,Ewa), (3,Bartek), (4,Czesia), (5,Adam), (5,Dawid))