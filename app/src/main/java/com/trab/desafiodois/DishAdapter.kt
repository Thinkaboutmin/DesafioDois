package com.trab.desafiodois

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DishAdapter(val rest: Restaurant, val listener: EventListener)
                 : RecyclerView.Adapter<DishAdapter.DishHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishHolder {
        return if (viewType == 0) {
            val dishCard =
                LayoutInflater.from(parent.context).inflate(R.layout.expanded_restaurant, parent, false)
            DishHolder(dishCard)
        } else {
            val dishCard =
                LayoutInflater.from(parent.context).inflate(R.layout.dish_card, parent, false)

            DishHolder(dishCard)
        }
    }

    interface EventListener {
        fun getMeBack()

        fun openDishDetails(dish: Dish)
    }

    override fun onBindViewHolder(holder: DishHolder, position: Int) {
        if (position > 0) {
            // Continuamos a gambi aqui :)
            // Quero nem imaginar o como seria para implementar algumas coisas usando essa gambi.
            val positionG = position - 1
            val img = holder.itemView.findViewById<ImageView>(R.id.imgDishCard)
            img.setImageResource(rest.dishes[positionG].repImg)
            val text = holder.itemView.findViewById<TextView>(R.id.tvDishCardContent)
            text.text = rest.dishes[positionG].name
            if (positionG != itemCount -2 && positionG != itemCount - 3) {
                val content = holder.itemView.findViewById<ConstraintLayout>(R.id.content)
                val layout = (content.layoutParams as GridLayoutManager.LayoutParams)
                layout.bottomMargin = 20
            }
        } else {
            val toolbar = holder.itemView.findViewById<Toolbar>(R.id.detailNavBar)
            toolbar.setBackgroundResource(rest.repImg)
            val navText = holder.itemView.findViewById<TextView>(R.id.appbarTitle)
            navText.text = rest.name

            toolbar.setNavigationOnClickListener {
                listener.getMeBack()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        // Uma especie de gambi para conseguir diferenciar tipos de
        // forma rápida.
        if (position == 0) {
            return 0
        }
        return 1
    }

    override fun getItemCount(): Int = rest.dishes.size + 1

    inner class DishHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            if (itemViewType != 0) {
                itemView.setOnClickListener(this)
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position) {
                listener.openDishDetails(rest.dishes[position - 1])
            }
        }
    }
}