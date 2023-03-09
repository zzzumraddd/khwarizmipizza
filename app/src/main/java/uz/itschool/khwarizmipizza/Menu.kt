package uz.itschool.khwarizmipizza

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.itschool.khwarizmipizza.databinding.ActivityMenuBinding
import java.util.*
import kotlin.collections.ArrayList


class Menu : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    lateinit var sets: MutableList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sets = mutableListOf<Product>()
        sets.add(Product("CHSB Gref SET", "40.000", R.drawable.set2))
        sets.add(Product("BSB Gref SET", "25.000", R.drawable.set3))
        sets.add(Product("Formativ Gref SET", "10.000", R.drawable.set1))
        binding.rv.adapter = Category_Adapter(Category.values())

        var adapter2 = Product_Adapter(sets)
        binding.rv2.adapter = adapter2
//        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.rv2.setLayoutManager(verticalLayoutManager)

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
}