import scala.annotation.tailrec

@tailrec
def initSegment[A](l1: List[A], l2: List[A]): Boolean =
  (l1, l2) match
    case (Nil, _) => true
//    case (_, Nil) => false
    case (h1::t1, h2::t2) if h1 == h2 => initSegment(t1, t2)
    case _ => false

initSegment(List(1,2,3), List(1,2,3,4,5))
initSegment(List(1,2,3), List(1,2,4,5))
initSegment(List(1,2,3), List(1,2,3))
initSegment(List(1,2,3), List(1,2))

//T(n) = O(dlg l1)
//P(n) = O(1) ogonowa
// case (_, Nil) => false   - niepotrzebne
