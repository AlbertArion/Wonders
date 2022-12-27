package com.example.wonders.content

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.wonders.R
import com.example.wonders.application.App
import com.example.wonders.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val context by lazy { this }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val trickyNumber: Int by lazy { 1 }
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    class MainActivityViewModel : ViewModel() {
        var text: String = "MainActivity";
        var floatingActionButtonContentDescription: String? =
            App.getContext()?.getString(R.string.floatingActionButton)

        class JobCanceller(val job: Job) : TimerTask() {
            override fun run() {
                job.cancel(CancellationException("Job timeout", Throwable()))
            }

        }

        fun startCouRoutine() {
            val job = viewModelScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    val response = doSomeIO()
                    Toast.makeText(App.getContext(), response, Toast.LENGTH_SHORT).show()
                    println("Response = $response")
                }
            }
            Timer().schedule(JobCanceller(job), 1000)
        }

        private fun doSomeIO(): String {
            var response = ""
            for (i in 0..100000) {
                println("io ing: i = $i")
            }
            response = "response";
            return response
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = MainActivityViewModel()
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}