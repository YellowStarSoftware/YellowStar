package yellowstarsoftware.yellowstar.math.geometry

/**
 * Barycentric coordinates.
 * Sum of [x], [y], and [z] must be 1.
 * @property x x
 * @property y y
 * @property z z
 */
data class BarycentricCoordinates(
    val x: Float,
    val y: Float,
    val z: Float
)

/**
 * Returns the barycentric coordinates of
 * [this] point in given basic [p0], [p1], [p2].
 */
fun Vector2D.toBarycentric(
    p0: Vector2D,
    p1: Vector2D,
    p2: Vector2D
) : BarycentricCoordinates {
    val v = this - p0
    val e1 = p1 - p0
    val e2 = p2 - p0
    val d1 = e1.orthogonal
    val d2 = e2.orthogonal
    val y = (v dot d2) / (e1 dot d2)
    val z = (v dot d1) / (e2 dot d1)
    val x = 1f - z - y
    return BarycentricCoordinates(
        x = x,
        y = y,
        z = z
    )
}

/**
 * Returns the barycentric coordinates of
 * [this] point in given basis [p0], [p1], [p2]
 * and [normal] of unit size to the triangle ([p0], [p1], [p2]).
 */
fun Vector3D.toBarycentric(
    normal: Vector3D,
    p0: Vector3D,
    p1: Vector3D,
    p2: Vector3D
) : BarycentricCoordinates {
    val v = this - p0
    val e1 = p1 - p0
    val e2 = p2 - p0
    val d1 = normal cross e1
    val d2 = normal cross e2
    val y = (v dot d2) / (e1 dot d2)
    val z = (v dot d1) / (e2 dot d1)
    val x = 1f - z - y
    return BarycentricCoordinates(
        x = x,
        y = y,
        z = z
    )
}

/**
 * Returns the cartesian coordinates of [this]
 * [BarycentricCoordinates] in given basis [p0], [p1], [p2].
 */
fun BarycentricCoordinates.toCartesian(
    p0: Vector2D,
    p1: Vector2D,
    p2: Vector2D
) : Vector2D {
    return x * p0 + y * p1 + z * p2
}

/**
 * Returns the cartesian coordinates of [this]
 * [BarycentricCoordinates] in given basis [p0], [p1], [p2].
 */
fun BarycentricCoordinates.toCartesian(
    p0: Vector3D,
    p1: Vector3D,
    p2: Vector3D
) : Vector3D {
    return x * p0 + y * p1 + z * p2
}

/**
 * Returns the cartesian coordinates of [this]
 * [BarycentricCoordinates] in given basis [p0], [p1], [p2].
 */
fun BarycentricCoordinates.toCartesian(
    p0: Vector4D,
    p1: Vector4D,
    p2: Vector4D
) : Vector4D {
    return x * p0 + y * p1 + z * p2
}