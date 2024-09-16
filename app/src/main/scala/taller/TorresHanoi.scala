package taller

class TorresHanoi {

    // Calcula el número de movimientos necesarios para resolver las Torres de Hanoi
    def movsTorresHanoi(n: Int): BigInt = {
        if (n == 1) 1
        else 2 * movsTorresHanoi(n - 1) + 1
    }

    // Devuelve una lista de movimientos necesarios para resolver las Torres de Hanoi
    def torresHanoi(n: Int, t1: Int, t2: Int, t3: Int): List[(Int, Int)] = {
        // Caso base
        if (n == 1) {
            List((t1, t3))
        } else {
            val listamovInicial: List[(Int, Int)] = torresHanoi(n - 1, t1, t3, t2)
            val listamovIntermedio: List[(Int, Int)] = listamovInicial ::: List((t1, t3))
            val listamovFinal: List[(Int, Int)] = listamovIntermedio ::: torresHanoi(n - 1, t2, t1, t3)
            listamovFinal
        }
    }
}