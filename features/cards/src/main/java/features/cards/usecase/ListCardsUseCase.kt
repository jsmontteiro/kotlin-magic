package features.cards.usecase

import features.cards.data.CardsRepository
import features.cards.model.Card

internal class ListCardsUseCase(private val repo: CardsRepository) {
    suspend fun execute():List<Card> {
        return repo.listCards()
    }
}