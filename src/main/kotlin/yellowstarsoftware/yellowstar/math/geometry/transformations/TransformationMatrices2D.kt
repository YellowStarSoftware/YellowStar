package yellowstarsoftware.yellowstar.math.geometry.transformations

import yellowstarsoftware.yellowstar.math.geometry.Matrix3D
import yellowstarsoftware.yellowstar.math.geometry.Vector2D

/**
 * Creates a linear transformation matrix 3x3 defined by vectors
 * [Vector2D.I] and [Vector2D.J], transformed with the transformation.
 * @param e1 [Vector2D.I], transformed with the transformation
 * @param e2 [Vector2D.J], transformed with the transformation
 */
fun createLinearTransformationMatrix(
    e1: Vector2D,
    e2: Vector2D
): Matrix3D = Matrix3D.of(
    e1.x, e2.x, 0f,
    e1.y, e2.y, 0f,
    0f, 0f, 1f
)

/**
 * Creates an affine transformation matrix 3x3 defined by vectors
 * [Vector2D.I] and [Vector2D.J], transformed with the transformation.
 * @param e1 [Vector2D.I], transformed with the transformation
 * @param e2 [Vector2D.J], transformed with the transformation
 * @param d translation vector
 */
fun createAffineTransformationMatrix(
    e1: Vector2D,
    e2: Vector2D,
    d: Vector2D
): Matrix3D = Matrix3D.of(
    e1.x, e2.x, d.x,
    e1.y, e2.y, d.y,
    0f, 0f, 1f
)

/**
 * Creates a scaling matrix 3x3.
 * @param k [Vector2D] defining the scale
 */
fun createScalingMatrix(
    k: Vector2D
): Matrix3D = Matrix3D.of(
    k.x, 0f, 0f,
    0f, k.y, 0f,
    0f, 0f, 1f,
)

/**
 * Creates a translation matrix 3x3.
 * @param d [Vector2D] defining the translation
 */
fun createTranslationMatrix(
    d: Vector2D
): Matrix3D = Matrix3D.of(
    1f, 0f, d.x,
    0f, 1f, d.y,
    0f, 0f, 1f
)

/**
 * Creates an interval mapping matrix 3x3.
 * The matrix maps values of a vector in interval
 * [oldFrom]..[oldTo] onto interval [newFrom]..[newTo].
 */
fun createIntervalMappingMatrix(
    oldFrom: Vector2D,
    oldTo: Vector2D,
    newFrom: Vector2D,
    newTo: Vector2D
): Matrix3D {
    val (sX, dX) = createIntervalMappingScaleTranslate(oldFrom.x, oldTo.x, newFrom.x, newTo.x)
    val (sY, dY) = createIntervalMappingScaleTranslate(oldFrom.y, oldTo.y, newFrom.y, newTo.y)
    return Matrix3D.of(
        sX, 0f, dX,
        0f, sY, dY,
        0f, 0f, 1f
    )
}