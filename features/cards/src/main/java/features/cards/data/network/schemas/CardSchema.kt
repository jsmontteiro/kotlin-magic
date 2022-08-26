package features.cards.data.network.schemas

import com.google.gson.annotations.SerializedName
import features.cards.model.Card
import libraries.common.MapTo

internal class CardSchema(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
): MapTo<Card> {
    override fun mapTo() = Card(
        id = id,
        imageUrl = imageUrl,
        name = name
    )
}