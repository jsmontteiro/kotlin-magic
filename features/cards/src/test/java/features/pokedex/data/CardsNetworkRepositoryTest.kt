package features.pokedex.data

import br.com.montteiro.testutils.enqueueResponse
import br.com.montteiro.testutils.loadJsonFromResources
import features.cards.data.network.CardsApi
import features.cards.data.network.CardsNetworkRepository
import features.cards.data.network.schemas.ListCardResponse
import kotlinx.coroutines.runBlocking
import libraries.common.mapTo
import libraries.network.ApiClientBuilder
import libraries.network.exceptions.ServerErrorException
import libraries.network.fromJson
import libraries.network.gsonDefault
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test


class CardsNetworkRepositoryTest {

    private val server = MockWebServer()

    private lateinit var api: CardsApi

    private lateinit var repo: CardsNetworkRepository

    @Before
    fun setup() {
        server.start()
        val url = server.url("").toString()

        api = ApiClientBuilder.createServiceApi(CardsApi::class.java, url)
        repo = CardsNetworkRepository(api)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `listCards with sucess`() = runBlocking {
        //assert
        val jsonResponse = loadJsonFromResources("listCards.json")
        server.enqueueResponse(200, jsonResponse)

        //act
        val response = repo.listCards()

        //assert
        val expectedResponse = gsonDefault.fromJson<ListCardResponse>(jsonResponse).cards.mapTo()
        assertEquals(expectedResponse, response)
    }

    @Test(expected = ServerErrorException::class)
    fun `api return 500 throw ServerErrorException`() = runBlocking {
        server.enqueueResponse(500, "")
        repo.listCards()
        fail()
    }
}