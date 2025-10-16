package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.lengthSq
import yellowstarsoftware.yellowstar.math.geometry.objects.*
import yellowstarsoftware.yellowstar.math.utils.QuadraticFunction
import yellowstarsoftware.yellowstar.utils.reference.FloatReference

/**
 * Checks if [circle] intersects [line] and
 * returns their intersection [Segment2D].
 */
fun intersectsCircleLine(
    circle: Circle2D,
    line: Line2D
): Segment2D? {
    val quadratic = circleLineCollisionQuadratic(
        circle,
        line.point,
        line.direction
    )
    val pFirst = FloatReference(0.0f)
    val pSecond = FloatReference(0.0f)
    val hasIntersection = quadratic.solveEquality(pFirst, pSecond)
    if (!hasIntersection) return null
    return Segment2D(
        line.point + line.direction * pFirst.value,
        line.point + line.direction * pSecond.value
    )
}

/**
 * Checks if [circle] intersects [segment].
 */
fun intersectsCircleSegment(
    circle: Circle2D,
    segment: Segment2D
): Boolean {
    val quadratic = circleLineCollisionQuadratic(
        circle,
        segment.first,
        segment.second - segment.first
    )
    return quadratic.inequalityLessHasRootsOnInterval(
        t0 = 0.0f,
        t1 = 1.0f
    )
}

/**
 * Checks if [circle] intersects [ray].
 */
fun intersectsCircleRay(
    circle: Circle2D,
    ray: Ray2D
): Boolean {
    val quadratic = circleLineCollisionQuadratic(
        circle,
        ray.vertex,
        ray.direction
    )
    return quadratic.inequalityLessHasRootsOnInterval(
        t0 = 0.0f,
        t1 = Float.MAX_VALUE
    )
}

private fun circleLineCollisionQuadratic(
    circle: Circle2D,
    linePoint: Vector2D,
    lineDirection: Vector2D
): QuadraticFunction {
    val v = linePoint - circle.center
    val lineDirectionLengthSquared = lineDirection.lengthSq
    val p = 2 * (lineDirection dot v) / lineDirectionLengthSquared
    val q = (v.lengthSq - circle.radiusSquared) / lineDirectionLengthSquared
    return QuadraticFunction(
        p = p,
        q = q
    )
}