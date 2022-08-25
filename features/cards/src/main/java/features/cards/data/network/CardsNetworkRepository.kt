package features.cards.data.network

import features.cards.data.CardsRepository
import features.cards.model.Card
import libraries.network.RequestManager

internal class CardsNetworkRepository(private val api: CardsApi) : CardsRepository {
    override suspend fun listCards(): List<Card> {
        val apiResponse = RequestManager.requestFromApi { api.listCards() }
        val cards = apiResponse?.cards?.map {
            Card(
                id = it.id,
                imageUrl = it.imageUrl
            )
        }
        return cards ?: emptyList()
    }
}