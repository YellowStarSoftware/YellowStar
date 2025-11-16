package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Matrix4D
import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import kotlin.math.tan

/**
 * Creates a [Matrix4D] used for perspective projection in 3D graphics.
 * The matrix is for left-handed coordinate system.
 * Effectively transforms a point into a 3d vector (x, y, z), where:
 * x - x component of the projected point
 *     mapped from -width/2..width/2 onto -1..1,
 * x - y component of the projected point
 *     mapped from -height/2..height/2 onto -1..1,
 * z - z component of the original point
 *     mapped from [near]..[far] onto -1..1,
 * where width and height are the dimensions of the
 * near polygon of the view frustum defined
 * by [fovY], [aspect], [near] and [far].
 * @param fovY y field of view
 * @param aspect aspect ratio of the screen
 * @param near distance to the nearest plane
 * @param far distance to the furthest plane
 */
fun createPerspectiveProjectionMatrix(
    fovY: Float,
    aspect: Float,
    near: Float,
    far: Float
): Matrix4D {
    val sY = 1.0f / (tan(fovY / 2.0f))
    val sX = sY / aspect

    val sZ = (far + near) / (far - near)
    val dZ = 2f * near * far / (near - far)

    return Matrix4D.of(
        sX, 0f, 0f, 0f,
        0f, sY, 0f, 0f,
        0f, 0f, sZ, dZ,
        0f, 0f, 1f, 0f
    )
}

/**
 * Creates a look-at [Matrix4D].
 * The matrix effectively converts
 * the world coordinates into camera coordinates.
 * @param right "right" direction of the camera of unit size
 * @param up "up" direction of the camera of unit size
 * @param forth "forth" direction of the camera of unit size
 * @param position position of the camera
 */
fun createLookAtMatrix(
    right: Vector3D,
    up: Vector3D,
    forth: Vector3D,
    position: Vector3D
): Matrix4D {
    return createAffineTransformationMatrix(
        e1 = right,
        e2 = up,
        e3 = forth,
        d = position
    ).inverse()
}