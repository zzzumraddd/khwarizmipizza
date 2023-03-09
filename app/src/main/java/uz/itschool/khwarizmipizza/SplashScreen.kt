package uz.itschool.khwarizmipizza

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler().postDelayed(
            {
                val sharedPreference = getSharedPreferences("FILE", Context.MODE_PRIVATE)
                val s = sharedPreference.getString("lang","")
                val intent:Intent
                if (s==""){
                    intent = Intent(this, MainActivity::class.java)
                }else{
                    intent = Intent(this, SignIn::class.java)
                }

                startActivity(intent)
            }, 1500
        )


    }
}