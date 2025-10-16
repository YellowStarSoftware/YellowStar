package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector2D

/**
 * Two-dimensional ray.
 * @property vertex vertex of the ray
 * @property direction direction of the ray (must be unit length)
 */
data class Ray2D(
    val vertex: Vector2D,
    val direction: Vector2D
) {

    /**
     * The line on which the ray lies.
     */
    val line get() = Line2D(
        point = vertex,
        direction = direction
    )
}