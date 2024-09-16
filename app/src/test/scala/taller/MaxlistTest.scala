package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MaxlistTest extends AnyFunSuite {
  val obj = new Maxlist()

  test("MaxIt test 1 - Lista con varios elementos") {
    assert(obj.maxIt(List(1, 4, 21, 16, 33, 2, 6, 13, 9)) == 33)
  }

  test("MaxIt test 2 - lista vacia")
  {
    intercept[IllegalArgumentException]
      {
        obj.maxIt(List())
      }
  }

  test("MaxIt test 3 - Lista con varios elementos 2")
  {
    assert(obj.maxIt(List(28, 11, 9, 5, 20, 15, 21, 12, 0, 1)) == 28)
  }

  test("MaxIt test 4 - Lista con un solo elemento") {
    assert(obj.maxIt(List(42)) == 42)
  }

  test("MaxIt test 5 - Lista con elementos negativos") {
    assert(obj.maxIt(List(-10, -20, -30, -40, -50)) == -10)
  }

  test("MaxIt test 6 - Lista con elementos negativos y positivos") {
    assert(obj.maxIt(List(-10, 5, 20, -15, 30, -5)) == 30)
  }

  test("MaxIt test 7 - Lista con elementos duplicados") {
    assert(obj.maxIt(List(7, 7, 7, 7, 7, 7)) == 7)
  }

  test("MaxLin test 1 - Lista con varios elementos") {
    assert(obj.maxLin(List(1, 4, 21, 16, 33, 2, 6, 13, 9)) == 33)
  }

  test("MaxLin test 2 - Lista con varios elementos 2")
  {
    assert(obj.maxLin(List(28, 11, 9, 5, 20, 15, 21, 12, 0, 1)) == 28)
  }

  test("MaxLin test 3 - Lista con un solo elemento") {
    assert(obj.maxLin(List(42)) == 42)
  }

  test("MaxLin test 4 - Lista con elementos negativos") {
    assert(obj.maxLin(List(-10, -20, -30, -40, -50)) == -10)
  }

  test("MaxLin test 5 - Lista con elementos negativos y positivos") {
    assert(obj.maxLin(List(-10, 5, 20, -15, 30, -5)) == 30)
  }

  test("MaxLin test 6 - Lista con elementos duplicados") {
    assert(obj.maxLin(List(7, 7, 7, 7, 7, 7)) == 7)
  }

}
