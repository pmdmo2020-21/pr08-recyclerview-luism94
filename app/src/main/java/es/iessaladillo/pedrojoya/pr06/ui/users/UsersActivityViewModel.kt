package es.iessaladillo.pedrojoya.pr06.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr06.data.Repository
import es.iessaladillo.pedrojoya.pr06.data.RepositoryImplementation.getAllUsersOrderedByName
import es.iessaladillo.pedrojoya.pr06.data.model.User

class UsersActivityViewModel(private val repository: Repository): ViewModel() {

    val users: LiveData<List<User>> = repository.getAllUsersOrderedByName()

    fun addUser(user: User) {
        repository.insertUser(user)
    }

    fun deleteStudent(user: User) {
        repository.deleteUser(user)
    }

    fun updateStudent(user: User) {
        repository.deleteUser(user)
    }
}
