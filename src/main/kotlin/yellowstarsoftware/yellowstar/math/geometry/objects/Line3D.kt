package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Three-dimensional line.
 * @property point point on the line
 * @property direction of the line (must be unit length)
 */
data class Line3D(
    val point: Vector3D,
    val direction: Vector3D
)