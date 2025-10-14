package yellowstarsoftware.yellowstar.math.utils

import kotlin.math.max
import kotlin.math.min

/**
 * Returns the smallest of [a], [b] and [c].
 */
fun min(a: Float, b: Float, c: Float): Float {
    return min(a, min(b, c))
}

/**
 * Returns the smallest of [a], [b] and [c].
 */
fun min(a: Double, b: Double, c: Double): Double {
    return min(a, min(b, c))
}

/**
 * Returns the smallest of [a], [b] and [c].
 */
fun min(a: Int, b: Int, c: Int): Int {
    return min(a, min(b, c))
}

/**
 * Returns the greatest of [a], [b] and [c].
 */
fun max(a: Float, b: Float, c: Float): Float {
    return max(a, max(b, c))
}

/**
 * Returns the greatest of [a], [b] and [c].
 */
fun max(a: Double, b: Double, c: Double): Double {
    return max(a, max(b, c))
}

/**
 * Returns the greatest of [a], [b] and [c].
 */
fun max(a: Int, b: Int, c: Int): Int {
    return max(a, max(b, c))
}

/**
 * Returns the index of the smallest of [values].
 */
fun indexOfMin(vararg values: Float): Int {
    var minIndex = 0
    for (i in 1 until values.size)
        if (values[i] < values[minIndex])
            minIndex = i
    return minIndex
}

/**
 * Returns the index of the smallest of [values].
 */
fun indexOfMin(vararg values: Double): Int {
    var minIndex = 0
    for (i in 1 until values.size)
        if (values[i] < values[minIndex])
            minIndex = i
    return minIndex
}

/**
 * Returns the index of the smallest of [values].
 */
fun indexOfMin(vararg values: Int): Int {
    var minIndex = 0
    for (i in 1 until values.size)
        if (values[i] < values[minIndex])
            minIndex = i
    return minIndex
}

/**
 * Returns the index of the greatest of [values].
 */
fun indexOfMax(vararg values: Float): Int {
    var maxIndex = 0
    for (i in 1 until values.size)
        if (values[i] > values[maxIndex])
            maxIndex = i
    return maxIndex
}

/**
 * Returns the index of the greatest of [values].
 */
fun indexOfMax(vararg values: Double): Int {
    var maxIndex = 0
    for (i in 1 until values.size)
        if (values[i] > values[maxIndex])
            maxIndex = i
    return maxIndex
}

/**
 * Returns the index of the greatest of [values].
 */
fun indexOfMax(vararg values: Int): Int {
    var maxIndex = 0
    for (i in 1 until values.size)
        if (values[i] > values[maxIndex])
            maxIndex = i
    return maxIndex
}