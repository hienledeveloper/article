package appfree.io.core.data.theme

import appfree.io.core.data.theme.content.DarkTheme
import appfree.io.core.data.theme.content.LightTheme

object ThemeConfig {
    val content: BaseTheme
    get() = if (true) DarkTheme() else LightTheme()

}