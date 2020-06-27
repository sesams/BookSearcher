package com.ks.booksearcher.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ks.booksearcher.R
import com.ks.booksearcher.data.model.Book

class BooksAdapter : PagedListAdapter<Book, BooksAdapter.BookHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Book>() {
            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem.title == newItem.title
        }
    }

    var listener: ((url: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        return BookHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.title.text = getItem(position)!!.title
        holder.publisher.text = getItem(position)!!.publisher
        holder.contents.text = getItem(position)!!.contents
        holder.itemView.tag = getItem(position)!!.url
        Glide.with(holder.itemView).load(getItem(position)!!.thumbnail).into(holder.thumbnail)
    }

    inner class BookHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail: ImageView = view.findViewById(R.id.thumbnail)
        val title: TextView = view.findViewById(R.id.title)
        val publisher: TextView = view.findViewById(R.id.publisher)
        val contents: TextView = view.findViewById(R.id.contents)

        init {
            itemView.setOnClickListener {
                listener?.invoke(it.tag as String)
            }
        }
    }
}