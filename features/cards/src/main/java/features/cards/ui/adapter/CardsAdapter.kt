package features.cards.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import features.cards.databinding.CardsItemCardBinding
import features.cards.model.Card
import libraries.common.extensions.loadImage

internal class CardsAdapter : ListAdapter<Card, CardsAdapter.ViewHolder>(DIFF_UTIL) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private lateinit var binding: CardsItemCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = CardsItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = getItem(position)
        with(holder.itemView) {
            binding.cardsTvName.text = card.id
            binding.cardsImageview.loadImage(card.imageUrl)
        }
    }
}

private object DIFF_UTIL : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

}