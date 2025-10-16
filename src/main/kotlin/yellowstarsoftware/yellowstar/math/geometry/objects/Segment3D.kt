package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Three-dimensional line segment.
 * @property first first segment bound
 * @property second second segment bound
 */
data class Segment3D(
    val first: Vector3D,
    val second: Vector3D
)