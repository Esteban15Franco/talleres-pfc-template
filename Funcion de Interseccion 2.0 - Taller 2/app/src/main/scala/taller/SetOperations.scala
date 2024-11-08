package taller

object SetOperations {
  def intersect(setA: Map[Int, Double], setB: Map[Int, Double]): Map[Int, Double] = {
    setA.collect {
      case (element, membershipA) if setB.contains(element) =>
        (element, math.min(membershipA, setB(element)))
    }
  }
}
