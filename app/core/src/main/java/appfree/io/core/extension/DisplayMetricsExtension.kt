package appfree.io.core.extension

import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.annotation.Dimension

var displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

//Converts the `dp` value to pixels dimension.
val Int.dpToPx: Int
    @Dimension(unit = Dimension.PX) get() = (this * displayMetrics.density).toInt()

//Converts the `pixels` value to dp dimension.
val Int.pxTpDp: Int
    @Dimension(unit = Dimension.DP) get() = (this / displayMetrics.density).toInt()