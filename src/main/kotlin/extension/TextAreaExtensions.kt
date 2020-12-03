package extension

import javafx.scene.control.TextArea

/**
 * Finds the null-indexed row and column on which the caret is currently located
 *
 * @return The current row and column of the caret
 */
fun TextArea.caretRowAndColumn(): Pair<Int, Int> {
    // todo (low priority): O(n), optimize if necessary and possible
    val textBeforeCaret = this.textBeforeCaret()
    val caretLineStartIndex = textBeforeCaret.lastIndexOf("\n") + 1
    val caretLineBeforeCaret = textBeforeCaret.substring(caretLineStartIndex)
    val row = countNewLines(textBeforeCaret)
    val column = caretLineBeforeCaret.length
    return Pair(row, column)
}

/**
 * Counts the number of words (whitespace-separated substrings) preceding the caret
 *
 * @return The number of words before preceding the caret
 */
fun TextArea.caretWordIndex(): Int {
    val textBeforeCaret = this.textBeforeCaret()
    return textBeforeCaret.wordCount()
}

private fun TextArea.textBeforeCaret(): String =
        this.text.substring(0, this.caretPosition.coerceAtMost(this.text.length))

private fun countNewLines(string: String): Int =
        string.length - string.replace("\n", "").length