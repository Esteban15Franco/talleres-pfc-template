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
}