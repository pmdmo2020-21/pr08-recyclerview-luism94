package es.iessaladillo.pedrojoya.pr06.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.iessaladillo.pedrojoya.pr06.data.model.User

object RepositoryImplementation: Repository {

    private val users: MutableList<User> = mutableListOf()
    private val usersLiveData: MutableLiveData<List<User>> = MutableLiveData(users)
    private val studentsMutableLiveData: MutableLiveData<List<User>> =
            MutableLiveData(requeryUsers())

    private fun requeryUsers(): List<User>? = users.toList().sortedBy { it.nombre }

    override fun getAllUsersOrderedByName(): LiveData<List<User>> {
        return usersLiveData
    }

    override fun insertUser(user: User) {
        users.add(user)
        usersLiveData.value = ArrayList<User>(users)
    }

    override fun updateUser(user: User) {
        studentsMutableLiveData.value = requeryUsers()
    }

    override fun deleteUser(user: User) {
        users.remove(user)
    }


}