package com.example.tolong_aku

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonClick: ImageButton = view.findViewById(R.id.button1)
        buttonClick.setOnClickListener(this)

        val buttonClick2: ImageButton = view.findViewById((R.id.button2))
        buttonClick2.setOnClickListener(this)

        val buttonClick3: ImageButton = view.findViewById((R.id.button3))
        buttonClick2.setOnClickListener(this)

        val buttonClick4: ImageButton = view.findViewById((R.id.button4))
        buttonClick2.setOnClickListener(this)

        val buttonClick5: ImageButton = view.findViewById((R.id.button5))
        buttonClick2.setOnClickListener(this)

        val buttonClick6: ImageButton = view.findViewById((R.id.button6))
        buttonClick2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null){
            when (v.id) {
                R.id.button1 -> {
                    val phoneNumber = "911"
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data =  Uri.parse("tel:$phoneNumber")
                    startActivity(intent)
                }
                R.id.button2 -> {
                    val moveIntent = Intent(this.requireActivity(),Polisi::class.java)
                    startActivity(moveIntent)
                }
                R.id.button3 -> {
                    val moveIntent = Intent(this.requireActivity(),Rumah_sakit::class.java)
                    startActivity(moveIntent)
                }
                R.id.button4 -> {
                    val moveIntent = Intent(this.requireActivity(),Pemadam::class.java)
                    startActivity(moveIntent)
                }
                R.id.button5 -> {
                    val moveIntent = Intent(this.requireActivity(),Ambulance::class.java)
                    startActivity(moveIntent)
                }
                R.id.button6 -> {
                    val moveIntent = Intent(this.requireActivity(),Tim_sar::class.java)
                    startActivity(moveIntent)
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Homee.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}