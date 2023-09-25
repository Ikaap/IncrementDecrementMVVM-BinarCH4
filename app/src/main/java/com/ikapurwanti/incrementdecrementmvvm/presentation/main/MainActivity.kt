package com.ikapurwanti.incrementdecrementmvvm.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ikapurwanti.incrementdecrementmvvm.data.CounterDataSource
import com.ikapurwanti.incrementdecrementmvvm.data.CounterDataSourceImpl
import com.ikapurwanti.incrementdecrementmvvm.databinding.ActivityMainBinding
import com.ikapurwanti.incrementdecrementmvvm.utils.GenericViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels {
        val dataSource : CounterDataSource = CounterDataSourceImpl()
        GenericViewModelFactory.create(MainViewModel(dataSource))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListener()
        observeState()
    }

    private fun observeState() {
        viewModel.counter.observe(this) {
            binding.tvCounter.text = it.toString()
        }
    }

    private fun setOnClickListener() {
        binding.btnDecrement.setOnClickListener {
            decrement()
        }
        binding.btnIncrement.setOnClickListener {
            increment()
        }
    }

    private fun decrement() {
        viewModel.decrement()
    }

    private fun increment() {
        viewModel.increment()
    }

}