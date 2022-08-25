package features.cards.data.network.schemas

import com.google.gson.annotations.SerializedName

internal class CardSchema(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("id")
    val id: Int
)