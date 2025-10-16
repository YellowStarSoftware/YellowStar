package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Cut cone.
 *
 * @property vertex apex of the cone
 * @property direction direction from [vertex] towards base of the cone (must be unit length)
 * @property radius radius of the base
 * @property startHeight start height of the cone (must be positive)
 * @property endHeight end height of the cone (must be bigger than [startHeight])
 */
data class Cone(
    val vertex: Vector3D,
    val direction: Vector3D,
    val radius: Float,
    val startHeight: Float,
    val endHeight: Float
)