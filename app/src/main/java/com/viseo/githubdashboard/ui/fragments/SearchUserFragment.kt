package com.viseo.githubdashboard.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viseo.githubdashboard.R

private const val ARG_PARAM_KEY = "arg_param"

class SearchUserFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance(param: String): SearchUserFragment =
            SearchUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_KEY, param)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_user, container, false)
    }


}
