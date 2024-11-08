package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }

  def grande(d: Int): ConjDifuso = {
    (x: Int) => {
      if (x >= d) 1.0
      else x.toDouble / d
    }
  }

  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso, rango: Range): Boolean = {
    rango.forall(elem => pertenece(elem, cd1) == pertenece(elem, cd2))
  }
}
