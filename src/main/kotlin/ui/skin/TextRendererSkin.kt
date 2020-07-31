package ui.skin

import javafx.geometry.HPos
import javafx.geometry.VPos
import javafx.scene.control.SkinBase
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.paint.Color
import javafx.scene.text.Text
import ui.TextRenderer
import util.TextArranger

class TextRendererSkin(private val renderer: TextRenderer) : SkinBase<TextRenderer>(renderer) {
    companion object {
        private const val loremIpsum = "gravida in fermentum et sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras fermentum odio eu feugiat pretium nibh ipsum consequat nisl vel pretium lectus quam id leo in vitae turpis massa sed elementum tempus egestas sed sed risus pretium quam vulputate dignissim suspendisse in est ante in nibh mauris cursus mattis molestie a iaculis at erat pellentesque adipiscing commodo elit at imperdiet dui accumsan sit amet nulla facilisi morbi tempus iaculis urna id volutpat lacus laoreet non curabitur gravida arcu ac tortor dignissim convallis aenean et tortor at risus viverra adipiscing at"
    }

    private var textRows = listOf(listOf(Text(loremIpsum)))

    init {
        textRows = TextArranger.arrangeTextInRows(20.0, flattenTextRows())
        children.addAll(flattenTextRows())
        renderer.background = Background(BackgroundFill(Color.WHITE, null, null))
        renderer.widthProperty().addListener { _, _, newWidth -> onResize(newWidth) }
    }

    private fun onResize(newWidth: Number?) {
        val oldText = flattenTextRows()
        textRows = TextArranger.arrangeTextInRows(newWidth as Double, oldText)
        children.removeAll(oldText)
        children.addAll(flattenTextRows())
    }

    private fun flattenTextRows(): List<Text> {
        val flatList = mutableListOf<Text>()
        for (row in textRows) {
            for (text in row) {
                flatList.add(text)
            }
        }
        return flatList
    }

    override fun layoutChildren(contentX: Double, contentY: Double, contentWidth: Double, contentHeight: Double) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight)
        var y = 20.0;
        for (row in textRows) {
            var x = 20.0
            for (text in row) {
                text.caretPosition = 0
                val width = text.layoutBounds.width
                layoutInArea(text, x, y, width, text.layoutBounds.height,
                        50.0, HPos.LEFT, VPos.TOP)
                x += width
            }
            y += 10
        }
    }

    override fun computePrefHeight(width: Double, topInset: Double, rightInset: Double, bottomInset: Double, leftInset: Double): Double {
        return 500.0
    }

    override fun computePrefWidth(height: Double, topInset: Double, rightInset: Double, bottomInset: Double, leftInset: Double): Double {
        return 500.0
    }
}
