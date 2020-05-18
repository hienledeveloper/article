package appfree.io.core.support

import android.content.Context
import android.widget.Toast

class AppToast {

    private val hasToast = false

    fun toastLong(context: Context, string: String?) {
        if (hasToast) {
            string?.let { s ->
                Toast.makeText(context, s, Toast.LENGTH_LONG).show()
            }
        }

    }

    fun toastShort(context: Context, string: String?) {
        if (hasToast) {
            string?.let { s ->
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
            }
        }
    }

}