package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D
import yellowstarsoftware.yellowstar.math.geometry.lengthSquared
import yellowstarsoftware.yellowstar.math.utils.sqr

/**
 * Cylinder.
 * @property position center of the bottom base of the instance
 * @property direction direction from [position] toward center of the top base of the instance (must be unit length)
 * @property radius radius of the instance
 * @property height height of the instance
 */
data class Cylinder(
    val position: Vector3D,
    val direction: Vector3D,
    val radius: Float,
    val height: Float
)

/**
 * Squared radius of the instance.
 */
val Cylinder.radiusSquared get() = radius * radius

/**
 * Diameter of the cylinder.
 */
val Cylinder.diameter get() = radius * 2f

/**
 * Checks if [this] [Cylinder] contains [point].
 */
operator fun Cylinder.contains(
    point: Vector3D
): Boolean {
    val v = point - this.position
    val d = v dot this.direction
    if (d < 0f || d > this.height) return false
    val lSq = v.lengthSquared - sqr(d)
    return lSq <= this.radiusSquared
}