package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector2D

/**
 * Circle.
 * @property center center of the circle
 * @property radius radius of the circle
 */
data class Circle2D(
    val center: Vector2D,
    val radius: Float
) {
    companion object
}

/**
 * Squared radius of the instance.
 */
val Circle2D.radiusSquared get() = radius * radius

/**
 * Diameter of the circle.
 */
val Circle2D.diameter get() = radius * 2f