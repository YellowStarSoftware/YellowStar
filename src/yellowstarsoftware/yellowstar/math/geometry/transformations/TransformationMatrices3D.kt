package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Matrix4D
import yellowstarsoftware.yellowstar.math.geometry.Vector3D

/**
 * Creates a linear transformation matrix 4x4 defined by vectors
 * [Vector3D.I], [Vector3D.J], and [Vector3D.K],
 * transformed with the transformation.
 * @param e1 [Vector3D.I], transformed with the transformation
 * @param e2 [Vector3D.J], transformed with the transformation
 * @param e3 [Vector3D.K], transformed with the transformation
 */
fun createLinearTransformationMatrix(
    e1: Vector3D,
    e2: Vector3D,
    e3: Vector3D,
): Matrix4D = Matrix4D.of(
    e1.x, e2.x, e3.x, 0f,
    e1.y, e2.y, e3.y, 0f,
    e1.z, e2.z, e3.z, 0f,
    0f, 0f, 0f, 1f
)

/**
 * Creates an affine transformation matrix 4x4 defined by vectors
 * [Vector3D.I], [Vector3D.J], and [Vector3D.K],
 * transformed with the transformation.
 * @param e1 [Vector3D.I], transformed with the transformation
 * @param e2 [Vector3D.J], transformed with the transformation
 * @param e3 [Vector3D.K], transformed with the transformation
 * @param d translation vector
 */
fun createAffineTransformationMatrix(
    e1: Vector3D,
    e2: Vector3D,
    e3: Vector3D,
    d: Vector3D
): Matrix4D = Matrix4D.of(
    e1.x, e2.x, e3.x, d.x,
    e1.y, e2.y, e3.y, d.y,
    e1.z, e2.z, e3.z, d.z,
    0f, 0f, 0f, 1f
)

/**
 * Creates a scaling matrix 4x4.
 * @param k [Vector3D] defining the scale
 */
fun createScalingMatrix(
    k: Vector3D
): Matrix4D = Matrix4D.of(
    k.x, 0f, 0f, 0f,
    0f, k.y, 0f, 0f,
    0f, 0f, k.z, 0f,
    0f, 0f, 0f, 1f
)

/**
 * Creates a translation matrix 4x4.
 * @param d [Vector3D] defining the translation
 */
fun createTranslationMatrix(
    d: Vector3D
): Matrix4D = Matrix4D.of(
    1f, 0f, 0f, d.x,
    0f, 1f, 0f, d.y,
    0f, 0f, 1f, d.z,
    0f, 0f, 0f, 1f,
)

/**
 * Creates an interval mapping matrix 4x4.
 * The matrix maps values of a vector in interval
 * [oldFrom]..[oldTo] onto interval [newFrom]..[newTo].
 */
fun createIntervalMappingMatrix(
    oldFrom: Vector3D,
    oldTo: Vector3D,
    newFrom: Vector3D,
    newTo: Vector3D
): Matrix4D {
    val (sX, dX) = createIntervalMappingScaleTranslate(oldFrom.x, oldTo.x, newFrom.x, newTo.x)
    val (sY, dY) = createIntervalMappingScaleTranslate(oldFrom.y, oldTo.y, newFrom.y, newTo.y)
    val (sZ, dZ) = createIntervalMappingScaleTranslate(oldFrom.z, oldTo.z, newFrom.z, newTo.z)
    return Matrix4D.of(
        sX, 0f, 0f, dX,
        0f, sY, 0f, dY,
        0f, 0f, sZ, dZ,
        0f, 0f, 0f, 1f
    )
}