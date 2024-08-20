package com.hfad.musicapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hfad.musicapp.Music
import com.hfad.musicapp.databinding.ItemMusicBinding

class MusicAdapter : ListAdapter<Music, MusicViewHolder>(MusicDiffCallback) {

    var onMusicClickListener: OnMusicClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = ItemMusicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = getItem(position)
        with(holder.binding){
            with(music){
                title.text = name
                holder.itemView.setOnClickListener {
                    onMusicClickListener?.onMusicClick(this)
                }
            }
        }
    }

    interface OnMusicClickListener{
        fun onMusicClick(music: Music)
    }
}


