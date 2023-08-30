package com.cursoant.android.userssp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoant.android.userssp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), onClickListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)

        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP", "${getString(R.string.sp_first_time)} = $isFirstTime")

        if (isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)

            val dialog = MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title).setView(dialogView)
                .setCancelable(false)
                .setNeutralButton(R.string.dialog_neutral, null)
                .setPositiveButton(R.string.dialog_confirm) { _, _ -> }
                .create()

            dialog.show()

            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                val username = dialogView.findViewById<TextInputEditText>(R.id.etUsername)
                    .text.toString()

                if (username.isBlank()) {
                    Toast.makeText(this, R.string.register_invalid, Toast.LENGTH_SHORT).show()
                } else {
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                    Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        } else {
            val username = preferences.getString(
                getString(R.string.sp_username),
                getString(R.string.hint_username)
            )
            Toast.makeText(this, "Welcome $username", Toast.LENGTH_SHORT).show()
        }


        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)


        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }

        val swipehelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove( recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                 target: RecyclerView.ViewHolder ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                userAdapter.remove(viewHolder.adapterPosition)

            }
        })

        swipehelper.attachToRecyclerView(binding.recyclerview)
    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()

        val charles = User(
            1,
            "Charles",
            "Douglas",
            "https://m.media-amazon.com/images/M/MV5BMGI4NzU1YTMtNzJmNy00YjYzLWIxMjEtN2NlY2ExMzk3ZjY2XkEyXkFqcGdeQXVyMTI2ODY2NTM4._V1_.jpg"
        )
        val john = User(
            2,
            "John",
            "White",
            "https://m.media-amazon.com/images/M/MV5BMGQ4NjU3YWMtZDFmZi00ZmYwLWIzYzItMmNhNGNjZTQ4MGM1XkEyXkFqcGdeQXVyMjMyMjM4ODY@._V1_.jpg"
        )
        val xavier = User(
            3,
            "Xavier",
            "Johnson",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Xavier_Johnson_Indiana.jpg/800px-Xavier_Johnson_Indiana.jpg"
        )
        val emma = User(
            4,
            "Emma",
            "Greenfield",
            "https://i.discogs.com/gcNSjsdb4Bns0mcj_abZ16GKhJNKwqPIFjGhthlLhVQ/rs:fit/g:sm/q:90/h:600/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9BLTI5MjA0/NDMtMTQ2MTM2MDkw/Ny04MjA5LmpwZWc.jpeg"
        )

        users.add(charles)
        users.add(john)
        users.add(xavier)
        users.add(emma)
        users.add(charles)
        users.add(john)
        users.add(xavier)
        users.add(emma)
        users.add(charles)
        users.add(john)
        users.add(xavier)
        users.add(emma)
        users.add(charles)
        users.add(john)
        users.add(xavier)
        users.add(emma)

        return users
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position: ${user.getFullName()} ", Toast.LENGTH_SHORT).show()
    }


}