package project.mykolaonyshchuk.chisoftwaretesttask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fragmentCloseButton:MaterialButton
    private lateinit var nameColumnDetailsTextView: TextView
    private lateinit var nameDetailsTextView: TextView
    private lateinit var ageColumnDetailsTextView: TextView
    private lateinit var ageDetailsTextView: TextView
    private lateinit var isStudentDetailsTextView: TextView

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
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val parcelableUser: User? = bundle?.getParcelable("user")

        fragmentCloseButton = view.findViewById(R.id.fragment_close_button)
        nameColumnDetailsTextView = view.findViewById(R.id.name_column_details_textview)
        nameDetailsTextView = view.findViewById(R.id.name_details_textview)
        ageColumnDetailsTextView = view.findViewById(R.id.age_column_details_textview)
        ageDetailsTextView = view.findViewById(R.id.age_details_textview)
        isStudentDetailsTextView = view.findViewById(R.id.is_student_details_textview)

        if (parcelableUser != null) {
            nameDetailsTextView.text = parcelableUser.name
            ageDetailsTextView.text = "${parcelableUser.age} years"
            if (parcelableUser.isStudent) {
                isStudentDetailsTextView.text = "${parcelableUser.name} is a student"
            } else {
                isStudentDetailsTextView.text = "${parcelableUser.name} is a not student"
            }
        }

        fragmentCloseButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.3t
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}