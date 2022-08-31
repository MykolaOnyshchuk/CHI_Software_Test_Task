package project.mykolaonyshchuk.chisoftwaretesttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial

class UsersAdapter (private var users: List<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameText: TextView = itemView.findViewById(R.id.name)
        val ageText: TextView = itemView.findViewById(R.id.age)
        val isStudentSwitch: SwitchMaterial = itemView.findViewById(R.id.isStudentSwitch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val userView = inflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(userView)
    }

    override fun onBindViewHolder(viewHolder: UsersAdapter.ViewHolder, position: Int) {
        val user: User = users.get(position)
        val nameText = viewHolder.nameText
        nameText.text = user.name
        val ageText = viewHolder.ageText
        ageText.text = user.age.toString()
        val isStudentSwitch = viewHolder.isStudentSwitch
        isStudentSwitch.isChecked = user.isStudent

        isStudentSwitch.setOnClickListener{
            users[position].isStudent = isStudentSwitch.isChecked
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}