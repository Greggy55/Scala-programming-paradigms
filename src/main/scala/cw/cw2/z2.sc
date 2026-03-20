import scala.annotation.tailrec

def fib(n: Int): Int =
  n match
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)

fib(0)
fib(1)
fib(2)
fib(3)
fib(4)
fib(5)
fib(6)
fib(7)
fib(8)
fib(9)
fib(10)
fib(42)

// T(n) = T(n-1) + T(n-2) + O(1)
// T(n) = O(phi ^ n)

// bo T(n) ~= T(n-1) + T(n-2)
// czyli F(n) = F(n-1) + F(n-2)
// F(n) = (phi^n - psi^n)/sqrt(5)
// F(n) ~= phi^n / sqrt(5)
// czyli T(n) = O(phi^n)

// P(n) = O(n)

def fibTail(n: Int) =
  @tailrec
  def fibIter(n: Int, n1: Int, n2: Int): Int =
    n match
      case 0 => n1
      case 1 => n2
      case _ => fibIter(n-1, n2, n1+n2)
  fibIter(n, 0, 1)


// T(n) = T(n-1) + O(1)
// T(n) = n * O(1)
// T(n) = O(n)

// P(n) = O(1)

fibTail(0)
fibTail(1)
fibTail(2)
fibTail(3)
fibTail(4)
fibTail(5)
fibTail(6)
fibTail(7)
fibTail(8)
fibTail(9)
fibTail(10)
fibTail(42)
