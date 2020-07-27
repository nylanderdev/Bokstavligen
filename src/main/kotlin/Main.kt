import javafx.application.Application;
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {

    companion object {
        private val PLAIN_TEXT_EDITOR: String = "PlainTextEditor"

        private fun loadFxml(name: String): Scene {
            return Scene(FXMLLoader.load(javaClass.getResource("fxml/$name.fxml")))
        }
    }

    fun launchApp(args: Array<String>) {
        launch(*args)
    }

    override fun start(primary: Stage) {
        primary.title = "Bokstavligen"
        primary.width = 600.0
        primary.height = 400.0
        primary.scene = loadFxml(PLAIN_TEXT_EDITOR)
        primary.show()
    }

}

fun main(args: Array<String>) {
    Main().launchApp(args)
}
