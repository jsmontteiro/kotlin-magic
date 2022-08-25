package features.cards.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import features.cards.databinding.CardsListCardBinding
import features.cards.model.Card

internal class CardAdapter : ListAdapter<Card, CardAdapter.ViewHolder>(DIFF_UTIL) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private lateinit var binding: CardsListCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = CardsListCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = getItem(position)

        with(view) {
            //binding.imgCard
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