package project.mykolaonyshchuk.chisoftwaretesttask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    val count = MutableLiveData<Int>(0)

    fun setCount(c: Int) {
        count.value = c
    }

    fun getCount(): LiveData<Int> {
        return count
    }
}