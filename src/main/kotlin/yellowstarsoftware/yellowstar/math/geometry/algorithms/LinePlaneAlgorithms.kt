package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Line3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Plane
import yellowstarsoftware.yellowstar.math.geometry.objects.Ray3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Segment3D

/**
 * Returns intersection point of [line] and [plane].
 * [line] must not be parallel to [plane].
 */
fun linePlaneIntersectionPoint(
    line: Line3D,
    plane: Plane
): Vector3D {
    val t = getLinePlaneIntersectionParameter(
        startPoint = line.point,
        direction = line.direction,
        plane = plane
    )
    return line.point + line.direction * t
}

/**
 * Checks if [ray] intersects [plane].
 * [ray] must not be parallel to [plane].
 */
fun intersectsRayPlane(
    ray: Ray3D,
    plane: Plane
): Boolean {
    val t = getLinePlaneIntersectionParameter(
        startPoint = ray.vertex,
        direction = ray.direction,
        plane = plane
    )
    return t >= 0f
}

/**
 * Checks if [segment] intersects [plane].
 * [segment] must not be parallel to [plane].
 */
fun intersectsSegmentPlane(
    segment: Segment3D,
    plane: Plane
): Boolean {
    val t = getLinePlaneIntersectionParameter(
        startPoint = segment.first,
        direction = segment.second - segment.first,
        plane = plane
    )
    return t >= 0f && t <= 1f
}

/**
 * Returns t such that I = [startPoint] + t * [direction],
 * where I is the intersection point of [plane] and the
 * line defined by its [startPoint] and [direction].
 * [direction] must not be parallel to [plane].
 */
fun getLinePlaneIntersectionParameter(
    startPoint: Vector3D,
    direction: Vector3D,
    plane: Plane
): Float {
    val a = (plane.point - startPoint) dot plane.normal
    val b = direction dot plane.normal
    return a / b
}