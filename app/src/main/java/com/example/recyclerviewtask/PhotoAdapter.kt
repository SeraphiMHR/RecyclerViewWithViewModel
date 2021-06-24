package com.example.recyclerviewtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtask.databinding.PatternBinding


class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private val photoList = mutableListOf<Photo>()

    class PhotoHolder(view: View): RecyclerView.ViewHolder(view) {


        private val binding = PatternBinding.bind(view)
        fun bind(photo: Photo) = with(binding){
            imageView.setImageResource(photo.photoId)
            textView.text = photo.photoName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pattern, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(photoList[position])
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun addPhoto(photo: Photo){
        photoList.add(photo)
        notifyDataSetChanged()
    }
}