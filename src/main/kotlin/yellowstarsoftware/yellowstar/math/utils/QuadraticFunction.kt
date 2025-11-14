package yellowstarsoftware.yellowstar.math.utils

import yellowstarsoftware.yellowstar.utils.reference.FloatReference
import kotlin.math.sqrt

/**
 * Quadratic function f(x) = x*x + p*x + q = 0.
 * @property p coefficient of x
 * @property q free term
 */
class QuadraticFunction(
    val p: Float,
    val q: Float
) {

    /**
     * Solves equation f(x) = 0.
     * @param firstRootReference [FloatReference] to the first root
     * @param secondRootReference [FloatReference] to the second root
     * @return true, if the equation has solutions
     */
    fun solveEquality(
        firstRootReference: FloatReference,
        secondRootReference: FloatReference
    ): Boolean {
        val b = -p / 2.0f
        // d is discriminant divided by 4
        val d = b * b - q
        if (d < 0.0f) return false
        val squareRootOfD = sqrt(d)
        firstRootReference.value = b - squareRootOfD
        secondRootReference.value = b + squareRootOfD
        return true
    }

    /**
     * Determines if there are solutions of inequality
     * f(x) <= 0 for x in [t1, t2].
     * @param t0 left boundary of the interval
     * @param t1 right boundary of the interval, t1 >= t0
     * @return exists t in [t0, t1] : f(x) <= t
     */
    fun inequalityLessHasRootsOnInterval(
        t0: Float,
        t1: Float
    ): Boolean {
        val b = -p / 2.0f
        // d is discriminant divided by 4
        val d = b * b - q
        if (d < 0.0f) return false
        val diff1 = b - t1
        val condition1 = diff1 < 0.0f || d >= diff1 * diff1
        val diff2 = t0 - b
        val condition2 = diff2 < 0.0f || d >= diff2 * diff2
        return condition1 && condition2
    }
}