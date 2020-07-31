package ui

import javafx.scene.control.Control
import javafx.scene.control.Skin
import ui.skin.TextRendererSkin

class TextRenderer : Control() {
    override fun createDefaultSkin(): Skin<*> {
        return TextRendererSkin(this)
    }
}