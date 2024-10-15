package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
  }

  def grande(d: Int, e: Int): ConjDifuso = {
    (x: Int) => {
      if (x >= d) 1.0
      else x.toDouble / d
    }
  }
  def complementoDifuso(conjunto: Set[(Double, Int)]): Set[(Double, Int)] = {
    val complemento = for (elem <- conjunto) yield {
      val gradoPertenencia = BigDecimal(1 - elem._1)
        .setScale(1, BigDecimal.RoundingMode.HALF_UP)
        .toDouble
    (gradoPertenencia, elem._2)
  }
  complemento.toSet
  }

  def inclusion( cd1: Set[(Double, Int)], cd2: Set[(Double, Int)]) : Boolean = {
    val mapaCd2 = cd2.toMap
    cd1.forall { case (grado1, elemento) =>
      mapaCd2.get(elemento) match {
        case Some(grado2) => grado1 <= grado2 
        case None => false 
      }
    }
  }

    def igualdad(cd1: ConjDifuso, cd2: ConjDifuso, rango: Range): Boolean = {
    rango.forall(elem => pertenece(elem, cd1) == pertenece(elem, cd2))
    } 

    def Union (Cd1: ConjDifuso, Cd2: ConjDifuso): ConjDifuso = {
      (x: Int) =>  math.max(Cd1(x), Cd2(x))
    }
}

