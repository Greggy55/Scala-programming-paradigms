def count[A](x: A, xs: List[A]): Int =
  if xs == Nil then 0
  else if x == xs.head then count(x, xs.tail) + 1
  else count(x, xs.tail)

count('a', List('a', 'l', 'a'))

count(1, List(2, 1, 3, 7))
count(10, List(1,2,3,4,5,6,7,8,9))
count(1, List(1,2,1,2,1,2,1,2))
count('a', List())
count(0, List(0,0,0,0,0,0))

def count2[A](x: A, xs: List[A]): Int =
  if xs.head == x
  then 1 + count2(x, xs.tail)
  else 0 + count2(x, xs.tail)
