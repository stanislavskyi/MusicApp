package com.hfad.musicapp

import android.os.Bundle
import android.util.Log
import android.util.TimeUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.musicapp.adapter.MusicAdapter
import com.hfad.musicapp.databinding.FragmentHomeBinding
import java.time.LocalTime


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MusicAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = MusicAdapter()
        binding.recyclerView.adapter = adapter
        val list = mutableListOf<Music>()


        binding.floatingActionButton.setOnClickListener{
            list.add(Music(LocalTime.now().toString()))
            Log.d("HomeFragment", "$list")
            // Передаем новую копию списка в адаптер
            adapter.submitList(list.toList())
        }

        adapter.onMusicClickListener = object :MusicAdapter.OnMusicClickListener{
            override fun onMusicClick(music: Music) {
                Toast.makeText(requireActivity(), "$music", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

    }
}