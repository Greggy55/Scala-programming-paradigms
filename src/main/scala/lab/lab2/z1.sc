import scala.annotation.tailrec

def revrs[A](xs: List[A]) =
  @tailrec
  def rev_iter[B](xs: List[B], res: List[B]): List[B] =
    xs match
      case Nil => res
      case hd::tl => rev_iter(tl, hd :: res)
  rev_iter(xs, Nil)

def obetnijkrance[A](xs: List[A]) =
  revrs(revrs(xs.tail).tail) ;;

obetnijkrance(List(1,2,3,4,5))
obetnijkrance(List(5,4,3,2))


