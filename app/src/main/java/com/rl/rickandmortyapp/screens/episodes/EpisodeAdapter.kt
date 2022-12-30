package com.rl.rickandmortyapp.screens.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rl.rickandmortyapp.databinding.ListItemEpisodeBinding
import com.rl.rickandmortyapp.domain.Episode


class EpisodeAdapter : ListAdapter<Episode, EpisodeAdapter.ViewHolder>(
    EpisodeDiffCallback()) {
    // inflate the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate by using the from function (singleton companion object) in de ViewHolder class
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        //bind all values using the bind method from the ViewHolder class
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //compantion object => function can be called on the class, not an instance
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                // inflate and return binding
                val binding =
                    ListItemEpisodeBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(item: com.rl.rickandmortyapp.domain.Episode) {
            binding.episode = item
            binding.executePendingBindings()
        }

    }

    class EpisodeDiffCallback :
        DiffUtil.ItemCallback<com.rl.rickandmortyapp.domain.Episode>() {
        override fun areItemsTheSame(
            oldItem: com.rl.rickandmortyapp.domain.Episode,
            newItem: com.rl.rickandmortyapp.domain.Episode
        ): Boolean {
            return oldItem.episodeId == newItem.episodeId
        }

        override fun areContentsTheSame(
            oldItem: com.rl.rickandmortyapp.domain.Episode,
            newItem: com.rl.rickandmortyapp.domain.Episode
        ): Boolean {
            return oldItem == newItem
        }
    }
}