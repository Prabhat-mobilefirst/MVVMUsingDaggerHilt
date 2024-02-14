package com.example.mvvmusingdaggerhilt.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mvvmusingdaggerhilt.R
import com.example.mvvmusingdaggerhilt.databinding.FragmentNumberBinding
import com.example.mvvmusingdaggerhilt.hilt.ZomatoModule
import com.example.mvvmusingdaggerhilt.local.NumberViewModel
import com.example.mvvmusingdaggerhilt.local.ZomatoRepo
import com.example.mvvmusingdaggerhilt.local.zomatoViewModel
import com.example.mvvmusingdaggerhilt.remote.retrofit.ZomatoApi
import com.example.mvvmusingdaggerhilt.util.Status
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NumberFragment : Fragment() {
    lateinit var binding: FragmentNumberBinding
    //by delegate viewmodel
    val viewModel:NumberViewModel by viewModels()
    val zomatoViewModel:zomatoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentNumberBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        zomatoViewModel.getZomato()
        zomatoViewModel.zomato.observe(viewLifecycleOwner){
            Log.d("PRABHAT", "onViewCreated: zomato")

            when (it?.getContentIfNotHandled()?.status){

                Status.SUCCESS->{

//                    binding.progressBar.visibility=View.INVISIBLE
                    Log.d("PRABHAT", "onViewCreated: ${it.peekContent().data}")
//                    binding.numberTxt.text=it.peekContent().data?.text

                }
                Status.LOADING->{

//                    binding.progressBar.visibility=View.VISIBLE

                }
                Status.ERROR->{
//                    binding.progressBar.visibility=View.INVISIBLE

                }

                else -> {
                    Toast.makeText(requireContext(), "else", Toast.LENGTH_SHORT).show()
                }
            }
        }




        binding.fetchData.setOnClickListener {
            val number=binding.numberEt.text.toString().trim().toInt()
            viewModel.getNumberFact(number)


        }
        viewModel.fact.observe(viewLifecycleOwner){
            when (it?.getContentIfNotHandled()?.status){

                Status.SUCCESS->{
                    binding.progressBar.visibility=View.GONE
                    binding.numberTxt.text=it.peekContent().data?.text

                }
                Status.LOADING->{

                    binding.progressBar.visibility=View.VISIBLE

                }
                Status.ERROR->{
                    binding.progressBar.visibility=View.GONE

                }

                else -> {
                    Toast.makeText(requireContext(), "else", Toast.LENGTH_SHORT).show()
                }
            }


        }

    }

    companion object {

    }
}