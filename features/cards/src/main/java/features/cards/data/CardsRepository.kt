package features.cards.data

import features.cards.model.Card

internal interface CardsRepository {
    suspend fun listCards(): List<Card>
}