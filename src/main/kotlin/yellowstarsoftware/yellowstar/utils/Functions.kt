package yellowstarsoftware.yellowstar.utils

/**
 * Double for-loop.
 * Calls [block] for each of value
 * in ([iFrom] until [iTo]) * ([jFrom] until [jTo]).
 */
internal inline fun doubleFor(
    iFrom: Int,
    iTo: Int,
    jFrom: Int,
    jTo: Int,
    block: (Int, Int) -> Unit
) {
    for (i in iFrom until iTo)
        for (j in jFrom until jTo) block.invoke(i, j)
}