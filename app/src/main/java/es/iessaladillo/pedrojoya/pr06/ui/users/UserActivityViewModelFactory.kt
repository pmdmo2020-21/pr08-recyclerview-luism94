package es.iessaladillo.pedrojoya.pr06.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.pr06.data.Repository

class UserActivityViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    @Suppress
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = UsersActivityViewModel(repository) as T

}