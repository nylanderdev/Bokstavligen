import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * The JavaFX application behind Bokstavligen
 */
class Bokstavligen : Application() {
    companion object {
        private const val PLAIN_TEXT_EDITOR = "PlainTextEditor"

        private fun loadFxml(name: String): Scene {
            return Scene(FXMLLoader.load(::Bokstavligen.javaClass.getResource("fxml/$name.fxml")))
        }
    }

    /**
     * Starts this instance of Bokstavligen
     *
     * @param args Command-line arguments to forward to the app
     */
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