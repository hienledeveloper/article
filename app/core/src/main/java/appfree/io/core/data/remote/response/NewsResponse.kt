package appfree.io.core.data.remote.response

import appfree.io.core.data.local.NewsDocument
import appfree.io.core.data.local.Section

data class NewsResponse (
    val sections: List<Section>
) {
    val documents: List<NewsDocument>
    get() {
        val list = ArrayList<NewsDocument>()
        sections.forEach { section ->
            sections.forEach { item ->
                list.add(
                    NewsDocument(
                        documentId = item.documentId,
                        title = item.title,
                        sourceId = item.sourceId,
                        image = item.image.url
                    ))
            }
        }
        return list
    }
}