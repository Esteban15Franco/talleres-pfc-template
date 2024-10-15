package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestConjDifUnion extends AnyFunSuite {
    val obj = new ConjuntosDifusos()

    val cd1: obj.ConjDifuso = (x: Int) => if (x > 3) 0.6 else 0.2
    val cd2: obj.ConjDifuso = (x: Int) => if (x > 5) 0.8 else 0.4

    val union = obj.Union(cd1, cd2)

    test("ConjDisfuso Union #1") {
        assert(union(3) == 0.4)
    }

    test("ConjDisfuso Union #2") {
        assert(union(5) == 0.6)
    }

    test("ConjDisfuso Union #3") {
        assert(union(2) == 0.4)
    }

    test("ConjDisfuso Union #4") {
        assert(union(7) == 0.8)
    }

    test("ConjDisfuso Union #5") {
        assert(union(10) == 0.8)
    }

    test("ComplementoDifuso #1") {
    val conjunto = Set((0.5, 1), (0.7, 2), (0.3, 3))
    val resultado = obj.complementoDifuso(conjunto)
    assert(resultado == Set((0.5, 1), (0.3, 2), (0.7, 3)))
  }

    test("ComplementoDifuso #2") {
    val conjunto = Set((0.0, 1), (0.0, 2))
    val resultado = obj.complementoDifuso(conjunto)
    assert(resultado == Set((1.0, 1), (1.0, 2)))
  }

    test("Inclusion #1") {
    val cd1 = Set((0.5, 1), (0.3, 2))
    val cd2 = Set((0.6, 1), (0.7, 2))
    assert(inclusion(cd1, cd2) == true)
  }

    test("Inclusion #2") {
    val cd1 = Set((0.8, 1), (0.3, 2))
    val cd2 = Set((0.6, 1), (0.7, 2))
    assert(inclusion(cd1, cd2) == false)
  }

    test("Inclusion #3") {
    val cd1 = Set.empty[(Double, Int)]
    val cd2 = Set.empty[(Double, Int)]
    assert(inclusion(cd1, cd2) == true)
  }


}