package project.mykolaonyshchuk.chisoftwaretesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var users: ArrayList<User>
    private lateinit var userRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRecyclerView = findViewById(R.id.user_recycler_view)

        users = ArrayList()
        users.add(User("Andrew", 20, true))
        users.add(User("Mary", 23, false))
        users.add(User("Kate", 33, false))
        users.add(User("Alex", 24, true))
        users.add(User("Victoria", 19, false))
        users.add(User("John", 22, true))
        users.add(User("Jessica", 25, true))

        val adapter = UsersAdapter(users)
        Log.d("Number of objects", adapter.itemCount.toString())

        userRecyclerView.adapter = adapter

        userRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}