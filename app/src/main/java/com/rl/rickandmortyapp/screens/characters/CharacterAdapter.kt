package com.rl.rickandmortyapp.screens.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rl.rickandmortyapp.databinding.ListItemCharacterBinding

class CharacterAdapter :
    ListAdapter<com.rl.rickandmortyapp.database.Character, CharacterAdapter.ViewHolder>(CharacterDiffCallback()) {
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

    class ViewHolder private constructor(val binding: ListItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //compantion object => function can be called on the class, not an instance
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                // inflate and return binding
                val binding =
                    ListItemCharacterBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(item: com.rl.rickandmortyapp.database.Character) {
            binding.character = item
            binding.executePendingBindings()
        }

    }

    class CharacterDiffCallback :
        DiffUtil.ItemCallback<com.rl.rickandmortyapp.database.Character>() {
        override fun areItemsTheSame(
            oldItem: com.rl.rickandmortyapp.database.Character,
            newItem: com.rl.rickandmortyapp.database.Character
        ): Boolean {
            return oldItem.characterId == newItem.characterId
        }

        override fun areContentsTheSame(
            oldItem: com.rl.rickandmortyapp.database.Character,
            newItem: com.rl.rickandmortyapp.database.Character
        ): Boolean {
            return oldItem == newItem
        }
    }

}