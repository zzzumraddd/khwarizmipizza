package uz.itschool.khwarizmipizza

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.itschool.khwarizmipizza.databinding.CategoryItemBinding

class Category_Adapter(var list: MutableList<Category>): RecyclerView.Adapter<Category_Adapter.Category_Holder>() {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)

    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }



    class Category_Holder(binding: CategoryItemBinding, listener: onItemClickListener): RecyclerView.ViewHolder(binding.root){
        var name = binding.text
        var image = binding.image
        var card = binding.card

        init{
        itemView.setOnClickListener{
            listener.onItemClick(adapterPosition)
        }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Category_Holder {
        return Category_Holder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false), mListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Category_Holder, position: Int) {
        holder.name.text = list.get(position).n
        holder.image.setImageResource(list.get(position).image)
        holder.card.setCardBackgroundColor(list.get(position).color)



    }


    interface Listener{
       fun onClick(position: Int)
    }

}