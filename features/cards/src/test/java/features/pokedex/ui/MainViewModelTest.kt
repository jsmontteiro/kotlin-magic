package features.pokedex.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.montteiro.testutils.CoroutineTestRule
import features.cards.ui.MainViewModel
import features.cards.usecase.ListCardsUseCase
import features.pokedex.mockCard
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import libraries.network.exceptions.ServerErrorException
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @Rule
    @JvmField
    val coroutineTestRule = CoroutineTestRule()

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: ListCardsUseCase = spyk(ListCardsUseCase(mockk()))

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel(useCase)
    }

    @Test
    fun `init with success, set initialized true and fill cards correctly`() {
        //arrange
        val cards = listOf(mockCard())
        coEvery { useCase.execute() } returns cards

        //act
        viewModel.init()

        //assert
        assert(viewModel.isInitialized)
        assertEquals(cards, viewModel.cards.value)
    }

    @Test
    fun `init with error from usecase, let initialized as false and NOT fill cards`() {
        //arrange
        coEvery { useCase.execute() } throws ServerErrorException()

        //act
        viewModel.init()

        //assert
        assertEquals(false, viewModel.isInitialized)
        assert(viewModel.cards.value.isNullOrEmpty())
    }
}