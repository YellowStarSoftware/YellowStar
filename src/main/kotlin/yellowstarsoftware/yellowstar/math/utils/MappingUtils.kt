package yellowstarsoftware.yellowstar.math.utils

import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

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
 * Maps value [t] in interval [a1]..[a2] onto interval [b1]..[b2].
 * Ensures that result is in interval [b1]..[b2].
 */
fun mapAndCoerce(
    t: Float,
    a1: Float,
    a2: Float,
    b1: Float,
    b2: Float
) = map(
    t = t,
    a1 = a1,
    a2 = a2,
    b1 = b1,
    b2 = b2
).smartCoerceIn(
    first = b1,
    second = b2
)

/**
 * Maps value [t] in interval [a1]..[a2] onto interval [b1]..[b2].
 * Ensures that result is in interval [b1]..[b2].
 */
fun mapAndCoerce(
    t: Double,
    a1: Double,
    a2: Double,
    b1: Double,
    b2: Double
) = map(
    t = t,
    a1 = a1,
    a2 = a2,
    b1 = b1,
    b2 = b2
).smartCoerceIn(
    first = b1,
    second = b2
)

/**
 * Maps value [t] in interval [a1]..[a2] onto interval [b1]..[b2].
 * Ensures that result is in interval [b1]..[b2].
 */
fun mapAndCoerce(
    t: Float,
    a1: Float,
    a2: Float,
    b1: Int,
    b2: Int
) = map(
    t = t,
    a1 = a1,
    a2 = a2,
    b1 = b1.toFloat(),
    b2 = b2.toFloat()
).roundToInt().smartCoerceIn(
    first = b1,
    second = b2
)

/**
 * Maps value [t] in interval [a1]..[a2] onto interval [b1]..[b2].
 * Ensures that result is in interval [b1]..[b2].
 */
fun mapAndCoerce(
    t: Double,
    a1: Double,
    a2: Double,
    b1: Int,
    b2: Int
) = map(
    t = t,
    a1 = a1,
    a2 = a2,
    b1 = b1.toDouble(),
    b2 = b2.toDouble()
).roundToInt().smartCoerceIn(
    first = b1,
    second = b2
)

private fun Float.smartCoerceIn(
    first: Float,
    second: Float
) = coerceIn(
    minimumValue = min(first, second),
    maximumValue = max(first, second)
)

private fun Double.smartCoerceIn(
    first: Double,
    second: Double
) = coerceIn(
    minimumValue = min(first, second),
    maximumValue = max(first, second)
)

private fun Int.smartCoerceIn(
    first: Int,
    second: Int
) = coerceIn(
    minimumValue = min(first, second),
    maximumValue = max(first, second)
)