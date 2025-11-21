package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Plane

/**
 * Perspective projection.
 * Projects [point] onto [plane] parallel to direction,
 * where direction = [point] - [projectionCenter].
 * direction must not be parallel to [plane].
 */
fun pointPerspectiveProjection(
    point: Vector3D,
    plane: Plane,
    projectionCenter: Vector3D
) : Vector3D {
   return pointParallelProjection(
       point = point,
       plane = plane,
       direction = point - projectionCenter
   )
}

/**
 * Orthographic projection.
 * Projects [point] onto [plane] parallel to [Plane.normal].
 */
fun pointOrthographicProjection(
    point: Vector3D,
    plane: Plane
): Vector3D {
    return pointParallelProjection(
        point = point,
        plane = plane,
        direction = plane.normal
    )
}

/**
 * Parallel projection.
 * Projects [point] onto [plane] parallel to [direction].
 * [direction] must not be parallel to [plane].
 */
fun pointParallelProjection(
    point: Vector3D,
    plane: Plane,
    direction: Vector3D
): Vector3D {
    val a = (plane.point - point) dot plane.normal
    val b = plane.normal dot direction
    return point + direction * (a / b)
}