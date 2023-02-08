package com.example.kosthub.ui.pemilik.tambahkost

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.kosthub.R
import com.example.kosthub.application.MainActivity
import com.example.kosthub.data.locale.raw.ListCheckableItem
import com.example.kosthub.data.remote.model.kostroom.request.AddKostRequest
import com.example.kosthub.databinding.FragmentPemilikHomeBinding
import com.example.kosthub.databinding.FragmentPemilikTambahKostBinding
import com.example.kosthub.ui.pemilik.CheckboxAdapter
import com.example.kosthub.utils.Const
import com.example.kosthub.utils.ImageConverter
import com.example.kosthub.utils.KostType
import com.example.kosthub.utils.worker.BlurWorker
import com.example.kosthub.utils.worker.uriToFile

class PemilikTambahKostFragment : Fragment() {

    private var _binding: FragmentPemilikTambahKostBinding? = null
    private val binding get() = _binding!!

    private lateinit var workManager: WorkManager

    private lateinit var imageHolder: ImageView

    private var kostType: KostType? = null

    private val listRules = mutableListOf<Int>()
    private val listFacility = mutableListOf<Int>()
    private val listPayment = mutableListOf<Int>()

    private var outsideImage: String? = null
    private var insideImage: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).hideNavbar()
        _binding = FragmentPemilikTambahKostBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isNew = PemilikTambahKostFragmentArgs.fromBundle(arguments as Bundle).isNew

        workManager = WorkManager.getInstance(requireContext())

        if (!isNew) {
            binding.apply {
                tvAppbar.text = "Edit Kost"
                //TODO: Pre-filled text field
            }
        } else {
            binding.apply {
                tvAppbar.text = "Tambah Kost"
            }
        }

        binding.apply {
            btnNext.setOnClickListener {
                val data = setUpData()
                val toLocation = PemilikTambahKostFragmentDirections.actionPemilikTambahKostFragmentToPemilikTambahKostLocationFragment(isNew, data)
                findNavController().navigate(toLocation)
            }
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
            imgInside.setOnClickListener {
                imageHolder = imgInside
                openGallery()
            }
            imgOutside.setOnClickListener {
                imageHolder = imgOutside
                openGallery()
            }
            chipPutra.setOnClickListener {
                chipClicked(it as CardView)
            }
            chipPutra.setOnClickListener {
                chipClicked(it as CardView)
            }
            chipCampur.setOnClickListener {
                chipClicked(it as CardView)
            }
        }

        showRvKostRules()
        showRvKostFacility()
        showRvPaymentScheme()
    }

    private fun setUpData(): AddKostRequest {
        var res: AddKostRequest
        binding.apply {
            res = AddKostRequest(
                paymentScheme = listPayment,
                address = null,
                additionalRule = edtAdditionalRules.text.toString(),
                city = null,
                latitude = null,
                description = edtDescription.text.toString(),
                rules = listRules,
                type = kostType.toString(),
                outdoorPhoto = outsideImage,
                province = null,
                district = null,
                name = edtName.text.toString(),
                indoorPhoto = insideImage,
                id = null,
                adressNote = null,
                longitude = null
            )
        }
        return res
    }

    private fun chipClicked(view: CardView) {
        binding.apply {
            chipUnselected(llCampur, tvCampur)
            chipUnselected(llPutra, tvPutra)
            chipUnselected(llPutri, tvPutri)
            kostType = when (view) {
                chipPutra -> {
                    chipSelected(llPutra, tvPutra)
                    KostType.PUTRA
                }
                chipPutri -> {
                    chipSelected(llPutri, tvPutri)
                    KostType.PUTRI
                }
                else -> {
                    chipSelected(llCampur, tvCampur)
                    KostType.CAMPURAN
                }
            }

        }
    }

    private fun chipSelected(view: LinearLayout, text: TextView) {
        view.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        text.setTextColor(resources.getColor(R.color.white))
    }

    private fun chipUnselected(view: LinearLayout, text: TextView) {
        view.setBackgroundColor(resources.getColor(R.color.white))
        text.setTextColor(resources.getColor(R.color.black))
    }

    private fun showRvKostRules() {
        binding.rvKostRules.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.peraturanKost,
                onClick = { id, checked ->

                }
            )
        }
    }

    private fun showRvKostFacility() {
        binding.rvFacility.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.fasilitasKost,
                onClick = { id, checked ->

                }
            )
        }
    }

    private fun showRvPaymentScheme() {
        binding.rvPaymentScheme.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = CheckboxAdapter(
                listCheckbox = ListCheckableItem.skemaPembayaran,
                onClick = { id, checked ->

                }
            )
        }
    }

    private val imageResult = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val image = it?.let { it1 ->
            uriToFile(it1, requireContext())
        }

        imageHolder.setImageURI(it)

        if (imageHolder == binding.imgInside) {
            insideImage = image?.let { it1 -> ImageConverter.imageToBase64(it1) }
        }

        if (imageHolder == binding.imgOutside) {
            outsideImage = image?.let { it1 -> ImageConverter.imageToBase64(it1) }
        }

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