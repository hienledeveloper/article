package appfree.io.share

import android.content.Context
import android.content.Intent

object ShareUtil {


    private const val SHARE_STRING_TYPE = "text/plain"

    fun share(context: Context?, url: String?, packageName: String?) {
        url?.let { mUrl ->
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = SHARE_STRING_TYPE
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mUrl)
            if (!packageName.isNullOrEmpty()) {
                sharingIntent.setPackage(packageName)
            }
            context?.startActivity(Intent.createChooser(sharingIntent, "Share link"))
        }
    }

    fun getShareProvider(context: Context?): List<UTMSource> {
        val list = ArrayList<UTMSource>()
        val listRecommendPackage = arrayListOf(
            UTMSource(type = UTMSourceType.FACEBOOK, icon = R.drawable.ic_share_facebook),
            UTMSource(type = UTMSourceType.MESSENGER, icon = R.drawable.ic_share_fb_messenger),
            UTMSource(type = UTMSourceType.WHATSAPP, icon = R.drawable.ic_share_whatsapp),
            UTMSource(type = UTMSourceType.TWITTER, icon = R.drawable.ic_share_twitter),
            UTMSource(type = UTMSourceType.SKYPE, icon = R.drawable.ic_share_skype),
            UTMSource(type = UTMSourceType.TELEGRAM, icon = R.drawable.ic_share_telegram),
            UTMSource(type = UTMSourceType.GOOGLE_EMAIL, icon = R.drawable.ic_share_email)
        )
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = SHARE_STRING_TYPE
        context?.packageManager?.queryIntentActivities(sharingIntent, 0)?.let { resInfos ->
            listRecommendPackage.forEach { packageNameRecommend ->
                resInfos.forEach { info ->
                    info.activityInfo.packageName.let { packageName ->
                        if (packageNameRecommend.type!!.packageName.contentEquals(packageName)) {
                            list.add(
                                UTMSource(
                                    type = packageNameRecommend.type,
                                    image = info.activityInfo.loadIcon(context.packageManager),
                                    name = info.loadLabel(context.packageManager!!).toString(),
                                    icon = packageNameRecommend.icon,
                                    packageName = packageName
                                )
                            )
                        }
                    }
                }
            }

        }
        list.add(
            UTMSource(
                type = UTMSourceType.COPY,
                image = null
            )
        )
        list.add(
            UTMSource(
                type = UTMSourceType.MORE,
                image = null
            )
        )

        return list
    }

}