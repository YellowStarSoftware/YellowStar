package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Matrix4D
import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.objects.Plane

/**
 * Creates a perspective projection [Matrix4D]
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

/**
 * Creates an orthographic projection [Matrix4D].
 * The matrix defines projection of a point
 * onto [plane] parallel to [Plane.normal].
 */
fun createOrthographicProjectionMatrix(
    plane: Plane
): Matrix4D {
    return createParallelProjectionMatrix(
        plane = plane,
        direction = plane.normal
    )
}

/**
 * Creates a parallel projection [Matrix4D].
 * The matrix defines projection of a point
 * onto [plane] parallel to [direction].
 * [direction] must not be parallel to [plane].
 */
fun createParallelProjectionMatrix(
    plane: Plane,
    direction: Vector3D
): Matrix4D {
    val k = plane.normal dot direction
    val a = plane.point dot plane.normal
    val v = direction / k
    val n = plane.normal
    return Matrix4D.of(
        1f - v.x * n.x, -v.x * n.y, -v.x * n.z, v.x * a,
        -v.y * n.x, 1f - v.y * n.y, -v.y * n.z, v.y * a,
        -v.z * n.x, -v.z * n.y, 1f - v.z * n.z, v.z * a,
        0f, 0f, 0f, 1f
    )
}