package util

import javafx.geometry.Dimension2D
import javafx.scene.text.Font
import javafx.scene.text.Text

object TextUtil {
    private val reusableText = Text()

    fun getSize(font: Font, text: String): Dimension2D {
        reusableText.font = font
        reusableText.text = text
        val bounds = reusableText.layoutBounds
        return Dimension2D(bounds.width, bounds.height)
    }
}