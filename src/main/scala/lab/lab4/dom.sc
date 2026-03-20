import scala.annotation.tailrec

def grupuj[A] (xs: List[A]) = {
  @tailrec
  def grupujIt(xs: List[A], current: List[A], acc: List[List[A]]): List[List[A]] = {
    xs match {
      case Nil => current :: acc
      case hd :: tl =>
        if current.head == hd then grupujIt(tl, hd :: current, acc)
        else grupujIt (tl, List(hd), current :: acc)
    }
  }

  xs match {
    case Nil => Nil
    case _ => grupujIt(xs.tail, List(xs.head), Nil).reverse
  }
}

grupuj(List("1","1","1","1","2","3","3","1","1","4","4"))
grupuj(List("1","1","1","1"))
grupuj(List("a","b","c"))
grupuj(List("a"))
grupuj(List())
grupuj(List("a", "a", "b"))
grupuj(List(1, 1, 2, 2, 1, 1, 1))



