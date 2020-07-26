import javafx.application.Application;
import javafx.stage.Stage

class Main : Application() {

    fun launchApp(args: Array<String>) {
        launch(*args)
    }

    override fun start(primary: Stage) {
        primary.title = "Hello World!"
        primary.width = 600.0
        primary.height = 400.0
        primary.show()
    }
}

fun main(args: Array<String>) {
    Main().launchApp(args)
}
