package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {

  val conjDifuso = new ConjuntosDifusos

  test("Test de pertenencia - Un elemento pertenece a un conjunto difuso") {
    val conjunto = conjDifuso.grande(5)
    assert(conjDifuso.pertenece(4, conjunto) === 0.8)  // 4 / 5 = 0.8
    assert(conjDifuso.pertenece(5, conjunto) === 1.0)  // Igual a d, devuelve 1.0
    assert(conjDifuso.pertenece(10, conjunto) === 1.0) // Igual a d, devuelve 1.0
  }

  test("Test de pertenencia - Elemento fuera del rango") {
    val conjunto = conjDifuso.grande(5)
    assert(conjDifuso.pertenece(3, conjunto) === 0.6)  // 3 / 5 = 0.6
    assert(conjDifuso.pertenece(6, conjunto) === 1.0)  // Igual a d, devuelve 1.0
  }

  test("Test de igualdad - Conjuntos con rangos iguales") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(5)
    assert(conjDifuso.igualdad(conjunto1, conjunto2, 1 to 5)) // Conjuntos iguales con el mismo rango
  }

  test("Test de igualdad - Conjuntos diferentes") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(4)
    assert(!conjDifuso.igualdad(conjunto1, conjunto2, 1 to 10)) // Diferentes conjuntos
  }

}
