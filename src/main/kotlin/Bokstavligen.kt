import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage

class Bokstavligen : Application() {
    companion object {
        private const val PLAIN_TEXT_EDITOR = "PlainTextEditor"
        private const val CANVAS_TEXT_EDITOR = "CanvasTextEditor"

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
        primary.scene = loadFxml(CANVAS_TEXT_EDITOR)
        primary.show()
    }
}