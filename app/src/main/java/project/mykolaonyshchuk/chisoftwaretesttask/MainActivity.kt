package project.mykolaonyshchuk.chisoftwaretesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var activityCountButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityCountButton = findViewById(R.id.activity_count_button)
        activityCountButton.setOnClickListener(this)

        //supportFragmentManager.beginTransaction().add(R.id.fragment_container, CounterFragment()).commit()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.activity_count_button) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, CounterFragment()).commit()
            activityCountButton.setVisibility(View.GONE)
        }
    }
}