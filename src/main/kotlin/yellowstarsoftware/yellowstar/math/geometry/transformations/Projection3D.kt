package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Plane

/**
 * Projects [point] onto [plane] parallel to [direction].
 * [direction] must not be parallel to [Plane.normal]
 */
fun projectPointOntoPlane(
    point: Vector3D,
    direction: Vector3D,
    plane: Plane
) : Vector3D {
    val a = (plane.point - point) dot plane.normal
    val b = plane.point dot direction
    return point + direction * (a / b)
}