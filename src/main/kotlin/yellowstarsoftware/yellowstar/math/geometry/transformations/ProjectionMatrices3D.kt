package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Matrix4D
import yellowstarsoftware.yellowstar.math.geometry.objects.Plane

/**
 * Creates a perspective projection matrix
 * with zero as the projection center
 * and [plane] as the projection plane.
 */
fun createPerspectiveProjectionMatrix(
    plane: Plane
): Matrix4D {
    val k = plane.point dot plane.normal
    val (nx, ny, nz) = plane.normal
    return Matrix4D.of(
        k, 0f, 0f, 0f,
        0f, k, 0f, 0f,
        0f, 0f, k, 0f,
        nx, ny, nz, 0f
    )
}