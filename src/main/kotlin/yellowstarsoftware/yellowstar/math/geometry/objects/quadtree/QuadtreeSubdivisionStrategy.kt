package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree

import yellowstarsoftware.yellowstar.math.geometry.objects.Rectangle

/**
 * Strategy that defines how a [Quadtree] will be created.
 */
fun interface QuadtreeSubdivisionStrategy<T> {

    /**
     * Processes a rectangular area.
     * @param area area of the node
     * @param depth depths of the node starting from 0 for the root node
     */
    fun processArea(
        area: Rectangle,
        depth: Int
    ): AreaSubdivisionAction<T>
}