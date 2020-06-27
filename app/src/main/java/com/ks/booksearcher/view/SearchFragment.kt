package com.ks.booksearcher.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ks.booksearcher.R
import com.ks.booksearcher.extension.hideKeyboard
import com.ks.booksearcher.extension.startFragment
import com.ks.booksearcher.view.adapter.BooksAdapter
import com.ks.booksearcher.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_books.*


class SearchFragment : Fragment() {

    companion object {
        const val KEYWORD = "keyword"
    }

    private val viewModel: BookViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val keyword = savedInstanceState?.getString(KEYWORD) ?: ""

        if (keyword.isNotBlank())
            viewModel.search(keyword)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        input.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                requestSearch()
                true
            } else {
                false
            }
        }

        input.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                requestSearch()
                true
            } else {
                false
            }
        }

        val adapter = BooksAdapter().apply {
            recyclerView.adapter = this
            listener = { url: String ->
                startDetailFragment(url)
            }
        }

        viewModel.result.observe(requireActivity(), Observer {
            adapter.submitList(it)
        })
    }

    private fun requestSearch() {
        input.text.trim().toString().let {
            if (it.isNotEmpty()) {
                if (viewModel.search(it)) {
                    recyclerView.scrollToPosition(0)
                    (recyclerView.adapter as BooksAdapter).submitList(null)
                }
            }
        }

        hideKeyboard()
    }

    private fun startDetailFragment(url: String) {
        val detail = DetailFragment().apply {
            arguments = bundleOf("url" to url)
        }

        requireActivity().startFragment(detail)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEYWORD, viewModel.getKeyword())
    }
}