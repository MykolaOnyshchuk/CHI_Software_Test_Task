package project.mykolaonyshchuk.chisoftwaretesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityCountButton: Button
    private lateinit var activityCountResult: TextView
    private val countViewModel: CountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityCountButton = findViewById(R.id.activity_count_button)
        activityCountResult = findViewById(R.id.activity_count_result)

        activityCountButton.setOnClickListener(this)

        //supportFragmentManager.beginTransaction().add(R.id.fragment_container, CounterFragment()).commit()
        countViewModel.getCount().observe(this, {activityCountResult.text = it.toString()})
    }

    override fun onClick(view: View) {
        val fm: FragmentManager = getSupportFragmentManager()

        if (view.id == R.id.activity_count_button) {
            fm.beginTransaction().replace(R.id.fragment_container, CounterFragment()).commit()
            activityCountButton.setVisibility(View.GONE)
        }
    }
}