package com.example.recyclerviewtask

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtask.databinding.ActivityMainBinding.inflate
import com.example.recyclerviewtask.databinding.PatternBinding.inflate
import com.example.recyclerviewtask.databinding.RecyclerViewFragmentBinding


class RecyclerViewFragment : Fragment() {

    companion object {
        fun newInstance() = RecyclerViewFragment()
    }


    private lateinit var viewModel: RecyclerViewViewModel

    private lateinit var adapter: PhotoAdapter

    private lateinit var photoIdList: MutableList<Int>
    private var index = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {


        viewModel = ViewModelProvider(this).get(RecyclerViewViewModel::class.java)

        viewModel.photoIdList.observe(viewLifecycleOwner, Observer { newPhotoIdList -> photoIdList = newPhotoIdList })
        viewModel.adapter.observe(viewLifecycleOwner, Observer { newAdapter -> adapter = newAdapter })
        viewModel.index.observe(viewLifecycleOwner, Observer { newIndex -> index = newIndex })

        return inflater.inflate(R.layout.recycler_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        val button: Button = requireView().findViewById(R.id.button)
    recyclerView.layoutManager = LinearLayoutManager(activity)
    recyclerView.adapter = adapter
    button.setOnClickListener{onClickAddPhoto()}
    }



    private fun onClickAddPhoto(){
        if(index > 3) index = 0
        val photo = Photo(photoIdList[index], "Photo Description")
        adapter.addPhoto(photo)
        index++
    }
}