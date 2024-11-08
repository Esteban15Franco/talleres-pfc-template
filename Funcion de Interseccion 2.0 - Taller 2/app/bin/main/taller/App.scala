package taller

object App {
  def main(args: Array[String]): Unit = {
    // Ejemplo 1: Conjuntos con intersección común
    val setA1 = Map(1 -> 0.2, 2 -> 0.5, 3 -> 0.6)
    val setB1 = Map(3 -> 0.6, 4 -> 0.7, 1 -> 0.8)
    val result1 = SetOperations.intersect(setA1, setB1)
    println(s"Interseccion 1: $result1")

    // Ejemplo 2: Un conjunto vacío y otro no vacío
    val setA2 = Map.empty[Int, Double]
    val setB2 = Map(1 -> 0.3, 2 -> 0.4)
    val result2 = SetOperations.intersect(setA2, setB2)
    println(s"Interseccion 2 (conjunto A vacio): $result2")

    // Ejemplo 3: Conjuntos sin elementos comunes
    val setA3 = Map(1 -> 0.5, 2 -> 0.7)
    val setB3 = Map(3 -> 0.6, 4 -> 0.8)
    val result3 = SetOperations.intersect(setA3, setB3)
    println(s"Interseccion 3 (sin elementos comunes): $result3")

    // Ejemplo 4: Conjuntos con grados de pertenencia cero
    val setA4 = Map(1 -> 0.0, 2 -> 0.8, 3 -> 0.0)
    val setB4 = Map(2 -> 0.5, 3 -> 0.0, 4 -> 0.9)
    val result4 = SetOperations.intersect(setA4, setB4)
    println(s"Interseccion 4 (grados de pertenencia cero): $result4")

    // Ejemplo 5: Intersección de un conjunto consigo mismo
    val setA5 = Map(1 -> 0.5, 2 -> 0.7, 3 -> 0.9)
    val result5 = SetOperations.intersect(setA5, setA5)
    println(s"Interseccion 5 (conjunto consigo mismo): $result5")
    
    // Ejemplo 6: Conjuntos con intersección común
    val setA6 = Map(1 -> 0.5, 2 -> 0.1, 3 -> 0.6)
    val setB6 = Map(3 -> 0.3, 2 -> 0.7, 1 -> 0.9)
    val result6 = SetOperations.intersect(setA6, setB6)
    println(s"Interseccion 6: $result6")
  }
}