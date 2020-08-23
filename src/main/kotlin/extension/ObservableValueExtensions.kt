package extension

import javafx.beans.value.ObservableValue
import util.OneTimeListener

fun ObservableValue<*>.onChange(callback: () -> Unit) {
    this.addListener { _, _, _ ->
        callback()
    }
}

/**
 * A user friendly extension function which creates
 * a OneTimeListener and subscribes it to the
 * ObservableValue the function was called on
 */
fun ObservableValue<*>.onceOnChange(callback: () -> Unit) {
    this.addListener(OneTimeListener(callback))
}