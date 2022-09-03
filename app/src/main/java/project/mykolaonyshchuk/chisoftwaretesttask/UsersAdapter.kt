package project.mykolaonyshchuk.chisoftwaretesttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial

class UsersAdapter (var users: List<User>, var userOnClickListener: UserOnClickListener) : RecyclerView.Adapter<UsersAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View, var userOnClickListener: UserOnClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nameText: TextView
        val ageText: TextView
        val isStudentSwitch: SwitchMaterial

        override fun onClick(p0: View?) {
            userOnClickListener.onUserClick(adapterPosition)
        }

        init {
            nameText = itemView.findViewById(R.id.name)
            ageText = itemView.findViewById(R.id.age)
            isStudentSwitch = itemView.findViewById(R.id.isStudentSwitch)
            itemView.setOnClickListener(this)
        }
    }

    interface UserOnClickListener {
        fun onUserClick(position: Int);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val userView = inflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(userView, userOnClickListener)
    }

    override fun onBindViewHolder(viewHolder: UsersAdapter.ViewHolder, position: Int) {
        val user: User = users.get(position)
        val nameText = viewHolder.nameText
        nameText.text = user.name
        val ageText = viewHolder.ageText
        ageText.text = "${user.age} years"
        val isStudentSwitch = viewHolder.isStudentSwitch
        isStudentSwitch.isChecked = user.isStudent
        if (isStudentSwitch.isChecked) {
            isStudentSwitch.text = "Is a student"
        } else {
            isStudentSwitch.text = "Is not a student"
        }

        isStudentSwitch.setOnClickListener{
            users[position].isStudent = isStudentSwitch.isChecked
            if (isStudentSwitch.isChecked) {
                isStudentSwitch.text = "Is a student"
            } else {
                isStudentSwitch.text = "Is not a student"
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}