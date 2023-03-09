package uz.itschool.khwarizmipizza

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.itschool.khwarizmipizza.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences("FILE", Context.MODE_PRIVATE)
        val password = sharedPreference.getString("PASSWORD", "").toString()
       binding.sigin.setOnClickListener {
           val text = binding.password2.text.toString()
           if(text.equals(password)){
               var intent = Intent(this, Menu::class.java)
               startActivity(intent)
         }
           else{
              val toast = Toast.makeText(applicationContext, "Password is WRONG", Toast.LENGTH_SHORT)
              toast.show()
           }
           //binding.textView3.setText(text)
       }

    }
}