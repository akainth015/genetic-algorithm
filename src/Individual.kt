class Individual(var value: String) {
    val fitness: Int
        get() {
            return value.zip(TARGET_INDIVIDUAL).count { (a, b) -> a == b }
        }

    fun mateWith(other: Individual): Individual {
        val splitAt = Math.floorDiv(value.length, 2)
        val gene1 = value.slice(0..splitAt)
        val gene2 = other.value.slice((splitAt + 1) until other.value.length)
        val offspring = Individual(gene1 + gene2)
        offspring.mutate()
        return offspring
    }

    private fun mutate() {
        value = value.map {
            when {
                Math.random() < FUDGE_FACTOR -> ALPHABET.random()
                else -> it
            }
        }.joinToString("")
    }

    companion object {
        const val TARGET_INDIVIDUAL =
            "Aanand Kainth"

        const val FUDGE_FACTOR = 0.01

        const val ALPHABET = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        fun random(): Individual {
            val gene = StringBuilder()
            for (i in 1..TARGET_INDIVIDUAL.length) {
                gene.append(ALPHABET.random())
            }
            return Individual(gene.toString())
        }
    }
}