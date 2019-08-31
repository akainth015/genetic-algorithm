fun main() {
    val history = arrayListOf<Generation>()
    history += Generation.random(1000)
    while (history.last().fittest!!.value != Individual.TARGET_INDIVIDUAL) {
        val nextGeneration = history.last().makeNextGeneration()
        history += nextGeneration
        println(nextGeneration.fittest!!.value)
    }
    println("Generations: ${history.size}")
    println("Final output: ${history.last().fittest!!.value}")
    println("Average fittest fitness: ${history.map { it.fittest!!.fitness }.average()}")
}