package com.hfad.musicapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hfad.musicapp.Music

object MusicDiffCallback : DiffUtil.ItemCallback<Music>() {
    override fun areItemsTheSame(oldItem: Music, newItem: Music) = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Music, newItem: Music) = oldItem == newItem
}