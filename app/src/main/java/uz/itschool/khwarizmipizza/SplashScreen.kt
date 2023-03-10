package uz.itschool.khwarizmipizza

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.*

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
                    setAppLocale(this, s.toString())
                    intent = Intent(this, SignIn::class.java)
                }

                startActivity(intent)
            }, 1500
        )


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