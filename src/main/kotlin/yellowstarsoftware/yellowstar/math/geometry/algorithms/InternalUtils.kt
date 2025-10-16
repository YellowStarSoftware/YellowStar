package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.utils.min
import yellowstarsoftware.yellowstar.math.utils.sqr

internal fun distanceFunctionPart(
    linearTerm: Float,
    maxX: Float
): Float {
    // f(x) = x * x + linearTerm * x, x in [0, maxX]
    val left = 0.0f
    val right = sqr(maxX) + linearTerm * maxX
    val extremumX = -linearTerm / 2.0f
    // ignore extremum if it's out of interval [0, maxX]
    val extremum = if (extremumX in 0.0f..maxX) {
        sqr(extremumX) + linearTerm * extremumX
    } else {
        left
    }
    return min(left, right, extremum)
}