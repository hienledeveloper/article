package appfree.io.core.data.local

data class News(val id: String = "",
                val items: List<Section>?)

data class Section(
    val image: ImageUrl,
    val sourceId: String = "",
    val documentId: String = "",
    val title: String = "",
    val url: String = ""
)

data class ImageUrl(val origin_url: String = "",
                    val mime_type: String = "",
                    val scales: String = "",
                    val width: Int = 0,
                    val url: String = "",
                    val height: Int = 0)

