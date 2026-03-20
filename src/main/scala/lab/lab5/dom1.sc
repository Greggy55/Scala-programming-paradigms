import scala.annotation.tailrec

def odwroc[A](xs: List[A]) =
{
  @tailrec
  def odwroc_iter(xs: List[A], acc: List[A]): List[A] =
  {
    xs match
    {
      case Nil => acc
      case hd::tl => odwroc_iter(tl, hd :: acc)
    }
  }

  odwroc_iter(xs, Nil)
}

odwroc(List(5,4,3,2))
odwroc(List(1,2,3,4))
odwroc(List(4,3,2,1))
odwroc(List())
odwroc(List(1,1,2,1))

