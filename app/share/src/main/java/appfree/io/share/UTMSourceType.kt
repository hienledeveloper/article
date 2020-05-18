package appfree.io.share

enum class UTMSourceType(val packageName: String) {
    MESSENGER("com.facebook.orca"),
    TWITTER("com.twitter.android"),
    MESSAGE("com.android.mms"),
    MESSAGES("com.google.android.apps.messaging"),
    GOOGLE_EMAIL("com.google.android.gm"),
    FACEBOOK("com.facebook.katana"),
    WHATSAPP("com.whatsapp"),
    TELEGRAM("org.telegram.messenger"),
    ZALO("com.zing.zalo"),
    SLACK("com.Slack"),
    INSTAGRAM("com.instagram.android"),
    SKYPE("com.skype.raider"),
    MORE("more"),
    COPY("link"),
    NONE("");
}