package ui.peer

import com.sun.javafx.sg.prism.NGNode
import com.sun.prism.Graphics
import com.sun.prism.paint.Color

class NGStyleText : NGNode() {
    override fun hasOverlappingContents(): Boolean = false

    override fun renderContent(nullableGraphics: Graphics?) {
        if (nullableGraphics == null) return
        val graphics: Graphics = nullableGraphics
        graphics.paint = Color.BLUE
        graphics.fillRect(0f, 0f, 100f, 100f)
    }
}