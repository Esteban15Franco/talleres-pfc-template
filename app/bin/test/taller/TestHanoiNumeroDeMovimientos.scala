package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestHanoiNumeroDeMovimientos extends AnyFunSuite {
    val objTorresHanoi: TorresHanoi = new  TorresHanoi()

    test("MovsTorresHanoi 1 disk") {
        assert(objTorresHanoi.movsTorresHanoi(1) == 1)
    }

    test("MovsTorresHanoi 3 disks") {
        assert(objTorresHanoi.movsTorresHanoi(3) == 7)
    }

    test("MovsTorresHanoi 4 disks") {
        assert(objTorresHanoi.movsTorresHanoi(4) == 15)
    }

    test("MovsTorresHanoi 5 disks") {
        assert(objTorresHanoi.movsTorresHanoi(5) == 31)
    }

    test("MovsTorresHanoi 6 disks") {
        assert(objTorresHanoi.movsTorresHanoi(6) == 63)
    }

    test("MovsTorresHanoi 7 disks") {
        assert(objTorresHanoi.movsTorresHanoi(7) == 127)
    }
}