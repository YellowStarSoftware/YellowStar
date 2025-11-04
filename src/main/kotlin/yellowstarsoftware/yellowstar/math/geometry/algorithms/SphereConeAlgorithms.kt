package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.lengthSquared
import yellowstarsoftware.yellowstar.math.geometry.objects.*
import yellowstarsoftware.yellowstar.math.utils.QuadraticFunction
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Checks if [sphere] intersects [cone].
 */
fun intersectsSphereCone(
    sphere: Sphere,
    cone: Cone
): Boolean {
    val v = sphere.center - cone.vertex
    val d = v dot cone.direction
    val t0 = max(cone.startHeight, d - sphere.radius)
    val t1 = min(cone.endHeight, d + sphere.radius)
    if (t0 > t1) return false
    // |d| is never larger than |v| so
    // it's safe to get square root of v*v-d*d
    val l = sqrt(v.lengthSquared - d * d)
    val k = cone.radiusCoefficient
    // k is positive, so it's safe to divide by it
    val lDivK = l / k
    if (t1 > lDivK) return true
    val a = k * k + 1
    // a is always positive, so it's safe to divide by it
    val p = (-2f * (l * k + d)) / a
    val q = (l * l - sphere.radiusSquared + d * d) / a
    val quadratic = QuadraticFunction(p = p, q = q)
    return quadratic.inequalityLessHasRootsOnInterval(
        t0 = t0,
        t1 = t1
    )
}