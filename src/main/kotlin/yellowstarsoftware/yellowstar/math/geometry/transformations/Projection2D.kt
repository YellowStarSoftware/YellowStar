package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.objects.Line2D

/**
 * Perspective projection.
 * Projects [point] onto [line] parallel to direction,
 * where direction = [point] - [projectionCenter].
 * direction must not be parallel to [line].
 */
fun pointPerspectiveProjection(
    point: Vector2D,
    line: Line2D,
    projectionCenter: Vector2D
) : Vector2D {
   return pointParallelProjection(
       point = point,
       line = line,
       direction = point - projectionCenter
   )
}

/**
 * Orthographic projection.
 * Projects [point] onto [line] parallel to [Line2D.normal].
 */
fun pointOrthographicProjection(
    point: Vector2D,
    line: Line2D
): Vector2D {
    return pointParallelProjection(
        point = point,
        line = line,
        direction = line.normal
    )
}

/**
 * Parallel projection.
 * Projects [point] onto [line] parallel to [direction].
 * [direction] must not be parallel to [line].
 */
fun pointParallelProjection(
    point: Vector2D,
    line: Line2D,
    direction: Vector2D
): Vector2D {
    val a = (line.point - point) dot line.normal
    val b = line.normal dot direction
    return point + direction * (a / b)
}