package appfree.io.core.support

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.content.ContextCompat
import appfree.io.core.R

object LinkUtil {

    fun openUrlInstanceApp(context: Context?, link: String?) {

        context?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtras(Bundle().apply {
                    putInt(
                        "android.support.customtabs.extra.TOOLBAR_COLOR",
                        ContextCompat.getColor(it, android.R.color.white)
                    )
                    putBinder("android.support.customtabs.extra.SESSION", null)
                })
                this.setPackage("com.android.chrome")
            }
            it.startActivity(intent)
        }
    }

    fun openUrlExternalApp(context: Context?, link: String?) {

        context?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            it.startActivity(intent)
        }
    }

}