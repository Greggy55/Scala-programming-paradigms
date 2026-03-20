def curry3[A,B,C,D](f: (A,B,C)=>D) =
  (x:A) => (y:B) => (z:C) => f(x,y,z)

def foo (a: Int, b: Int, c: Int) = a+b+c
curry3(foo)
curry3(foo) (1)(10)(100)

//curry3: [A, B, C, D](f: (A, B, C) => D) = A => (B => (C => D))

def uncurry3[A,B,C,D](f: A=>B=>C=>D) =
  (x:A, y:B, z:C) => f(x)(y)(z)

def fuu (a: Int)(b: Int)(c: Int) = a + b + c
uncurry3(fuu)
uncurry3(fuu) (1, 10, 100)

//uncurry3: [A, B, C, D](f: A => (B => (C => D)))(A, B, C) => D
