package com.D121211052.libraryapp.data.response

import android.os.Parcelable
import com.D121211052.libraryapp.data.models.Book
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetBooksResponse(
    @SerialName("kind")
    val kind: String,
    @SerialName("totalItems")
    val totalItems: Int,
    @SerialName("items")
    val items: List<Item?>,
) {
    @Serializable
    data class Item(
        @SerialName("id")
        val id: String?,
        @SerialName("volumeInfo")
        val volumeInfo: Book
    )
}
