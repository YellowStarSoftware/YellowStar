package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Three-dimensional ray.
 * @property vertex vertex of the ray
 * @property direction direction of the ray (must be unit length)
 */
data class Ray3D(
    val vertex: Vector3D,
    val direction: Vector3D
) {

    /**
     * The line on which the ray lies.
     */
    val line get() = Line3D(
        point = vertex,
        direction = direction
    )
}