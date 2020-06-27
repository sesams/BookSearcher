package com.ks.booksearcher.extension

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.ks.booksearcher.R

fun AppCompatActivity.hideKeyboard() {
    val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

fun FragmentActivity.startFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment, fragment, this::class.simpleName)
        .addToBackStack(null)
        .commit()
}

fun Fragment.hideKeyboard() {
    val manager =
        requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    manager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
}