package features.pokedex.usecase

import features.cards.data.CardsRepository
import features.cards.usecase.ListCardsUseCase
import features.pokedex.mockCard
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import libraries.network.exceptions.MyNetworkException
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

class ListCardsUseCaseTest {

    @MockK
    private lateinit var repo: CardsRepository

    private lateinit var useCase: ListCardsUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = ListCardsUseCase(repo)
    }

    @Test
    fun `run with sucess`() {
        runBlocking {
            //arrange
            val expectedResponse = listOf(mockCard())
            coEvery { repo.listCards() } returns expectedResponse

            //act
            val response = useCase.execute()

            //assert
            assertEquals(expectedResponse, response)
        }
    }

    @Test(expected = MyNetworkException::class)
    fun `run with error throws exception from repository MyNetworkException`() {
        runBlocking {
            //arrange
            coEvery { repo.listCards() } throws MyNetworkException()

            //act
            val response = useCase.execute()

            //assert
            fail()
        }
    }
}