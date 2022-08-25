package features.cards.ui

import androidx.lifecycle.LiveData
import features.cards.model.Card
import features.cards.usecase.ListCardUseCase
import libraries.ui_components.BaseViewModel
import libraries.ui_components.SingleLiveEvent

internal class MainViewModel(private val listCardsUseCase: ListCardUseCase) : BaseViewModel() {

    private val _cards = SingleLiveEvent<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    fun init() {
        doAsyncWork {
            _cards.value = listCardsUseCase.execute()
        }
    }
}