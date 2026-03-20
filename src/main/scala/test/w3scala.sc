// Rozwijanie i zwijanie funkcji - Scala

val plus = (x:Int,y:Int) => x+y
//val plus: (Int, Int) => Int = <function2>
// curried jest metodą, zdefiniowaną w cesze Function2
(plus curried 4) (5)

val add = (x:Int) => (y:Int) => x+y
//  add: Int => Int => Int = <function1>
// uncurried jest przeciążoną metodą, zdefiniowaną w obiekcie Function
Function.uncurried (add) (4,5)

// Operatory postfiksowe w języku Scala

//import scala.language.postfixOps
//plus curried
//plus.curried

List(1,2,3,4).map(x => x*x)
List(1,2,3,4).foldLeft(0)((sum, x) => sum + x)



