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

  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    (x: Int) => Math.max(cd1(x), cd2(x))
  }

  def intersect(cd1: ConjDifuso, cd2: ConjDifuso, rango: Range): ConjDifuso = {
    (x: Int) => {
      if (rango.contains(x)) math.min(cd1(x), cd2(x))
      else 0.0
    }
  }
  def complemento(c: ConjDifuso): ConjDifuso = {
    (x: Int) => 1.0 - c(x)
  }

  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso, rango: Range): Boolean = {
    rango.forall(i => cd1(i) <= cd2(i)) //Odie hacer este codigo
  }

}
