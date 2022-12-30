package com.rl.rickandmortyapp.screens.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rl.rickandmortyapp.databinding.ListItemLocationBinding
import com.rl.rickandmortyapp.domain.Location


class LocationAdapter :
    ListAdapter<Location, LocationAdapter.ViewHolder>(
        LocationDiffCallback()
    ) {
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

    class ViewHolder private constructor(val binding: ListItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //compantion object => function can be called on the class, not an instance
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                // inflate and return binding
                val binding =
                    ListItemLocationBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(item: com.rl.rickandmortyapp.domain.Location) {
            binding.location = item
            binding.executePendingBindings()
        }

    }

    class LocationDiffCallback :
        DiffUtil.ItemCallback<com.rl.rickandmortyapp.domain.Location>() {
        override fun areItemsTheSame(
            oldItem: com.rl.rickandmortyapp.domain.Location,
            newItem: com.rl.rickandmortyapp.domain.Location
        ): Boolean {
            return oldItem.locationId == newItem.locationId
        }

        override fun areContentsTheSame(
            oldItem: com.rl.rickandmortyapp.domain.Location,
            newItem: com.rl.rickandmortyapp.domain.Location
        ): Boolean {
            return oldItem == newItem
        }
    }

}