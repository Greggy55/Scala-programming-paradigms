import scala.annotation.tailrec

def mergesort[A](comp: (A, A) => Boolean)(xs: List[A]): List[A] = {
  def merge(xs: List[A], ys: List[A]): List[A] = {
    (xs, ys) match {
      case (Nil, lst) => lst
      case (lst, Nil) => lst
      case (xh :: xt, yh :: yt) =>
        if comp(xh, yh) then xh :: merge(xt, ys)
        else yh :: merge(xs, yt)
    }
  }

//  def split(list: List[A]): (List[A], List[A]) = {
//    @scala.annotation.tailrec
//    def div(left: List[A], right: List[A], rem: List[A]): (List[A], List[A]) = {
//      rem match {
//        case Nil => (left, right)
//        case h :: Nil => (h :: left, right)
//        case h1 :: h2 :: t => div(h1 :: left, h2 :: right, t)
//      }
//    }
//    div(Nil, Nil, list)
//  }

  def split(xs: List[A]) = {
    def take(n: Int, list: List[A]): List[A] = {
      if n <= 0 then Nil
      else list match
        case Nil => Nil
        case h :: t => h :: take(n - 1, t)
    }

    //ewentualnie
//    def take(n: Int, list: List[A]) = {
//      @tailrec
//      def go(n: Int, list: List[A], acc: List[A]): List[A] = {
//        if n <= 0 then acc
//        else list match
//          case Nil => acc
//          case h :: t => go(n - 1, t, h :: acc)
//      }
//      go(n, list, Nil).reverse
//    }

    @tailrec
    def drop(n: Int, list: List[A]): List[A] = {
      if n <= 0 then list
      else list match
        case Nil => Nil
        case _ :: t => drop(n - 1, t)
    }

    val n = xs.length / 2
    (take (n, xs), drop (n, xs))
  }

  xs match {
    case Nil => Nil
    case h :: Nil => xs
    case _ =>
      val (left, right) = split(xs)
      val sortedLeft = mergesort(comp)(left)
      val sortedRight = mergesort(comp)(right)
      merge(sortedLeft, sortedRight)
  }
}

val listaStudentow = List((3, "Ewa"), (5, "Adam"), (3, "Bartek"), (4, "Czesia"), (5, "Dawid"))

val porownajOcenyStab: ((Int, String), (Int, String)) => Boolean = (s1, s2) => s1._1 <= s2._1

val wynikMerge = mergesort(porownajOcenyStab)(listaStudentow)
wynikMerge
// List((3,Ewa), (3,Bartek), (4,Czesia), (5,Adam), (5,Dawid))