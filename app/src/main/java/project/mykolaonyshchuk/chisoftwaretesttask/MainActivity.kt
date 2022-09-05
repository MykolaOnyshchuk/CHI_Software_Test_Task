package project.mykolaonyshchuk.chisoftwaretesttask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity(), UsersAdapter.UserOnClickListener {
    private lateinit var addUserButton: MaterialButton
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var users: ArrayList<User>
    lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUserButton = findViewById(R.id.add_user_button)
        userRecyclerView = findViewById(R.id.user_recycler_view)
        toolbar = findViewById(R.id.toolbar)

        //setSupportActionBar(toolbar)

        val spHelper = SharedPreferencesHelper()
        val spUsers = spHelper.getArrayListOfUsers(this)

        if (spUsers == null) {
            users = ArrayList()
            users.add(User("Andrew", 20, true))
            users.add(User("Mary", 23, false))
            users.add(User("Kate", 33, false))
            users.add(User("Alex", 24, true))
            users.add(User("Victoria", 19, false))
            users.add(User("John", 22, true))
            users.add(User("Jessica", 25, true))
        } else {
            users = spUsers
        }

        adapter = UsersAdapter(users, this)
        Log.d("Number of objects", adapter.itemCount.toString())

        userRecyclerView.adapter = adapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        addUserButton.setOnClickListener {
            val addUserFragment = AddUserFragment()
            val fm: FragmentManager = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_container, addUserFragment).addToBackStack(null).commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val spHelper = SharedPreferencesHelper()
        spHelper.saveArrayListOfUsers(users, this)
    }

    override fun onUserClick(position: Int) {

        val bundle = Bundle()
        bundle.putParcelable("user", users[position])
        val detailsFragment = UserDetailsFragment()
        detailsFragment.arguments = bundle
        val fm: FragmentManager = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragment_container, detailsFragment).addToBackStack(null).commit()
    }
}