package com.jeff_skillrill.marks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeff_skillrill.marks.adapters.Bakholar_Adapter
import com.jeff_skillrill.marks.adapters.Marks_List
import com.jeff_skillrill.marks.database.AppDataBase
import com.jeff_skillrill.marks.databinding.FragmentStudentsPageBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Students_Page : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val appDataBase: AppDataBase by lazy{
        AppDataBase.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStudentsPageBinding.inflate(layoutInflater, container, false)
        var mutableList = mutableListOf<Marks_List>()
        mutableList.add(Marks_List("Maths",20,24,3,56))
        var adapter = Bakholar_Adapter(mutableList)
        binding.rv.setAdapter(adapter)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Students_Page().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}