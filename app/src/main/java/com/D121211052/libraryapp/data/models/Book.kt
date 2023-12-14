package com.D121211052.libraryapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Book (
    val title: String?,
    val authors: List<String?>,
    val publisher: String? = null,
    val publishedDate: String? = null,
    val description: String? = null,
    val pageCount: Int? = null,
    val previewLink: String? = null,
    val imageLinks: ImageLink? = null,
): Parcelable {
    @Parcelize
    @Serializable
    data class ImageLink(
        val smallThumbnail: String?,
        val thumbnail: String?
    ): Parcelable
}