package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

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
 * Diameter of the cylinder.
 */
val Cylinder.diameter : Float get() {
    return radius * 2f
}