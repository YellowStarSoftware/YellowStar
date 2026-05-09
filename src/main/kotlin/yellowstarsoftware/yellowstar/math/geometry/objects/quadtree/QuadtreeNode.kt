package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree

import yellowstarsoftware.yellowstar.math.geometry.objects.Rectangle

/**
 * Node in a [Quadtree].
 */
interface QuadtreeNode<T> {

    /**
     * Area of the node.
     */
    val area: Rectangle

    /**
     * Item of the node.
     */
    val item: T

    /**
     * Children of the node.
     */
    val children: List<QuadtreeNode<T>>
}