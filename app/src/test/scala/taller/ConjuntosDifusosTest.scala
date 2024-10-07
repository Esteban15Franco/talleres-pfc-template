package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {

  val obj = new ConjuntosDifusos()

  val conjuntoGrande = obj.grande(10, 0)
  test("Test 1 - Pertenencia de 5 al conjunto grande (d=10)") {
    assert(obj.pertenece(5, conjuntoGrande) == 0.5)
  }

  test("Test 2 - Pertenencia de 10 al conjunto grande (d=10)") {
    assert(obj.pertenece(10, conjuntoGrande) == 1.0)
  }

  test("Test 3 - Pertenencia de 15 al conjunto grande (d=10)") {
    assert(obj.pertenece(15, conjuntoGrande) == 1.0)
  }

  test("Test 4 - Pertenencia de 0 al conjunto grande (d=10)") {
    assert(obj.pertenece(0, conjuntoGrande) == 0.0)
  }

  test("Test 5 - Pertenencia de un número negativo (-5) al conjunto grande (d=10)") {
    assert(obj.pertenece(-5, conjuntoGrande) == -0.5)
  }


  test("Test 6 - Igualdad entre dos conjuntos difusos iguales") {
    val cd1 = obj.grande(10, 0)
    val cd2 = obj.grande(10, 0)
    assert(obj.igualdad(cd1, cd2, 0 to 15))
  }

  test("Test 7 - Igualdad entre dos conjuntos difusos diferentes") {
    val cd1 = obj.grande(10, 0)
    val cd2 = obj.grande(15, 0)
    assert(!obj.igualdad(cd1, cd2, 0 to 15))
  }

  test("Test 8 - Igualdad en un rango limitado donde los conjuntos son iguales") {
    val cd1 = obj.grande(10, 0)
    val cd2 = obj.grande(15, 0)
    assert(!obj.igualdad(cd1, cd2, 10 to 15))
  }

  test("Test 9 - Igualdad entre conjuntos difusos con un rango de 0 a 9") {
    val cd1 = obj.grande(10, 0)
    val cd2 = obj.grande(15, 0)
    assert(!obj.igualdad(cd1, cd2, 0 to 9))
  }
}
