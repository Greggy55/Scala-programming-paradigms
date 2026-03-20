def flatten1[A] (xss: List[List[A]]): List[A] =
  if xss == Nil then Nil
  else xss.head ::: flatten1(xss.tail)

flatten1(List(List(5,6), List(1,2,3)))

flatten1(List(List(5,6), List(1,2,3), List(7), List(8)))
flatten1(List(List(0), List(1,2,3), List(4), List(5)))
flatten1(List(List(1,2,3)))
flatten1(List(List("a"), List("b")))
flatten1(List(List()))
flatten1(List(List(), List(), List()))
