package yellowstarsoftware.yellowstar.math.geometry

import yellowstarsoftware.yellowstar.utils.doubleFor

/**
 * Matrix 4x4.
 */
class Matrix4D private constructor(
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
    operator fun plus(m: Matrix4D): Matrix4D {
        return create { i, j ->
            this[i, j] + m[i, j]
        }
    }

    /**
     * Matrix difference.
     */
    operator fun minus(m: Matrix4D): Matrix4D {
        return create { i, j ->
            this[i, j] - m[i, j]
        }
    }

    /**
     * Matrix multiplied by -1.
     */
    operator fun unaryMinus(): Matrix4D {
        return create { i, j ->
            -this[i, j]
        }
    }

    /**
     * Matrix multiplication by value.
     */
    operator fun times(k: Float): Matrix4D {
        return create { i, j ->
            this[i, j] * k
        }
    }

    /**
     * Matrix multiplication.
     */
    operator fun times(m: Matrix4D): Matrix4D {
        return create { i, j ->
            (0 until DIMENSION).fold(0.0f) { buffer, k ->
                buffer + this[i, k] * m[k, j]
            }
        }
    }

    /**
     * Matrix division by value.
     */
    operator fun div(k: Float): Matrix4D {
        return create { i, j ->
            this[i, j] / k
        }
    }

    /**
     * Transposed matrix.
     */
    fun transposed(): Matrix4D {
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
    fun inverse(): Matrix4D {
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

    private fun complementaryMinor(i: Int, j: Int): Matrix3D {
        return Matrix3D.create { iterI, iterJ ->
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

        val Unit = create { i, j -> if (i == j) 1.0f else 0.0f }

        /**
         * Creates a matrix.
         * @param builder matrix entries provider
         */
        fun create(builder: (Int, Int) -> Float): Matrix4D {
            val values = FloatArray(DIMENSION * DIMENSION)
            doubleFor(
                0, DIMENSION,
                0, DIMENSION
            ) { i, j ->
                values[makeIndex(i, j)] = builder.invoke(i, j)
            }
            return Matrix4D(values)
        }

        /**
         * Creates a matrix.
         * @param values entries in row-major order
         */
        fun of(vararg values: Float): Matrix4D {
            return Matrix4D(values.copyOf())
        }

        private const val DIMENSION = 4
        private fun makeIndex(i: Int, j: Int) = i * DIMENSION + j
    }
}

/**
 * Transforms vector [v] treated as a vector in a
 * homogeneous coordinate system (v.xyz, 0).
 * Effectively ignores the last line of the matrix.
 */
fun Matrix4D.transformVector(v: Vector3D): Vector3D {
    val x = this[0, 0] * v.x + this[0, 1] * v.y + this[0, 2] * v.z
    val y = this[1, 0] * v.x + this[1, 1] * v.y + this[1, 2] * v.z
    val z = this[2, 0] * v.x + this[2, 1] * v.y + this[2, 2] * v.z
    return Vector3D(x, y, z)
}

/**
 * Transforms vector [v] treated as a vector in a
 * homogeneous coordinate system (v.xyz, 1).
 */
fun Matrix4D.transformPoint(v: Vector3D): Vector3D {
    val x = this[0, 0] * v.x + this[0, 1] * v.y + this[0, 2] * v.z + this[0, 3]
    val y = this[1, 0] * v.x + this[1, 1] * v.y + this[1, 2] * v.z + this[1, 3]
    val z = this[2, 0] * v.x + this[2, 1] * v.y + this[2, 2] * v.z + this[2, 3]
    val w = this[3, 0] * v.x + this[3, 1] * v.y + this[3, 2] * v.z + this[3, 3]
    return Vector3D(
        x / w,
        y / w,
        z / w
    )
}

/**
 * @see Matrix4D.times
 */
operator fun Float.times(a: Matrix4D): Matrix4D {
    return a.times(this)
}