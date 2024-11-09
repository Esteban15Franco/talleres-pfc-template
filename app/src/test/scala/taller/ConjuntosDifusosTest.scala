package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {

  val conjDifuso = new ConjuntosDifusos

  test("Test de pertenencia - Un elemento pertenece a un conjunto difuso") {
    val conjunto = conjDifuso.grande(5)
    assert(conjDifuso.pertenece(4, conjunto) === 0.8)
    assert(conjDifuso.pertenece(5, conjunto) === 1.0)
    assert(conjDifuso.pertenece(10, conjunto) === 1.0)
  }

  test("Test de pertenencia - Elemento fuera del rango") {
    val conjunto = conjDifuso.grande(5)
    assert(conjDifuso.pertenece(3, conjunto) === 0.6)
    assert(conjDifuso.pertenece(6, conjunto) === 1.0)
  }

  test("Test de grande - Elemento menor que d") {
    val conjunto = conjDifuso.grande(5)
    assert(conjDifuso.pertenece(3, conjunto) === 0.6)
    assert(conjDifuso.pertenece(2, conjunto) === 0.4)
    assert(conjDifuso.pertenece(1, conjunto) === 0.2)
  }

  test("Test de grande - Elemento mayor o igual a d") {
    val conjunto = conjDifuso.grande(5)
    assert(conjDifuso.pertenece(5, conjunto) === 1.0)
    assert(conjDifuso.pertenece(6, conjunto) === 1.0)
  }


  test("Test de igualdad - Conjuntos con rangos iguales") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(5)
    assert(conjDifuso.igualdad(conjunto1, conjunto2, 1 to 5))
  }

  test("Test de igualdad - Conjuntos diferentes") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(4)
    assert(!conjDifuso.igualdad(conjunto1, conjunto2, 1 to 10))
  }

  test("Test de unión - Unión de dos conjuntos con el mismo valor para un elemento") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(5)
    val unionConjunto = conjDifuso.union(conjunto1, conjunto2)
    assert(conjDifuso.pertenece(4, unionConjunto) === 0.8)
  }

  test("Test de unión - Unión de dos conjuntos con diferentes valores para un elemento") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(3)
    val unionConjunto = conjDifuso.union(conjunto1, conjunto2)
    assert(conjDifuso.pertenece(4, unionConjunto) === 1.0)

  }

  test("Test de intersección de conjuntos difusos") {
    val conjunto1 = conjDifuso.grande(5)
    val conjunto2 = conjDifuso.grande(3)
    val interseccionConjunto = conjDifuso.intersect(conjunto1, conjunto2, 1 to 5)
    assert(conjDifuso.pertenece(3, interseccionConjunto) === 0.6)
    assert(conjDifuso.pertenece(5, interseccionConjunto) === 1.0)
    assert(conjDifuso.pertenece(6, interseccionConjunto) === 0.0)
  }

  test("Test de complemento - Elemento con grado de pertenencia completo") {
    val conjunto = conjDifuso.grande(5)
    val complementoConjunto = conjDifuso.complemento(conjunto)
    assert(conjDifuso.pertenece(5, complementoConjunto) === 0.0)
    assert(conjDifuso.pertenece(6, complementoConjunto) === 0.0)
  }

  test("Test de complemento - Elemento con grado de pertenencia parcial") {
    val conjunto = conjDifuso.grande(5)
    val complementoConjunto = conjDifuso.complemento(conjunto)
    assert(conjDifuso.pertenece(3, complementoConjunto) === 1.0 - (3.0 / 5))
    assert(conjDifuso.pertenece(4, complementoConjunto) === 1.0 - (4.0 / 5))
  }

  test("Test de complemento - Elemento fuera del rango del conjunto original") {
    val conjunto = conjDifuso.grande(5)
    val complementoConjunto = conjDifuso.complemento(conjunto)
    assert(conjDifuso.pertenece(10, complementoConjunto) === 0.0)
  }

  test("Test de inclusión - Conjunto grande(4) incluido en grande(5)") {
    val conjunto1 = conjDifuso.grande(4)
    val conjunto2 = conjDifuso.grande(5)

    assert(!conjDifuso.inclusion(conjunto1, conjunto2, 1 to 5))  //tambien odie el test
  }

}
