package taller

import org.scalatest.funsuite.AnyFunSuite

class AppSuite extends AnyFunSuite {

  test("Intersección con conjuntos vacíos") {
    val setA = Map.empty[Int, Double]
    val setB = Map.empty[Int, Double]
    val expected = Map.empty[Int, Double]
    assert(SetOperations.intersect(setA, setB) == expected)
  }

  test("Intersección donde un conjunto es vacío") {
    val setA = Map(1 -> 0.5, 2 -> 0.6)
    val setB = Map.empty[Int, Double]
    val expected = Map.empty[Int, Double]
    assert(SetOperations.intersect(setA, setB) == expected)
  }

  test("Intersección sin elementos comunes") {
    val setA = Map(1 -> 0.5, 2 -> 0.6)
    val setB = Map(3 -> 0.7, 4 -> 0.8)
    val expected = Map.empty[Int, Double]
    assert(SetOperations.intersect(setA, setB) == expected)
  }

  test("Intersección con grados de pertenencia cero") {
    val setA = Map(1 -> 0.0, 2 -> 0.8, 3 -> 0.0)
    val setB = Map(2 -> 0.5, 3 -> 0.0, 4 -> 0.9)
    val expected = Map(2 -> 0.5)
    assert(SetOperations.intersect(setA, setB) == expected)
  }

  test("Intersección de un conjunto consigo mismo") {
    val setA = Map(1 -> 0.5, 2 -> 0.6, 3 -> 0.7)
    val expected = setA
    assert(SetOperations.intersect(setA, setA) == expected)
  }
}
