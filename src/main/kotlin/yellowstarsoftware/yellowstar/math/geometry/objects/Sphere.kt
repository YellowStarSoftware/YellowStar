package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.lengthSquared

/**
 * Sphere.
 * @property center center of the sphere
 * @property radius radius of the sphere
 */
data class Sphere(
    val center: Vector3D,
    val radius: Float
)

/**
 * Squared radius of the instance.
 */
val Sphere.radiusSquared get() = radius * radius

/**
 * Diameter of the sphere.
 */
val Sphere.diameter get() = radius * 2f

/**
 * Checks if [this] [Sphere] contains [point].
 */
operator fun Sphere.contains(
    point: Vector3D
): Boolean {
    val v = this.center - point
    return v.lengthSquared <= this.radiusSquared
}