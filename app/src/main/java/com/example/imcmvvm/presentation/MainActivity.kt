package com.example.imcmvvm.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imcmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ImcViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paddingOriginal = binding.root.paddingTop
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                paddingOriginal + barras.left,
                paddingOriginal + barras.top,
                paddingOriginal + barras.right,
                paddingOriginal + barras.bottom
            )
            insets
        }

        binding.buttonCalcular.setOnClickListener {
            viewModel.calcular(
                binding.editPeso.text.toString(),
                binding.editAltura.text.toString()
            )
        }

        viewModel.resultado.observe(this) { texto ->
            binding.textResultado.text = texto
        }

    }
}