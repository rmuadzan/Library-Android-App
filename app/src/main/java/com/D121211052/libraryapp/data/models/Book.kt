package com.D121211052.libraryapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Book (
    val title: String?,
    val authors: List<String?>,
//    val publisher: String?,
//    val publishedDate: String?,
//    val description: String?,
//    val pageCount: Int?,
    val previewLink: String?,
    val imageLinks: ImageLink?,
): Parcelable {
    @Parcelize
    @Serializable
    data class ImageLink(
        val smallThumbnail: String?,
        val thumbnail: String?
    ): Parcelable
}