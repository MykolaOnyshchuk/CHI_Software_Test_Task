package project.mykolaonyshchuk.chisoftwaretesttask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import java.time.LocalDateTime

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddUserFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var addUserFragmentCloseButton:MaterialButton
    private lateinit var nameColumnAddUserTextView: TextView
    private lateinit var nameAddUserTextEdit: EditText
    private lateinit var ageColumnAddUserTextView: TextView
    private lateinit var ageAddUserTextEdit: EditText
    private lateinit var addUserDatePicker: DatePicker
    private lateinit var addUserFragmentAddUserButton: MaterialButton

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
        return inflater.inflate(R.layout.fragment_add_user, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addUserFragmentCloseButton = view.findViewById(R.id.add_user_fragment_close_button)
        nameColumnAddUserTextView = view.findViewById(R.id.name_column_add_user_textview)
        nameAddUserTextEdit = view.findViewById(R.id.name_add_user_textedit)
        ageColumnAddUserTextView = view.findViewById(R.id.age_column_add_user_textview)
        ageAddUserTextEdit = view.findViewById(R.id.age_add_user_textedit)
        addUserDatePicker = view.findViewById(R.id.add_user_date_picker)
        addUserFragmentAddUserButton = view.findViewById(R.id.add_user_fragment_add_user_button)

        var ageCheck = LocalDateTime.now().year - addUserDatePicker.year
        if(LocalDateTime.now().monthValue * 31 + LocalDateTime.now().dayOfMonth < addUserDatePicker.month * 31 + addUserDatePicker.dayOfMonth) {
            ageCheck--
        }

        addUserFragmentCloseButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        addUserFragmentAddUserButton.setOnClickListener {
            if(nameAddUserTextEdit.text.toString() == "" || ageAddUserTextEdit.text.toString() == "") {
                Toast.makeText(activity, "You need to fill all the fields", Toast.LENGTH_LONG).show()
            } else if(ageCheck != ageAddUserTextEdit.text.toString().toInt()) {
                Toast.makeText(activity, "The age does not match with the date of birth", Toast.LENGTH_LONG).show()
            } else {
                parentFragmentManager.popBackStack()

                val spHelper = SharedPreferencesHelper()
                val users = (this.activity as MainActivity?)?.users
                if (users != null) {
                    users.add(User(nameAddUserTextEdit.text.toString(), ageAddUserTextEdit.toString().toInt(), false))
                }
                activity?.let { it1 -> spHelper.saveArrayListOfUsers(users, it1.baseContext) }
            }

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