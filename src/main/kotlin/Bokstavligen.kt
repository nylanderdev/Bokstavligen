import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.stage.Stage
import ui.TextRenderer

class Bokstavligen : Application() {
    companion object {
        private const val PLAIN_TEXT_EDITOR: String = "PlainTextEditor"

        private fun loadFxml(name: String): Scene {
            return Scene(FXMLLoader.load(::Bokstavligen.javaClass.getResource("fxml/$name.fxml")))
        }
    }

    fun launchApp(args: Array<String>) {
        launch(*args)
    }

    override fun start(primary: Stage) {
        primary.title = "Bokstavligen"
        primary.width = 600.0
        primary.height = 400.0
        val renderer = TextRenderer()
        primary.scene = Scene(renderer)//loadFxml(PLAIN_TEXT_EDITOR)
        primary.show()
    }
}