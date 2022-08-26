package features.cards.ui

import androidx.lifecycle.LiveData
import features.cards.model.Card
import features.cards.usecase.ListCardsUseCase
import libraries.ui_components.BaseViewModel
import libraries.ui_components.SingleLiveEvent

internal class MainViewModel(private val listCardsUseCase: ListCardsUseCase) : BaseViewModel() {

    private val _cards = SingleLiveEvent<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    var isInitialized = false
        private set

    fun init() {
        if (!isInitialized) {
            doAsyncWork {
                _cards.value = listCardsUseCase.execute()
                isInitialized = true
            }
        }
    }
}