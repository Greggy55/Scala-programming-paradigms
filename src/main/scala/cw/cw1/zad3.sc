def replicate[A](x: A, n: Int): List[A] =
  if n <= 0 then Nil
  else x :: replicate(x, n - 1)

replicate("la", 3)

replicate(6, 3)
replicate("", 1)
replicate(" ", 0)
replicate(List(1,2), 2)



