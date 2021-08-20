package com.asterisk.gallerywayapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.asterisk.gallerywayapp.R
import com.asterisk.gallerywayapp.data.model.Result
import com.asterisk.gallerywayapp.databinding.ItemUnsplashPhotoBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class UnSplashPhotoAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<Result, UnSplashPhotoAdapter.PhotoViewHolder>(
        PHOTO_COMPARATOR
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }

            }
        }

        fun bind(photo: Result) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                textViewImageName.text = photo.user.username
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(photo: Result)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem

        }
    }

}