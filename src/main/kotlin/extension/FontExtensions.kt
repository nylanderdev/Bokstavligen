package extension

import javafx.geometry.Dimension2D
import javafx.scene.text.Font
import util.TextUtil

fun Font.sizeOf(text: String): Dimension2D = TextUtil.getSize(this, text)