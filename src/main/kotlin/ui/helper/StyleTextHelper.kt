package ui.helper

import com.sun.javafx.geom.BaseBounds
import com.sun.javafx.geom.transform.BaseTransform
import com.sun.javafx.scene.NodeHelper
import com.sun.javafx.sg.prism.NGNode
import javafx.scene.Node
import ui.StyleText
import ui.peer.NGStyleText

object StyleTextHelper : NodeHelper() {

    fun initHelper(styleText: StyleText) {
        setHelper(styleText, StyleTextHelper)
    }

    override fun createPeerImpl(node: Node?): NGNode = NGStyleText()

    override fun computeGeomBoundsImpl(node: Node?, bounds: BaseBounds?, tx: BaseTransform?): BaseBounds {
        return BaseBounds.getInstance(0f, 0f, 100f, 100f)
    }

    override fun computeContainsImpl(node: Node?, localX: Double, localY: Double): Boolean {
        return true
    }

}