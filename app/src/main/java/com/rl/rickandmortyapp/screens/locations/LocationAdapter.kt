package com.rl.rickandmortyapp.screens.locations

import android.view.LayoutInflater
import android.view.View
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
    /**
     * On creation of the viewholder we inflate by using the from function (singleton companion object) in the ViewHolder class
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    /**
     * On the bind of the viewholder we bind all values using the bind method from the viewholder class
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.clickableField.setOnClickListener {
            if (holder.binding.extraInfo.visibility == View.GONE) {
                holder.binding.extraInfo.visibility = View.VISIBLE
            } else {
                holder.binding.extraInfo.visibility = View.GONE
            }
        }
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Companion object function can be called on the class, not an instance
         */
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                // inflate and return binding
                val binding =
                    ListItemLocationBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        /**
         * The bind function that binds the elements
         */
        fun bind(item: com.rl.rickandmortyapp.domain.Location) {
            binding.location = item
            binding.executePendingBindings()
        }

    }

    class LocationDiffCallback :
        DiffUtil.ItemCallback<com.rl.rickandmortyapp.domain.Location>() {
        /**
         * Function to check if the provided items are the same or not
         */
        override fun areItemsTheSame(
            oldItem: com.rl.rickandmortyapp.domain.Location,
            newItem: com.rl.rickandmortyapp.domain.Location
        ): Boolean {
            return oldItem.locationId == newItem.locationId
        }
        /**
         * Function to check if the content of the items is the same or not
         */
        override fun areContentsTheSame(
            oldItem: com.rl.rickandmortyapp.domain.Location,
            newItem: com.rl.rickandmortyapp.domain.Location
        ): Boolean {
            return oldItem == newItem
        }
    }

}