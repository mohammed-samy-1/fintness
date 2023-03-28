package com.example.fitness.ui.ui.add

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.fitness.databinding.FragmentAddBinding
import com.example.fitness.models.Group
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private var imgUri: Uri? = null
    val viewModel :AddViewModel by viewModels()
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

   suspend fun upload(){
       val group = Group(name = binding.EditTextGroupName.text.toString(),
           description =binding.editTextDescription.text.toString(),
           type = binding.SpinnerGroupType.selectedItem.toString(),


        )

        viewModel.upload(group,imgUri!!)
        viewModel.stateGroup.collectLatest {
           Toast.makeText(requireContext(), it.success, Toast.LENGTH_SHORT).show()

       }
    }
    fun getImage(){
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