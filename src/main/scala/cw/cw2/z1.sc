
def even(n: Int) =
  def evenR(n:Int): Boolean =
    if n == 0 then true else oddR(n-1)
  def oddR(n:Int): Boolean =
    if n == 0 then false else evenR(n-1)
  evenR(n)

even(3)
