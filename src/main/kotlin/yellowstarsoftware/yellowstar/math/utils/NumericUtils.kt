package yellowstarsoftware.yellowstar.math.utils

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Returns [a] * [a].
 */
fun sqr(a: Float): Float {
    return a * a
}

/**
 * Returns [a] * [a].
 */
fun sqr(a: Double): Double {
    return a * a
}

/**
 * Returns [a] * [a].
 */
fun sqr(a: Int): Int {
    return a * a
}

/**
 * Checks if interval [x1]..[x2] intersects interval [x3]..[x4].
 */
fun intersectIntervals(
    x1: Float,
    x2: Float,
    x3: Float,
    x4: Float
): Boolean {
    val w1 = abs(x2 - x1) * 0.5f
    val w2 = abs(x4 - x3) * 0.5f
    val c1 = x1 + w1
    val c2 = x3 + w2
    return abs(c1 - c2) <= w1 + w2
}

/**
 * Checks if interval [x1]..[x2] intersects interval [x3]..[x4].
 */
fun intersectIntervals(
    x1: Double,
    x2: Double,
    x3: Double,
    x4: Double
): Boolean {
    val w1 = abs(x2 - x1) * 0.5
    val w2 = abs(x4 - x3) * 0.5
    val c1 = x1 + w1
    val c2 = x3 + w2
    return abs(c1 - c2) <= w1 + w2
}

/**
 * Clamps [t] to interval [min]..[max].
 */
fun clamp(
    t: Float,
    min: Float,
    max: Float
): Float {
    return min(max, max(t, min))
}

/**
 * Clamps [t] to interval [min]..[max].
 */
fun clamp(
    t: Double,
    min: Double,
    max: Double
): Double {
    return min(max, max(t, min))
}

/**
 * Clamps [t] to interval [min]..[max].
 */
fun clamp(
    t: Int,
    min: Int,
    max: Int
): Int {
    return min(max, max(t, min))
}

/**
 * Maps value [t] in interval [a1]..[a2] onto interval [b1]..[b2].
 */
fun map(
    t: Float,
    a1: Float,
    a2: Float,
    b1: Float,
    b2: Float
): Float {
    val k = (b2 - b1) / (a2 - a1)
    return (t - a1) * k + b1
}

/**
 * Maps value [t] in interval [a1]..[a2] onto interval [b1]..[b2].
 */
fun map(
    t: Double,
    a1: Double,
    a2: Double,
    b1: Double,
    b2: Double
): Double {
    val k = (b2 - b1) / (a2 - a1)
    return (t - a1) * k + b1
}

/**
 * Linear interpolation between [a] and [b] with parameter [t].
 */
fun lerp(
    a: Float,
    b: Float,
    t: Float
): Float {
    return a + (b - a) * t
}

/**
 * Linear interpolation between [a] and [b] with parameter [t].
 */
fun lerp(
    a: Double,
    b: Double,
    t: Double
): Double {
    return a + (b - a) * t
}