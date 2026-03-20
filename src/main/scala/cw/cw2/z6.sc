
def replaceNth[A](xs: List[A], n: Int, x: A): List[A] =
  (xs, n) match
    case (Nil, _) => Nil
    case (hd::tl, 0) => x :: tl
    case (hd::tl, _) => hd :: replaceNth(tl, n-1, x)

replaceNth(List('o','l','a', 'm', 'a', 'k', 'o', 't', 'a'), 1, 's') ;;
replaceNth(List('o','l','a', 'm', 'a', 'k', 'o', 't', 'a'), 100, 's') ;;
// zwraca kopie

// T(n) = O(n) , n - index
// P(n) = O(n) , n - index
