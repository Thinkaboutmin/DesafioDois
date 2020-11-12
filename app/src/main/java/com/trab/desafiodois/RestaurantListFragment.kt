package com.trab.desafiodois

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_restaurants.*

class RestaurantListFragment : Fragment(), RestaurantAdapter.OnRestaurantClick {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurant_lists.layoutManager = LinearLayoutManager(context)
        restaurant_lists.adapter = RestaurantAdapter(Restaurant.generateRestaurants(), this)
        restaurant_lists.setHasFixedSize(true)
    }

    override fun restaurantClick(position: Int) {
        val action = RestaurantListFragmentDirections.actionRestaurantListFragmentToRestaurantDish(
                (restaurant_lists.adapter as RestaurantAdapter).list[position]
        )

        findNavController().navigate(action)
    }
}