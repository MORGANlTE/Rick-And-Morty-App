package com.rl.rickandmortyapp.screens.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rl.rickandmortyapp.database.character.Character
import com.rl.rickandmortyapp.databinding.ListItemCharacterBinding

class CharacterAdapter :
    ListAdapter<Character, CharacterAdapter.ViewHolder>(CharacterDiffCallback()) {
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

        fun bind(item: Character) {
            binding.character = item
            binding.executePendingBindings()
        }

    }

    class CharacterDiffCallback :
        DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(
            oldItem: Character,
            newItem: Character
        ): Boolean {
            return oldItem.characterId == newItem.characterId
        }

        override fun areContentsTheSame(
            oldItem: Character,
            newItem: Character
        ): Boolean {
            return oldItem == newItem
        }
    }

}