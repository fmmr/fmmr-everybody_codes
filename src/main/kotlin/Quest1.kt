package no.rodland

object Quest1 {

    val points = mapOf(
        'A' to 0,
        'C' to 3,
        'B' to 1,
        'D' to 5,
    )

    fun part3(str: String): Int {
        val sum = str.chunked(3).map { it.replace("x", "") }.sumOf { s ->
            if (s.isEmpty()) {
                0
            } else if (s.length == 1) {
                points[s.first()]!!
            } else if (s.length == 2) {
                points[s.first()]!! + points[s.last()]!! + s.length
            } else {
                s.sumOf { points[it]!! } + (s.length * 2)
            }
        }
        return sum
    }

    fun part2(str: String): Int {
        val sum = str.chunked(2).map { it.replace("x", "") }.sumOf { s ->
            if (s.isEmpty()) {
                0
            } else if (s.length == 1) {
                points[s.first()]!!
            } else {
                points[s.first()]!! + points[s.last()]!! + s.length
            }
        }
        return sum
    }

    fun part1(str: String): Int {
        return str.map { points[it] ?: 0 }.sum()
    }
}