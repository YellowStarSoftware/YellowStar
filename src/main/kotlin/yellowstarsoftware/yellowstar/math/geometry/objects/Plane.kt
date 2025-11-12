package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.utils.indexOfMax
import kotlin.math.abs

/**
 * Plane in space.
 * @param point point laying on the plane
 * @param normal normal to the plane (must be unit length)
 */
data class Plane(
    val point: Vector3D,
    val normal: Vector3D
) {

    companion object {

        /**
         * Creates a plane defined with given equation A*x + B*y + C*z + D = 0.
         * A*B*C must not be zero.
         */
        fun fromPlaneEquation(A: Float, B: Float, C: Float, D: Float): Plane {
            return Plane(
                // indexOfMax to prevent division by zero!
                point = when (indexOfMax(abs(A), abs(B), abs(C))) {
                    0 -> Vector3D(-D / A, 0.0f, 0.0f)
                    1 -> Vector3D(0.0f, -D / B, 0.0f)
                    else -> Vector3D(0.0f, 0.0f, -D / C)
                },
                normal = Vector3D(A, B, C).normalized
            )
        }
    }
}

/**
 * Signed distance from [this] plane to [point].
 */
fun Plane.signedDistanceTo(
    point: Vector3D
): Float {
    return (point - this.point) dot this.normal
}