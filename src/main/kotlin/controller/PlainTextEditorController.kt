package controller

import extension.caretRowAndColumn
import extension.caretWordIndex
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import extension.wordCount

class PlainTextEditorController {
    companion object {
        private fun createCoordString(row: Int, column: Int): String = "(Row; Col) : ($row; $column)"

        private fun createWordCountString(wordIndex: Int, wordCount: Int): String = "Words : $wordIndex / $wordCount"
    }

    @FXML
    private lateinit var textArea: TextArea

    @FXML
    private lateinit var coordLabel: Label

    @FXML
    private lateinit var wordCountLabel: Label

    /**
     * The initialization method to be called by JavaFX. Instance will break if used prior to initialization.
     */
    @FXML
    fun initialize() {
        textArea.textProperty()
                .addListener { _, _, _ -> onTextChange() }
        textArea.caretPositionProperty()
                .addListener { _, _, _ -> onCaretMove() }

    }

    private var wordCount = 0
    private var wordIndex = 0

    private fun onTextChange() {
        wordIndex = textArea.caretWordIndex()
        wordCount = textArea.text.wordCount()
        invalidateWordIndexAndCount()
    }


    private fun onCaretMove() {
        val (row, column) = textArea.caretRowAndColumn()
        coordLabel.text = createCoordString(row, column)
        wordIndex = textArea.caretWordIndex()
        invalidateWordIndexAndCount()
    }

    private fun invalidateWordIndexAndCount() {
        wordCountLabel.text = createWordCountString(wordIndex, wordCount)
    }
}