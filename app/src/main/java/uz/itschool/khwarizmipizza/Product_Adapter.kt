package uz.itschool.khwarizmipizza

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.itschool.khwarizmipizza.databinding.CategoryItemBinding
import uz.itschool.khwarizmipizza.databinding.OfferItemsBinding

class Product_Adapter(var list: MutableList<Product>): RecyclerView.Adapter<Product_Adapter.ViewHolder>() {
    fun FilteredList(list: MutableList<Product>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(binding: OfferItemsBinding): RecyclerView.ViewHolder(binding.root){
        var name: TextView = binding.name
        var img: ImageView = binding.img
        var price: TextView = binding.price
        var del: Button = binding.del
        var add: Button = binding.add
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(OfferItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position).name
        holder.img.setImageResource(list.get(position).image)
        holder.price.text = list.get(position).price
    }
}