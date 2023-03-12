package uz.itschool.khwarizmipizza

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import uz.itschool.khwarizmipizza.databinding.CategoryItemBinding
import uz.itschool.khwarizmipizza.databinding.OfferItemsBinding

class Product_Adapter(var list: MutableList<Product>, var mutableList: MutableList<Int>): RecyclerView.Adapter<Product_Adapter.ViewHolder>() {

    var onItemClick : ((Product) -> Unit)? = null
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
        var card: CardView = binding.card

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(OfferItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position).name
        holder.price.text = list.get(position).price
        holder.img.setImageResource(list.get(position).image)


        holder.card.setOnClickListener {
            onItemClick?.invoke(list.get(position))
        }
        holder.add.setOnClickListener {
            mutableList.add(list.get(position).pric)
        }
        holder.del.setOnClickListener {
            for(i in mutableList){
                if(i == list.get(position).pric){
                    mutableList.remove(i)
                    break
                }
            }
        }


    }
}