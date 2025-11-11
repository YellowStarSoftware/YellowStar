package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.lengthSquared
import yellowstarsoftware.yellowstar.math.geometry.objects.*
import yellowstarsoftware.yellowstar.math.utils.QuadraticFunction
import yellowstarsoftware.yellowstar.utils.reference.FloatReference
import yellowstarsoftware.yellowstar.utils.reference.ObjectReference

/**
 * Checks if [sphere] intersects [line].
 * In case of intersection writes [Segment3D]
 * of intersection to [intersectionReference],
 * otherwise leaves [intersectionReference]'s value unchanged.
 */
fun intersectsSphereLine(
    sphere: Sphere,
    line: Line3D,
    intersectionReference: ObjectReference<in Segment3D>
): Boolean {
    val quadratic = sphereLineCollisionQuadratic(
        sphere,
        line.point,
        line.direction
    )
    val pFirst = FloatReference(0.0f)
    val pSecond = FloatReference(0.0f)
    val hasIntersection = quadratic.solveEquality(pFirst, pSecond)
    if (!hasIntersection) return false
    intersectionReference.value = Segment3D(
        line.point + line.direction * pFirst.value,
        line.point + line.direction * pSecond.value
    )
    return true
}

/**
 * Checks if [sphere] intersects [segment].
 */
fun intersectsSphereSegment(
    sphere: Sphere,
    segment: Segment3D
): Boolean {
    val quadratic = sphereLineCollisionQuadratic(
        sphere,
        segment.first,
        segment.second - segment.first
    )
    return quadratic.inequalityLessHasRootsOnInterval(
        t0 = 0.0f,
        t1 = 1.0f
    )
}

/**
 * Checks if [sphere] intersects [ray].
 */
fun intersectsSphereRay(
    sphere: Sphere,
    ray: Ray3D
): Boolean {
    val quadratic = sphereLineCollisionQuadratic(
        sphere,
        ray.vertex,
        ray.direction
    )
    return quadratic.inequalityLessHasRootsOnInterval(
        t0 = 0.0f,
        t1 = Float.MAX_VALUE
    )
}

private fun sphereLineCollisionQuadratic(
    sphere: Sphere,
    linePoint: Vector3D,
    lineDirection: Vector3D
): QuadraticFunction {
    val v = linePoint - sphere.center
    val lineDirectionLengthSquared = lineDirection.lengthSquared
    val p = 2 * (lineDirection dot v) / lineDirectionLengthSquared
    val q = (v.lengthSquared - sphere.radiusSquared) / lineDirectionLengthSquared
    return QuadraticFunction(
        p = p,
        q = q
    )
}