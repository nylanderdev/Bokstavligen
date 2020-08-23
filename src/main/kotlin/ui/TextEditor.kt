package ui

import javafx.beans.property.Property
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.scene.control.Control
import javafx.scene.control.Skin
import javafx.scene.text.Font
import ui.skin.TextEditorSkin

class TextEditor : Control() {
    init {
        width = 500.0
        height = 500.0
    }

    private val textProperty: StringProperty = SimpleStringProperty("")
    fun textProperty(): StringProperty = textProperty
    var text: String
        get() {
            return textProperty.get()
        }
        set(value) {
            textProperty.set(value)
        }

    private val fontProperty: Property<Font> = SimpleObjectProperty(Font.getDefault())
    fun fontProperty(): StringProperty = textProperty
    var font: Font
        get() {
            return fontProperty.value
        }
        set(value) {
            fontProperty.value = value
        }


    override fun createDefaultSkin(): Skin<TextEditor> = TextEditorSkin(this)
}