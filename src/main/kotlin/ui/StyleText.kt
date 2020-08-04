package ui

import javafx.scene.Node
import ui.helper.StyleTextHelper

class StyleText : Node() {
    init {
        StyleTextHelper.initHelper(this)
    }
}