package yellowstarsoftware.yellowstar.math.utils

import kotlin.random.Random

/**
 * Generates a random float in 0..<1.
 */
fun randomFloat(): Float {
    return Random.nextFloat()
}

/**
 * Generates a random double in 0..<1.
 */
fun randomDouble(): Double {
    return Random.nextDouble()
}

/**
 * Generates a random integer in 0..bound.
 * [bound] must be positive or zero.
 */
fun randomInt(bound: Int): Int {
    return Random.nextInt(bound + 1)
}

/**
 * Generates a random float in from..<to.
 */
fun randomFloat(from: Float, to: Float): Float {
    return map(randomFloat(), 0.0f, 1.0f, from, to)
}

/**
 * Generates a random double in from..<to.
 */
fun randomDouble(from: Double, to: Double): Double {
    return map(randomDouble(), 0.0, 1.0, from, to)
}

/**
 * Generates a random integer in from..<to.
 * [from] must be <= than [to].
 */
fun randomInt(from: Int, to: Int): Int {
    return randomInt(to - from) + from
}