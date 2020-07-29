package controller

import caretRowAndColumn
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import wordCount

class PlainTextEditorController {
    companion object {
        private fun createCoordString(row: Int, column: Int): String = "(Row; Col) : ($row; $column)"

        private fun createWordCountString(wordCount: Int): String = "Words : $wordCount"
    }

    @FXML
    private lateinit var textArea: TextArea

    @FXML
    private lateinit var coordLabel: Label

    @FXML
    private lateinit var wordCountLabel: Label

    @FXML
    fun initialize() {
        textArea.caretPositionProperty()
                .addListener { _, _, _ -> onCaretMove() }
        textArea.textProperty()
                .addListener { _, _, _ -> onTextChange() }
    }

    private fun onTextChange() {
        val wordCount = textArea.text.wordCount()
        wordCountLabel.text = createWordCountString(wordCount)
    }


    private fun onCaretMove() {
        val (row, column) = textArea.caretRowAndColumn()
        coordLabel.text = createCoordString(row, column)
    }
}