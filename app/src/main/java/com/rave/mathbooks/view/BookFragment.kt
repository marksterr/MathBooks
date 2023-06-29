package com.rave.mathbooks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rave.mathbooks.databinding.FragmentBookBinding
import com.rave.mathbooks.viewmodel.MathViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [BookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class BookFragment : Fragment() {

    private var _binding: FragmentBookBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MathViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentBookBinding.inflate(inflater, container, false).apply {
            _binding = this
            val adapter = BookAdapter()
            viewModel.books.observe(
                viewLifecycleOwner,
                Observer {
                    adapter.setData(it)
                }
            )
            binding.rvBooks.adapter = adapter
            binding.rvBooks.layoutManager = LinearLayoutManager(requireContext())
        }.root
    }
}
