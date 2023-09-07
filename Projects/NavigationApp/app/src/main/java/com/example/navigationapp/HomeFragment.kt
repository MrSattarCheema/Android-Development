package com.example.navigationapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Initializing binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        //checking if the textInput is not empty

            binding.button.setOnClickListener(){
                if(!TextUtils.isEmpty(binding.editText.text.toString())){
                    //making a val for storing the inputName in form a key value pair to pass to 2nd fragment
                    val bundle = bundleOf("name" to binding.editText.text.toString())
                    //adding btn to go to next fragment and also send name to second fragment
                    it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment,bundle)
                }
                else{
                    Toast.makeText(activity,"Pls Enter Name", Toast.LENGTH_SHORT).show()
                }
               
            }


        return binding.root
    }


}