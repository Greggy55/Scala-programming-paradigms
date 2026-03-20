def getLengths(lst: List[String]): List[Int] =
  if lst == Nil then Nil
  else lst.head.length :: getLengths(lst.tail)

getLengths(List("To", "jest", "napis"))
getLengths(List("", " ","  "))
getLengths(List("\n", "\b", "\t"))
getLengths(List("123", "1234567", "1", "987654321"))
