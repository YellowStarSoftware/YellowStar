package yellowstarsoftware.yellowstar.math.geometry

import yellowstarsoftware.yellowstar.utils.doubleFor

/**
 * Matrix 3x3.
 */
class Matrix3D private constructor(
    private val values: FloatArray
) {

    /**
     * Entry of the instance at (i, j).
     * @param i column index starting with 0
     * @param j row index starting with 0
     */
    operator fun get(i: Int, j: Int): Float {
        return values[makeIndex(i, j)]
    }

    /**
     * Matrix sum.
     */
    operator fun plus(m: Matrix3D): Matrix3D {
        return create { i, j ->
            this[i, j] + m[i, j]
        }
    }

    /**
     * Matrix difference.
     */
    operator fun minus(m: Matrix3D): Matrix3D {
        return create { i, j ->
            this[i, j] - m[i, j]
        }
    }

    /**
     * Matrix multiplied by -1.
     */
    operator fun unaryMinus(): Matrix3D {
        return create { i, j ->
            -this[i, j]
        }
    }

    /**
     * Matrix multiplication by value.
     */
    operator fun times(k: Float): Matrix3D {
        return create { i, j ->
            this[i, j] * k
        }
    }

    /**
     * Matrix multiplication.
     */
    operator fun times(m: Matrix3D): Matrix3D {
        return create { i, j ->
            (0 until DIMENSION).fold(0.0f) { buffer, k ->
                buffer + this[i, k] * m[k, j]
            }
        }
    }

    /**
     * Matrix multiplication.
     * Vector [v] treated as a column-vector.
     */
    operator fun times(v: Vector3D): Vector3D {
        val x = this[0, 0] * v.x + this[0, 1] * v.y + this[0, 2] * v.z
        val y = this[1, 0] * v.x + this[1, 1] * v.y + this[1, 2] * v.z
        val z = this[2, 0] * v.x + this[2, 1] * v.y + this[2, 2] * v.z
        return Vector3D(x, y, z)
    }

    /**
     * Matrix division by value.
     */
    operator fun div(k: Float): Matrix3D {
        return create { i, j ->
            this[i, j] / k
        }
    }

    /**
     * Transposed matrix.
     */
    fun transposed(): Matrix3D {
        return create { i, j ->
            this[j, i]
        }
    }

    /**
     * Determinant of the instance.
     */
    fun determinant(): Float {
        val k = 0
        return (0 until DIMENSION).fold(0.0f) { buffer, index ->
            buffer + this[k, index] * this.algebraicComplement(k, index)
        }
    }

    /**
     * Inverse matrix.
     */
    fun inverse(): Matrix3D {
        val det = determinant()
        val thisTransposed = this.transposed()
        return create { i, j ->
            val a = thisTransposed.algebraicComplement(i, j)
            a / det
        }
    }

    /**
     * Returns array that contains matrix
     * entries in row-major order.
     */
    fun getValues(): FloatArray {
        return values.copyOf()
    }

    private fun complementaryMinor(i: Int, j: Int): Matrix2D {
        return Matrix2D.create { iterI, iterJ ->
            val actualI = if (iterI < i) iterI else iterI + 1
            val actualJ = if (iterJ < j) iterJ else iterJ + 1
            this[actualI, actualJ]
        }
    }

    private fun algebraicComplement(i: Int, j: Int): Float {
        val res = complementaryMinor(i, j).determinant()
        return if ((i + j) % 2 == 0) res else -res
    }

    companion object {

        /**
         * Creates a matrix.
         * @param builder matrix entries provider
         */
        fun create(builder: (Int, Int) -> Float): Matrix3D {
            val values = FloatArray(DIMENSION * DIMENSION)
            doubleFor(
                0, DIMENSION,
                0, DIMENSION
            ) { i, j ->
                values[makeIndex(i, j)] = builder.invoke(i, j)
            }
            return Matrix3D(values)
        }

        /**
         * Creates a matrix.
         * @param values entries in row-major order
         */
        fun of(vararg values: Float): Matrix3D {
            return Matrix3D(values.copyOf())
        }

        private const val DIMENSION = 3
        private fun makeIndex(i: Int, j: Int) = i * DIMENSION + j
    }
}

/**
 * Transforms vector [v] treated as a vector in a
 * homogeneous coordinate system (v.xyz, 0).
 * Effectively ignores the last line of the matrix.
 */
fun Matrix3D.transformVector(v: Vector2D): Vector2D {
    val x = this[0, 0] * v.x + this[0, 1] * v.y
    val y = this[1, 0] * v.x + this[1, 1] * v.y
    return Vector2D(x, y)
}

/**
 * Transforms vector [v] treated as a vector in a
 * homogeneous coordinate system (v.xyz, 1).
 */
fun Matrix3D.transformPoint(v: Vector2D): Vector2D {
    val x = this[0, 0] * v.x + this[0, 1] * v.y + this[0, 2]
    val y = this[1, 0] * v.x + this[1, 1] * v.y + this[1, 2]
    val w = this[2, 0] * v.x + this[2, 1] * v.y + this[2, 2]
    return Vector2D(
        x / w,
        y / w
    )
}

/**
 * @see Matrix3D.times
 */
operator fun Float.times(a: Matrix3D): Matrix3D {
    return a.times(this)
}