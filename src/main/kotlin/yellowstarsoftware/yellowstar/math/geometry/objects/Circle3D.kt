package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Circle in 3D space.
 *
 * @property center center of the circle
 * @property radius radius of the circle
 * @property normal normal to the plane on which the circle lies (must be unit length)
 */
data class Circle3D(
    val center: Vector3D,
    val radius: Float,
    val normal: Vector3D
)

/**
 * Squared radius of the instance.
 */
val Circle3D.radiusSquared get() = radius * radius

/**
 * Diameter of the circle.
 */
val Circle3D.diameter : Float get() {
    return radius * 2f
}