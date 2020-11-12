package com.trab.desafiodois

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(val list: ArrayList<Restaurant>, val listener: OnRestaurantClick) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {
    lateinit var parent: ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val restaurantCard = LayoutInflater.from(parent.context).inflate(
            R.layout.menu_item, parent, false
        )
        this.parent = parent

        return ViewHolder(restaurantCard)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val titulo = holder.restaurantCard.findViewById<TextView>(R.id.tvCardTitulo)
        titulo.text = list[position].name
        val content = holder.restaurantCard.findViewById<TextView>(R.id.tvCardContent)
        content.text = parent.resources.getString(R.string.content_restaurant_card,
            list[position].address, list[position].closingTime)
        val img = holder.restaurantCard.findViewById<ImageView>(R.id.imgCard)
        img.setImageResource(list[position].repImg)

        if (position == itemCount - 1) {
            val content = holder.restaurantCard.findViewById<ConstraintLayout>(R.id.content)
            val layout = (content.layoutParams as RecyclerView.LayoutParams)
            layout.bottomMargin = 30
        }
    }

    override fun getItemCount(): Int = list.size

    interface  OnRestaurantClick {
        fun restaurantClick(position: Int)
    }

    inner class ViewHolder(val restaurantCard: View) : RecyclerView.ViewHolder(restaurantCard),
                    View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position) {
                listener.restaurantClick(position)
            }
        }
    }
}