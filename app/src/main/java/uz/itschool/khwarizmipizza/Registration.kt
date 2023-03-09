package uz.itschool.khwarizmipizza

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.itschool.khwarizmipizza.databinding.ActivityMainBinding
import uz.itschool.khwarizmipizza.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sigup.setOnClickListener {
            val userName = binding.name.text.toString()
            val password = binding.password.text.toString()
            val address = binding.address.text.toString()

            val sharedPreference = getSharedPreferences("FILE", Context.MODE_PRIVATE)
            val s = sharedPreference.getString("lang","tilni tanlanmagan")
            Toast.makeText(this,s, Toast.LENGTH_SHORT).show()
            val editor = sharedPreference.edit()
            editor.putString("USERNAME", userName)
            editor.putString("PASSWORD", password)
            editor.putString("ADDRESS", address)
            editor.apply()


            var intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

    }
}