package taller

class TorresHanoi {

    def movsTorresHanoi(n: Int): BigInt = {
        if (n == 1) 1
        else 2 * movsTorresHanoi(n - 1) + 1
    }


    def torresHanoi(n: Int, t1: Int, t2: Int, t3: Int): List[(Int, Int)] = {
        if (n == 1) {
            List((t1, t3))
        } else {
            val movimientosIniciales = torresHanoi(n - 1, t1, t3, t2)
            val movimientoDiscoGrande = List((t1, t3))
            val movimientosFinales = torresHanoi(n - 1, t2, t1, t3)
            movimientosIniciales ::: movimientoDiscoGrande ::: movimientosFinales
        }
    }
}
