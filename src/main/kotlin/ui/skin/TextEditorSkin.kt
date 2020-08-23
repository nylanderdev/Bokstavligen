package ui.skin

import extension.onChange
import extension.sizeOf
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.SkinBase
import javafx.scene.paint.Color
import javafx.scene.text.Font
import ui.TextEditor

class TextEditorSkin(private val textEditor: TextEditor) : SkinBase<TextEditor>(textEditor) {
    private var canvas: Canvas = Canvas()
    private val graphics: GraphicsContext
        get() = canvas.graphicsContext2D
    private val text: String
        get() = textEditor.text
    private val font: Font
        get() = textEditor.font

    init {
        children.add(canvas)
        subscribeToControl()
        invalidate()
    }

    private fun invalidate() {
        invalidateSize()
    }

    private fun subscribeToControl() {
        textEditor.textProperty().onChange(this::onTextChange)
        textEditor.fontProperty().onChange(this::onFontChange)
        textEditor.widthProperty().onChange(this::onWidthChange)
        textEditor.heightProperty().onChange(this::onHeightChange)
    }

    private fun onTextChange() {
        invalidateText()
    }

    private fun onFontChange() {
        invalidateText()
    }

    private fun onWidthChange() {
        invalidateSize()
    }

    private fun onHeightChange() {
        invalidateSize()
    }

    private fun invalidateSize() {
        resizeCanvas()
        invalidateText()
    }

    private fun invalidateText() {
        clearCanvas()
        renderText()
    }

    private fun resizeCanvas() {
        children.remove(canvas)
        canvas = Canvas(textEditor.width, textEditor.height)
        children.add(canvas)
    }

    private fun clearCanvas() {
        graphics.clearRect(0.0, 0.0,
                canvas.width, canvas.height)
    }

    private fun renderText() {
        graphics.fill = Color.BLACK
        graphics.font = font
        val height = font.sizeOf(text).height
        graphics.fillText(text, 0.0, height)
    }
}