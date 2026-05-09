package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree

import yellowstarsoftware.yellowstar.math.geometry.objects.Rectangle
import yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.internal.QuadtreeImpl

/**
 * Quadtree.
 */
interface Quadtree<T> {

    /**
     * Root of the three.
     */
    val root: QuadtreeNode<T>

    companion object {

        /**
         * Creates a [Quadtree] of [area] with given [strategy].
         */
        fun <T> create(
            area: Rectangle,
            strategy: QuadtreeSubdivisionStrategy<T>
        ): Quadtree<T>? {
            return QuadtreeImpl.create(
                area = area,
                strategy = strategy
            )
        }
    }
}