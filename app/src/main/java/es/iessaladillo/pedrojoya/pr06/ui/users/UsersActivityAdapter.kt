package es.iessaladillo.pedrojoya.pr06.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.pr06.data.model.User
import es.iessaladillo.pedrojoya.pr06.databinding.UsersActivityItemBinding

class UsersActivityAdapter(): RecyclerView.Adapter<UsersActivityAdapter.ViewHolder>() {
    private var data: List<User> = emptyList()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
            return data[position].id
    }

    class ViewHolder(private val binding: UsersActivityItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            user.run {
                binding.lblName.text = user.nombre
                binding.lblEmail.text = user.email
                binding.lblPhone.text = user.phoneNumber
                //binding.imageUser.se

            }
        }
    }

    fun submitList(newList: List<User>) {
        data = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UsersActivityItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}