val getAvg =
  (tpl: (Double, Double, Double)) =>
  (tpl._1 + tpl._2 + tpl._3) / 3


getAvg((3,2,4))
getAvg((0,0,0))
getAvg((-1,0,1))
getAvg((-3,-2,-4))
getAvg((1,3,10))

