package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector2D

/**
 * Two-dimensional line segment.
 * @property first first segment bound
 * @property second second segment bound
 */
data class Segment2D(
    val first: Vector2D,
    val second: Vector2D
)