package uz.itschool.khwarizmipizza

import android.graphics.Color

enum class Category(var n: String, var image: Int, var color: Int){
    PIZZAS("Pizzas", R.drawable.pizzas, Color.parseColor("#FFF9C2")),
    SALADS("Salads", R.drawable.salads, Color.parseColor("#D3F4AD")),
    DRINKS("Drinks", R.drawable.drinks, Color.parseColor("#96D1FF")),
    DESERTS("Deserts", R.drawable.deserts, Color.parseColor("#DA91E6"))
}