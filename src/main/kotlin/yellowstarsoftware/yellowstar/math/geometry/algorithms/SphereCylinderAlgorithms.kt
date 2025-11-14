package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.lengthSquared
import yellowstarsoftware.yellowstar.math.geometry.objects.Cylinder
import yellowstarsoftware.yellowstar.math.geometry.objects.Sphere
import yellowstarsoftware.yellowstar.math.geometry.objects.radiusSquared
import yellowstarsoftware.yellowstar.math.utils.sqr
import kotlin.math.max
import kotlin.math.min

/**
 * Checks if [sphere] intersects [cylinder].
 */
fun intersectsSphereCylinder(
    sphere: Sphere,
    cylinder: Cylinder
) : Boolean {
    val v = sphere.center - cylinder.position
    val d = v dot cylinder.direction
    val t0 = max(0f, d - sphere.radius)
    val t1 = min(cylinder.height, d + sphere.radius)
    if (t1 < t0) return false
    val fSq = when {
        d > t1 -> sphere.radiusSquared - sqr(t1 - d)
        d < t0 -> sphere.radiusSquared - sqr(t0 - d)
        else -> sphere.radiusSquared
    }
    val lSq = v.lengthSquared - sqr(d)
    val rSq = cylinder.radiusSquared
    val a = lSq - rSq - fSq
    return a < 0f || sqr(a) <= 4f * rSq * fSq
}