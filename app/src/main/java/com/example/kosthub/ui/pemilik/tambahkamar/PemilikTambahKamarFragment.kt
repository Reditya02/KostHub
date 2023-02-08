package com.example.kosthub.ui.pemilik.tambahkamar

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.kosthub.R
import com.example.kosthub.data.locale.raw.ListCheckableItem
import com.example.kosthub.databinding.FragmentPemilikTambahKamarBinding
import com.example.kosthub.ui.pemilik.CheckboxAdapter
import com.example.kosthub.ui.pemilik.successtambahkamar.PemilikSuccessTambahKamarFragment
import com.example.kosthub.ui.pemilik.successtambahkamar.PemilikSuccessTambahKamarFragmentArgs
import com.example.kosthub.utils.worker.BlurWorker
import com.example.kosthub.utils.worker.uriToFile

class PemilikTambahKamarFragment : Fragment() {
    private var _binding: FragmentPemilikTambahKamarBinding? = null
    private val binding get() = _binding!!

    private lateinit var workManager: WorkManager

    private lateinit var imageHolder: ImageView
    private var imageCount = 0

    private var additionalFeatureAdapter = AdditionalFeatureAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemilikTambahKamarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workManager = WorkManager.getInstance(requireContext())

        val isNew = PemilikSuccessTambahKamarFragmentArgs.fromBundle(arguments as Bundle).isNew

        binding.apply {
            if (!isNew) {
                tvAppbar.text = "Edit Kamar"
                btnNext.text = "Simpan"
            }

            llAdditionalFeature.visibility = View.GONE

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnAddPhoto.setOnClickListener {
                if (imageCount < 2) {
                    imageCount++
                    imageHolder = if (imageCount == 1) { img1 } else { img2 }
                    openGallery()
                }
            }

            img1.setOnClickListener {
                if (imageCount > 0) {
                    imageHolder = img1
                    openGallery()
                }
            }

            img2.setOnClickListener {
                if (imageCount > 1) {
                    imageHolder = img2
                    openGallery()
                }
            }

            tvAddFacility.setOnClickListener {
                additionalFeatureAdapter.addFacility()
            }

            swAdditionalFeature.setOnCheckedChangeListener { _, isChecked ->
                llAdditionalFeature.visibility = if (isChecked) View.VISIBLE else View.GONE
            }

            btnNext.setOnClickListener {
                val toSuccess = PemilikTambahKamarFragmentDirections.actionPemilikTambahKamarFragmentToPemilikSuccessTambahKamarFragment(isNew)
                findNavController().navigate(toSuccess)
            }
        }

        showRvRoomFacility()
        showRvAdditionalfacility()
        showRvBathroomFacility()
    }

    private fun showRvBathroomFacility() {
        binding.rvBathroomFacility.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.peraturanKost,
                onClick = { id, checked ->

                }
            )
        }
    }

    private fun showRvRoomFacility() {
        binding.rvRoomFacility.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.peraturanKost,
                onClick = { id, checked ->

                }
            )
        }
    }

    private fun showRvAdditionalfacility() {
        binding.rvAdditionalFacility.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = additionalFeatureAdapter
        }
    }

    private val imageResult = registerForActivityResult(ActivityResultContracts.GetContent()) {
        Log.d("Reditya", "${imageHolder.id} >> $imageCount")
        val image = it?.let { it1 ->
            uriToFile(it1, requireContext())
        }

        imageHolder.setImageURI(it)

        val data = Data.Builder()
            .putString("image", image?.path)
            .build()
        val workRequest = OneTimeWorkRequest
            .Builder(BlurWorker::class.java)
            .setInputData(data)
            .build()

        workManager.enqueue(workRequest)
        workManager.getWorkInfoByIdLiveData(workRequest.id).observe(viewLifecycleOwner) { workResult ->
            if (workResult.state.isFinished) {
                val result = workResult.outputData.keyValueMap["result"]
                result?.let {
                    imageHolder.setImageURI(result as Uri)
                }
            }
        }

    }

    private fun openGallery() {
        imageResult.launch("image/*")
    }
}