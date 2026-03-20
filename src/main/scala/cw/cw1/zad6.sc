def listLength[A](xs: List[A]): Int =
  if xs == Nil then 0
  else listLength(xs.tail) + 1

listLength(List())
listLength(List(1))
listLength(List(1,2))
listLength(List('1','2','3'))
listLength(List(1,1,1,1,1))
