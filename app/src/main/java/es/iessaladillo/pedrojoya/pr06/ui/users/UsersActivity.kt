package es.iessaladillo.pedrojoya.pr06.ui.users

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import es.iessaladillo.pedrojoya.pr06.R
import es.iessaladillo.pedrojoya.pr06.data.RepositoryImplementation
import es.iessaladillo.pedrojoya.pr06.data.model.User
import es.iessaladillo.pedrojoya.pr06.databinding.UsersActivityBinding
import es.iessaladillo.pedrojoya.pr06.ui.add_user.AddUserActivity
import kotlinx.android.synthetic.main.users_activity.*

class UsersActivity : AppCompatActivity() {

    private val viewModel: UsersActivityViewModel by viewModels {
        UserActivityViewModelFactory(RepositoryImplementation)
    }
    private lateinit var binding: UsersActivityBinding
    private val listAdapter: UsersActivityAdapter = UsersActivityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UsersActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        observeUsers()
    }

    private fun observeUsers() {
        viewModel.users.observe(this) {
            updateList(it)
        }
    }

    private fun updateList(newList: List<User>) {
        listAdapter.submitList(newList)
        binding.lblEmptyView.visibility = if (newList.isEmpty()) View.VISIBLE else View.INVISIBLE
    }

    private fun setupViews() {
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.lstUsers.setHasFixedSize(true)
        binding.lstUsers.adapter = listAdapter
        binding.lstUsers.layoutManager = GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        binding.lstUsers.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        binding.lstUsers.itemAnimator = DefaultItemAnimator()
    }

    // NO TOCAR: Estos métodos gestionan el menú y su gestión

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.users, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuAdd) {
            onAddUser()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // FIN NO TOCAR

    private fun onAddUser() {
        startActivity(AddUserActivity.newIntent(this))
    }

    private fun deleteUser(user: User) {
        viewModel.deleteStudent(user)
    }

    private fun updateUser(user: User) {
        viewModel.deleteStudent(user)
    }
}