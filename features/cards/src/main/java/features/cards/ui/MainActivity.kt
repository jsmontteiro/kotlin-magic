package features.cards.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import features.cards.databinding.CardsActivityMainBinding
import features.cards.ui.adapter.CardsAdapter
import libraries.ui_components.extensions.createLoadingDialog
import libraries.ui_components.extensions.showMessage
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val cardsAdapter = CardsAdapter()
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: CardsActivityMainBinding

    private val loadingDialog by lazy {
        createLoadingDialog()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CardsActivityMainBinding.inflate(layoutInflater)

        setupView()
        setupObservers()

        viewModel.init()
    }

    private fun setupView() {
        binding.rvCards.adapter = cardsAdapter
    }

    private fun setupObservers() {
        viewModel.cards.observe(this) {
            cardsAdapter.submitList(it)
        }

        viewModel.showError.observe(this, Observer { showMessage(it) })

        viewModel.isLoading.observe(this, Observer {
            if (it == true) {
                loadingDialog.show()
            } else {
                loadingDialog.hide()
            }
        })
    }

}