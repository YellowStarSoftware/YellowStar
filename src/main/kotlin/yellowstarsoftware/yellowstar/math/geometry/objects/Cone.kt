package yellowstarsoftware.yellowstar.math.geometry.objects

import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Cut cone.
 * @property vertex apex of the cone
 * @property direction direction from [vertex] towards base of the cone (must be unit length)
 * @property radiusCoefficient radius to height ratio (must be positive)
 * @property startHeight start height of the cone (must be positive)
 * @property endHeight end height of the cone (must be larger than [startHeight])
 */
data class Cone(
    val vertex: Vector3D,
    val direction: Vector3D,
    val radiusCoefficient: Float,
    val startHeight: Float,
    val endHeight: Float
)

/**
 * Center of the smallest base of this instance.
 */
val Cone.startBaseCenter get() = vertex + direction * startHeight

/**
 * Center of the largest base of this instance.
 */
val Cone.endBaseCenter get() = vertex + direction * endHeight

/**
 * Radius of the smallest base of the instance.
 */
val Cone.startBaseRadius get() = startHeight * radiusCoefficient

/**
 * Radius of the largest base of the instance.
 */
val Cone.endBaseRadius get() = endHeight * radiusCoefficient