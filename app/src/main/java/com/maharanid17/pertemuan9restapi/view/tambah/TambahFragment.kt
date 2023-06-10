package com.maharanid17.pertemuan9restapi.view.tambah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.maharanid17.pertemuan9restapi.R
import com.maharanid17.pertemuan9restapi.databinding.FragmentTambahBinding
import com.maharanid17.pertemuan9restapi.viewmodel.ViewModelMahasiswa

class TambahFragment : Fragment() {
    lateinit var binding : FragmentTambahBinding
    lateinit var viewModel : ViewModelMahasiswa
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTambahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        binding.btnTambah.setOnClickListener{
            val nim = binding.inputNim.text.toString()
            val nama = binding.inputNama.text.toString()
            val telepon = binding.inputTelepon.text.toString()
            viewModel.insertMahasiswa().observe(viewLifecycleOwner){
                if (it != null){
                    Toast.makeText(context, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }else{
                    Toast.makeText(context, "Data Gagal Ditambahkan", Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.addMahasiswa(nim, nama, telepon)
        }
        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}