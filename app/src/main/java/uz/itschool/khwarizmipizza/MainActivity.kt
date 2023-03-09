package uz.itschool.khwarizmipizza

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import uz.itschool.khwarizmipizza.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedReference = getSharedPreferences("FILE", MODE_PRIVATE)
        val edit  = sharedReference.edit()
        binding.btnEnglish.setOnClickListener {
            setAppLocale(this, "en")
            val intent = Intent(this, Registration::class.java)
            edit.putString("lang","en").apply()
            startActivity(intent)
        }
        binding.btnUzbek.setOnClickListener{
            setAppLocale(this, "uz")
            val intent = Intent(this, Registration::class.java)
            edit.putString("lang","uz").apply()
            startActivity(intent)
        }




    }
    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}