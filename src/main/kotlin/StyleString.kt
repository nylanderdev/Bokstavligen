import javafx.scene.paint.Paint
import javafx.scene.text.Font

abstract class StyleString {
    companion object Style {
        const val NONE = 0b0000
        const val BOLD = 0b0001
        const val ITALIC = 0b0010
        const val UNDERLINE = 0b0100
        const val STRIKETHROUGH = 0b1000

        fun combine(vararg styles: Int): Int {
            var combined = NONE
            styles.forEach { style -> combined = combined or style }
            return combined
        }

        fun isBold(style: Int): Boolean = isStyledAs(style, BOLD)
        fun isItalic(style: Int): Boolean = isStyledAs(style, ITALIC)
        fun isUnderline(style: Int): Boolean = isStyledAs(style, UNDERLINE)
        fun isStrikethrough(style: Int): Boolean = isStyledAs(style, STRIKETHROUGH)
        private fun isStyledAs(style: Int, styleToTestFor: Int) = style and styleToTestFor == styleToTestFor
    }

    abstract fun fontAt(index: Int): Font
    abstract fun styleAt(index: Int): Int
    abstract fun paintAt(index: Int): Paint
    abstract fun charAt(index: Int): Char
}