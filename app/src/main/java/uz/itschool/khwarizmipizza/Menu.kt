package uz.itschool.khwarizmipizza

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import uz.itschool.khwarizmipizza.databinding.ActivityMenuBinding
import java.util.*
import kotlin.collections.ArrayList


class Menu : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    lateinit var sets: MutableList<Product>
    lateinit var categories: MutableList<Category>
    var array: Array<Product?> = arrayOfNulls<Product>(100)
    var c = 0
    var numbers = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sets = mutableListOf<Product>()
        sets.add(Product("CHSB Gref SET", "40.000 so'm", R.drawable.set2, 40000, "sets"))
        sets.add(Product("BSB Gref SET", "25.000 so'm", 25000, R.drawable.set3,"sets" ))
        sets.add(Product("Formativ Gref SET", "10.000 so'm", 10000, R.drawable.set1, "sets"))
        sets.add(Product("Italiano Pizza", "80.000 so'm", 80000, R.drawable.pizzas, "pizzas"))
        sets.add(Product("Diet Salad", "15.000 so'm", 15000, R.drawable.salads, "salads"))
        sets.add(Product("Moxito", "25.000 so'm", 25000,R.drawable.drinks, "drinks"))
        sets.add(Product("Cheese Cake", "20.000 so'm", 20000, R.drawable.deserts, "deserts"))


        categories = mutableListOf()
        categories.add(Category("sets", R.drawable.set2, Color.parseColor("#FFF9C2")))
        categories.add(Category("pizzas", R.drawable.pizzas, Color.parseColor("#FFF9C2")))
        categories.add(Category("salads", R.drawable.salads, Color.parseColor("#D3F4AD")))
        categories.add(Category("drinks", R.drawable.drinks, Color.parseColor("#96D1FF")))
        categories.add(Category("deserts", R.drawable.deserts, Color.parseColor("#DA91E6")))

        var adapter = Category_Adapter(categories)
        binding.rv.adapter = adapter
        var adapter2 = Product_Adapter(sets, numbers)
        binding.rv2.adapter = adapter2
//        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.rv2.setLayoutManager(verticalLayoutManager)

        val sharedPreference = getSharedPreferences("FILE", Context.MODE_PRIVATE)
        val s = sharedPreference.getString("array","")
        val editor = sharedPreference.edit()

    binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
        androidx.appcompat.widget.SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            filterList(newText, adapter2)
            return true
        }

    })

        adapter2.onItemClick = {
            val intent= Intent(this, DetailedActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }

        adapter.setOnItemClickListener(object : Category_Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                filterList2(categories.get(position).n, adapter2)
            }

        })

        binding.imageView3.setOnClickListener {
            c=0
            for(i in numbers){
                c=c+i
            }
//            val intent = Intent(this, Cartt::class.java)
//            intent.putExtra("price", c.toString())
//           startActivity(intent)
            val intent = Intent(this, Cartt::class.java)
           // binding.textView4.setText(c.toString())
            intent.putExtra("price", c.toString())
            startActivity(intent)

        }


    }
    private fun filterList(query: String?, adapter: Product_Adapter){
        if(query != null){
            val filteredList = ArrayList<Product>()
            for(i in sets){
                if(i.name.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){

            }else{
                adapter.FilteredList(filteredList)
            }
        }
    }
    private fun filterList2(query: String?, adapter: Product_Adapter){
        if(query != null){
            val filteredList = ArrayList<Product>()
            for(i in sets){
                if(i.type.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){

            }else{
                adapter.FilteredList(filteredList)
            }
        }
    }


}