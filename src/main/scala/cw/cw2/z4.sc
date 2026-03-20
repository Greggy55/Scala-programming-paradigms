
val a = List(-2,-1,0,1,2)
val _ :: _ :: x_a1 :: _ = a
val List(_,_,x_a2,_,_) = a

val b = List((1,2),(0,1))
val _ :: List((x_b1,_)) = b
val List((_,_),(x_b2,_)) = b
