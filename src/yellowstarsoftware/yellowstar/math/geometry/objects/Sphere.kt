package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

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
val Sphere.diameter : Float get() {
    return radius * 2f
}