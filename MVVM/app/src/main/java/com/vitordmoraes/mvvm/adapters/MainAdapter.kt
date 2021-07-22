package com.vitordmoraes.mvvm.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vitordmoraes.mvvm.R
import com.vitordmoraes.mvvm.databinding.ResItemLiveBinding
import com.vitordmoraes.mvvm.model.Live


class MainAdapter(private val onItemClicked: (Live) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var lives = mutableListOf<Live>()

    fun setLivesList(lives: List<Live>) {
        this.lives = lives.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemLiveBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = lives.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val live = lives[position]
        holder.bind(live, onItemClicked)

    }

    class ViewHolder(val binding: ResItemLiveBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(live: Live, onItemClicked: (Live) -> Unit) {

            binding.title.text = live.title
            binding.author.text = live.author

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(live.thumbnailUrl)
                .into(binding.thumbnail)

            itemView.setOnClickListener {
                onItemClicked(live)
            }
        }

    }
}