package com.example.fitness.ui.ui.add

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentAddBinding
import com.example.fitness.models.Group
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.UUID

@AndroidEntryPoint
class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private var imgUri: Uri? = null
    private val viewModel :AddViewModel by viewModels()
    lateinit var firebaseAuth:FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root
        firebaseAuth =FirebaseAuth.getInstance()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            getImage()
        binding.btnUpload.setOnClickListener {
        lifecycleScope.launch {
            upload()
        }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private suspend fun upload(){
       val group = Group(name = binding.EditTextGroupName.text.toString(),
           description =binding.editTextDescription.text.toString(),
           type = binding.SpinnerGroupType.selectedItem.toString(),
           id = UUID.randomUUID().toString()
        )

        viewModel.upload(group,imgUri!!)
        viewModel.stateGroup.collectLatest {
            binding.progress.isVisible = it.isLoading
            if (it.success!=null){
                Toast.makeText(requireContext(), it.success, Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_navigation_add_to_navigation_home)
            }



       }
    }
    private fun getImage(){
        val loadFile = registerForActivityResult(ActivityResultContracts.GetContent()) {
            if (it != null) {
                imgUri = it
                Glide.with(requireContext()).asBitmap().load(it).into(binding.imgGroup)
            }

        }

        binding.imgGroup.setOnClickListener {
            loadFile.launch("image/*")
        }
    }
}