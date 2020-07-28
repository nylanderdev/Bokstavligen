package controller

import TextAreaUtil
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class PlainTextEditorController {
    companion object {
        private fun createCoordString(row: Int, column: Int): String = "(Row; Col) : ($row; $column)"
    }

    @FXML
    private lateinit var textArea: TextArea

    @FXML
    private lateinit var coordLabel: Label

    @FXML
    fun initialize() {
        textArea.caretPositionProperty()
                .addListener { _, _, _ -> onCaretMove() }
    }

    private fun onCaretMove() {
        val (row, column) = TextAreaUtil.findCaretRowAndColumn(textArea)
        coordLabel.text = createCoordString(row, column)
    }
}