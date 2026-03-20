def sqrList(xs: List[Int]): List[Int] =
  if xs == Nil then Nil
  else xs.head * xs.head :: sqrList(xs.tail)

sqrList(List(1,2,3,-4))

sqrList(List(-1,0,1))
sqrList(List())
sqrList(List(10,9,8,7,6,5,4,3,2,1,0))


val sqrListFun = (xs : List[Int]) =>
  if xs == Nil then Nil
  else xs.head * xs.head :: sqrList(xs.tail)

sqrListFun(List(1,2,3,-4))

sqrListFun(List(-1,0,1))
sqrListFun(List())

def map(xs: List[Int], f: Int => Int): List[Int] =
  if xs == Nil then Nil
  else f(xs.head) :: map(xs.tail, f)

map(List(1,2,3,-4), x => x*x)
