
val lst = List(1,2,3,4,5)

def sumProd(xs: List[Int]): (Int, Int) =
  xs match
    case h::t =>
      val (s, p) = sumProd(t)
      (h+s, h*p)
    case Nil => (0, 1)

sumProd(lst)

// O(n) P(1) - tailrec
// def foldLeft[B](z: B)(op: (B, A) => B): B
// arg1: wartość początkowa
// arg2: funkcja anonimowa

def sumProdIt(xs: List[Int]) =
  xs.foldLeft((0,1)) {
    case ((s, p), h) => (h + s, h * p)
  }

sumProdIt(lst)

def sumProdIt2(xs: List[Int]) =
  xs.foldLeft((0,1))( (acc,h) => (acc._1 + h, acc._2 * h) )

sumProdIt2(lst)


def sumProdIt3(xs: List[Int]) =
  xs.foldLeft(0,1)( (acc,curr) => (acc._1 + curr, acc._2 * curr) )