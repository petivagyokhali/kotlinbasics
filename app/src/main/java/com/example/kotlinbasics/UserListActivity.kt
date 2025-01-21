package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.UserAdapter
import com.example.kotlinbasics.model.User

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val users = listOf(
            User("Gipsz Jakab", "gipsz@gmail.com", R.drawable.user_icon),
            User("Nagy Ernő", "nagy@gmail.com", R.drawable.user_icon),
            User("Kiss Balázs", "bala@gmail.com", R.drawable.user_icon),
            User("Rézműves Ronaldo", "ronca@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gipsz@gmail.com", R.drawable.user_icon),
            User("Nagy Ernő", "nagy@gmail.com", R.drawable.user_icon),
            User("Kiss Balázs", "bala@gmail.com", R.drawable.user_icon),
            User("Rézműves Ronaldo", "ronca@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gipsz@gmail.com", R.drawable.user_icon),
            User("Nagy Ernő", "nagy@gmail.com", R.drawable.user_icon),
            User("Kiss Balázs", "bala@gmail.com", R.drawable.user_icon),
            User("Rézműves Ronaldo", "ronca@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gipsz@gmail.com", R.drawable.user_icon),
            User("Nagy Ernő", "nagy@gmail.com", R.drawable.user_icon),
            User("Kiss Balázs", "bala@gmail.com", R.drawable.user_icon),
            User("Rézműves Ronaldo", "ronca@gmail.com", R.drawable.user_icon),

            )
        val recyclerView: RecyclerView = findViewById(R.id.userListRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=UserAdapter(users)
    }
}