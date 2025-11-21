package yellowstarsoftware.yellowstar.math.geometry.algorithms

import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.objects.Line2D
import yellowstarsoftware.yellowstar.math.geometry.objects.Ray2D
import yellowstarsoftware.yellowstar.math.geometry.objects.Segment2D

/**
 * Returns intersection point of [firstLine] and [secondLine].
 * [firstLine] must not be parallel to [secondLine].
 */
fun linesIntersectionPoint(
    firstLine: Line2D,
    secondLine: Line2D
): Vector2D {
    val t = getLinesIntersectionParameter(
        line = firstLine,
        startPoint = secondLine.point,
        direction = secondLine.direction
    )
    return secondLine.point + secondLine.direction * t
}

/**
 * Checks if [ray] intersects [line].
 * [ray] must not be parallel to [line].
 */
fun intersectsRayLine(
    ray: Ray2D,
    line: Line2D
): Boolean {
    val t = getLinesIntersectionParameter(
        startPoint = ray.vertex,
        direction = ray.direction,
        line = line,
    )
    return t >= 0f
}

/**
 * Checks if [segment] intersects [line].
 * [segment] must not be parallel to [line].
 */
fun intersectsSegmentLine(
    segment: Segment2D,
    line: Line2D
): Boolean {
    val t = getLinesIntersectionParameter(
        startPoint = segment.first,
        direction = segment.second - segment.first,
        line = line
    )
    return t >= 0f && t <= 1f
}

/**
 * Returns t such that I = [startPoint] + t * [direction],
 * where I is the intersection point of [line] and the
 * line defined by its [startPoint] and [direction].
 * [line] must not be parallel to [direction].
 */
fun getLinesIntersectionParameter(
    line: Line2D,
    startPoint: Vector2D,
    direction: Vector2D,
): Float {
    val a = (line.point - startPoint) dot line.normal
    val b = direction dot line.normal
    return a / b
}