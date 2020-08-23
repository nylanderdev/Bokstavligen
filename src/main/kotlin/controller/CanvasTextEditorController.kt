package controller

import extension.onceOnChange
import javafx.fxml.FXML
import javafx.scene.text.Font
import ui.TextEditor

class CanvasTextEditorController {

    @FXML
    private lateinit var textEditor: TextEditor

    @FXML
    fun initialize() {
        textEditor.font = Font.font("Cambria", 50.0)
        textEditor.text = "Hello, world!"
    }
}