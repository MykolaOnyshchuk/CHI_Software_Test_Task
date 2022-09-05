package project.mykolaonyshchuk.chisoftwaretesttask

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SharedPreferencesHelper {
    private val gson = Gson()

    fun saveArrayListOfUsers(usersArr: ArrayList<User>?, context: Context) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val usersJSON: String = gson.toJson(usersArr)
        editor.putString("users", usersJSON).apply()
    }

    fun getArrayListOfUsers(context: Context): ArrayList<User> {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val usersJSON = sharedPreferences.getString("users", null)
        val usersArr = gson.fromJson<ArrayList<User>>(usersJSON, object: TypeToken<ArrayList<User>>() {}.type)
        return usersArr
    }
}