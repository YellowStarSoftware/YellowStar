package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Matrix3D
import yellowstarsoftware.yellowstar.math.geometry.Vector2D
import yellowstarsoftware.yellowstar.math.geometry.objects.Line2D

/**
 * Creates a perspective projection [Matrix3D]
 * with zero as the projection center
 * and [line] as the projection line.
 */
fun createPerspectiveProjectionMatrix(
    line: Line2D
): Matrix3D {
    val k = line.point dot line.normal
    val (nx, ny) = line.normal
    return Matrix3D.of(
        k, 0f, 0f,
        0f, k, 0f,
        nx, ny, 0f
    )
}

/**
 * Creates an orthographic projection [Matrix3D].
 * The matrix defines projection of a point
 * onto [line] parallel to [Line2D.normal].
 */
fun createOrthographicProjectionMatrix(
    line: Line2D
): Matrix3D {
    return createParallelProjectionMatrix(
        line = line,
        direction = line.normal
    )
}

/**
 * Creates a parallel projection [Matrix3D].
 * The matrix defines projection of a point
 * onto [line] parallel to [direction].
 * [direction] must not be parallel to [line].
 */
fun createParallelProjectionMatrix(
    line: Line2D,
    direction: Vector2D
): Matrix3D {
    val k = line.normal dot direction
    val a = line.point dot line.normal
    val v = direction / k
    val n = line.normal
    return Matrix3D.of(
        1f - v.x * n.x, -v.x * n.y, v.x * a,
        -v.y * n.x, 1f - v.y * n.y, v.y * a,
        0f, 0f, 1f
    )
}