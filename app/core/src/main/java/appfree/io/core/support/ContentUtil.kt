package appfree.io.core.support

import java.text.Normalizer
import java.util.*

object ContentUtil {

    fun vn2Alphabet(sContent: String?): String? {
        if (!sContent.isNullOrEmpty()) {
            "\\p{InCombiningDiacriticalMarks}+".toRegex().replace(Normalizer.normalize(sContent, Normalizer.Form.NFD),"").let { string ->
                return string.replace(" ","_").toLowerCase(Locale.US)
            }
        }
        return null
    }

}