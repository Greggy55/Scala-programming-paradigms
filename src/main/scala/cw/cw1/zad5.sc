def palindrome[A](xs: List[A]): Boolean = xs == xs.reverse

palindrome(List('a', 'l', 'a'))
palindrome(List(1,3,3,1))
palindrome(List(1))
palindrome(List(1,2))
palindrome(List())
palindrome(List('A', 'B', 'C'))









def rev[A](xs: List[A]): List[A] =
  if xs.isEmpty then Nil
  else rev(xs.tail) :+ xs.head

rev(List(1,2,3))
