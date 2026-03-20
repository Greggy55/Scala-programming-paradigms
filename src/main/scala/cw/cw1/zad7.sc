val log2 = (x: Double) => Math.log(x)/Math.log(2)

def T(N: Int, c: Double = 1): Double =
  if N == 1 then 1
  else c * log2(N) + T(N/2, c)

T(1)
T(2)
T(4)
T(8)
T(16)
T(32)
T(64)
T(128)
T(256)
T(512)
T(1024)
// T(N) = 0((log N)^2)
