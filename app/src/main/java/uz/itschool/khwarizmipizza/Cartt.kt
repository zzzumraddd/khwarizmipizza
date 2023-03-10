package uz.itschool.khwarizmipizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.khwarizmipizza.databinding.ActivityCarttBinding

class Cartt : AppCompatActivity() {
    lateinit var binding: ActivityCarttBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarttBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getStringExtra("price")
        binding.textView6.setText(food)
    }
}