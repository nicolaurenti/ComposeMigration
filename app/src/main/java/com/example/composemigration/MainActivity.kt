package com.example.composemigration

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poccomposemigration.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MigrationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MigrationAdapter(TEXT_LIST)
        binding.button.setOnClickListener {
            viewModel.buttonClicked()
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect(this@MainActivity::updateUI)
            }
        }
    }

    private fun updateUI(state: MigrationState) {
        when (state) {
            MigrationState.IDLE -> {}
            MigrationState.DOING_SOMETHING -> {
                showToast()
            }
        }
    }

    private fun showToast() {
        Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val TEXT_LIST = listOf(
            "Text 1",
            "Text 2",
            "Text 3",
            "Text 4",
            "Text 5",
            "Text 6",
            "Text 7",
            "Text 8",
            "Text 9",
            "Text 10",
        )
        const val TOAST_TEXT = "Button clicked..."
    }
}
