package yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.internal

import yellowstarsoftware.yellowstar.math.geometry.objects.Rectangle
import yellowstarsoftware.yellowstar.math.geometry.objects.quadtree.QuadtreeNode

/**
 * [QuadtreeNode] implementation.
 * @param area area of the node
 * @param item item of the node
 * @param children children of the node
 */
internal class QuadtreeNodeImpl<T>(
    override val area: Rectangle,
    override val item: T,
    override val children: List<QuadtreeNode<T>>
) : QuadtreeNode<T>