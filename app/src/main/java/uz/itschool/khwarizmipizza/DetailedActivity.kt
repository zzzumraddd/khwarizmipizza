package uz.itschool.khwarizmipizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val food = intent.getParcelableExtra<Product>("food")
        if(food != null){
            val textView = findViewById<TextView>(R.id.title)
            val textView2 = findViewById<TextView>(R.id.price)
            val imageView = findViewById<ImageView>(R.id.pr)

            textView.text = food.name
            textView2.text = food.price
            imageView.setImageResource(food.image)
        }
    }
}