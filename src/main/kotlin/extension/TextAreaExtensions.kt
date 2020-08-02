package extension

import javafx.scene.control.TextArea

fun TextArea.caretRowAndColumn(): Pair<Int, Int> {
    // todo (low priority): O(n), optimize if necessary and possible
    val textBeforeCaret = this.textBeforeCaret()
    val caretLineStartIndex = textBeforeCaret.lastIndexOf("\n") + 1
    val caretLineBeforeCaret = textBeforeCaret.substring(caretLineStartIndex)
    val row = countNewLines(textBeforeCaret)
    val column = caretLineBeforeCaret.length
    return Pair(row, column)
}

fun TextArea.caretWordIndex(): Int {
    val textBeforeCaret = this.textBeforeCaret()
    return textBeforeCaret.wordCount()
}

private fun TextArea.textBeforeCaret(): String =
        this.text.substring(0, this.caretPosition.coerceAtMost(this.text.length))

private fun countNewLines(string: String): Int =
        string.length - string.replace("\n", "").length