package com.rave.mathbooks.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rave.mathbooks.databinding.ItemBookBinding
import com.rave.mathbooks.model.local.Book

/**
 * Book adapter.
 *
 * @constructor Create empty Book adapter
 */
class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var bookList: List<Book> = emptyList()

    /**
     * Book view holder.
     *
     * @property binding
     * @constructor Create empty Book view holder
     */
    inner class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Display book.
         *
         * @param book
         */
        fun displayBook(book: Book) = with(binding) {
            tvBook.text = book.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookViewHolder(
            ItemBookBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.displayBook(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    /**
     * Set data.
     *
     * @param books
     */
    fun setData(books: List<Book>) {
        this.bookList = books
        notifyDataSetChanged()
    }
}
