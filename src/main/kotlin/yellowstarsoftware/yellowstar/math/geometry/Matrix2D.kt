package yellowstarsoftware.yellowstar.math.geometry

import yellowstarsoftware.yellowstar.utils.doubleFor

/**
 * Matrix 2x2.
 */
class Matrix2D private constructor(
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
    operator fun plus(m: Matrix2D): Matrix2D {
        return create { i, j ->
            this[i, j] + m[i, j]
        }
    }

    /**
     * Matrix difference.
     */
    operator fun minus(m: Matrix2D): Matrix2D {
        return create { i, j ->
            this[i, j] - m[i, j]
        }
    }

    /**
     * Matrix multiplied by -1.
     */
    operator fun unaryMinus(): Matrix2D {
        return create { i, j ->
            -this[i, j]
        }
    }

    /**
     * Matrix multiplication by value.
     */
    operator fun times(k: Float): Matrix2D {
        return create { i, j ->
            this[i, j] * k
        }
    }

    /**
     * Matrix multiplication.
     */
    operator fun times(m: Matrix2D): Matrix2D {
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
    operator fun times(v: Vector2D): Vector2D {
        val x = this[0, 0] * v.x + this[0, 1] * v.y
        val y = this[1, 0] * v.x + this[1, 1] * v.y
        return Vector2D(x, y)
    }

    /**
     * Matrix division by value.
     */
    operator fun div(k: Float): Matrix2D {
        return create { i, j ->
            this[i, j] / k
        }
    }

    /**
     * Transposed matrix.
     */
    fun transposed(): Matrix2D {
        return create { i, j ->
            this[j, i]
        }
    }

    /**
     * Determinant of the instance.
     */
    fun determinant(): Float {
        return this[0, 0] * this[1, 1] - this[1, 0] * this[0, 1]
    }

    /**
     * Inverse matrix.
     */
    fun inverse(): Matrix2D {
        return of(
            get(1, 1), -get(0, 1),
            -get(1, 0), get(0, 0)
        ) / determinant()
    }

    /**
     * Returns array that contains matrix
     * entries in row-major order.
     */
    fun getValues(): FloatArray {
        return values.copyOf()
    }

    companion object {

        /**
         * Creates a matrix.
         * @param builder matrix entries provider
         */
        fun create(builder: (Int, Int) -> Float): Matrix2D {
            val values = FloatArray(DIMENSION * DIMENSION)
            doubleFor(
                0, DIMENSION,
                0, DIMENSION
            ) { i, j ->
                values[makeIndex(i, j)] = builder.invoke(i, j)
            }
            return Matrix2D(values)
        }

        /**
         * Creates a matrix.
         * @param values entries in row-major order
         */
        fun of(vararg values: Float): Matrix2D {
            return Matrix2D(values.copyOf())
        }

        private const val DIMENSION = 2
        private fun makeIndex(i: Int, j: Int) = i * DIMENSION + j
    }
}

/**
 * @see Matrix2D.times
 */
operator fun Float.times(a: Matrix2D): Matrix2D {
    return a.times(this)
}
