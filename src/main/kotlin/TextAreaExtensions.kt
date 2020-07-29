import javafx.scene.control.TextArea

fun TextArea.caretRowAndColumn(): Pair<Int, Int> {
    // todo (low priority): O(n), optimize if necessary and possible
    val textBeforeCaret = this.text.substring(0, this.caretPosition)
    val caretLineStartIndex = textBeforeCaret.lastIndexOf("\n") + 1
    val caretLineBeforeCaret = textBeforeCaret.substring(caretLineStartIndex)
    val row = countNewLines(textBeforeCaret)
    val column = caretLineBeforeCaret.length
    return Pair(row, column)
}

private fun countNewLines(string: String): Int =
        string.length - string.replace("\n", "").length