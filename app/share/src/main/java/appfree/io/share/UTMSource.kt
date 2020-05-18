package appfree.io.share

import android.graphics.drawable.Drawable

data class UTMSource (
    var type: UTMSourceType? = null,
    var image: Drawable? = null,
    var name: String? = null,
    var icon: Int? = null,
    var packageName: String? = null
)