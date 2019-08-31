class Generation(private val size: Int, private val population: Array<Individual>) {
    private val matingPool = ArrayList<Individual>()

    val fittest = population.maxBy { it.fitness }

    init {
        population.forEach {
            for (i in 0..it.fitness) {
                matingPool.add(it)
            }
        }
    }

    fun makeNextGeneration(): Generation {
        return Generation(size, Array(size) {
            matingPool.random().mateWith(matingPool.random())
        })
    }

    companion object {
        fun random(size: Int) = Generation(size, Array(size) { Individual.random() })
    }
}