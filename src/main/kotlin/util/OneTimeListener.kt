package util

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue

/**
 * A special ChangeListener that unsubscribes itself
 * after its first and only event, then hands control
 * over to a supplied callback
 */
class OneTimeListener<T>(private val callback: () -> Unit) : ChangeListener<T?> {
    override fun changed(observable: ObservableValue<out T?>?, oldValue: T?, newValue: T?) {
        observable?.removeListener(this)
        callback()
    }
}