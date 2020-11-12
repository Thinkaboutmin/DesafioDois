package com.trab.desafiodois

import android.os.Bundle
import android.util.LayoutDirection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.internal.BaselineLayout
import kotlinx.android.synthetic.main.fragment_detail_restaurant.*
import java.util.*
import kotlin.reflect.KFunction1

class RestaurantDetailsFragment : Fragment(), DishAdapter.EventListener {
    val args: RestaurantDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context, 2)
        // Não consegui fazer essa classe de forma anonima...
        class TopOk : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0) {
                    return 2
                }

                return 1
            }
        }

        layoutManager.spanSizeLookup = TopOk()
        detailRecyView.layoutManager = layoutManager
        detailRecyView.adapter = DishAdapter(args.restaurant, this)
        detailRecyView.setHasFixedSize(true)
    }

    override fun getMeBack() {
        findNavController().popBackStack()
    }

    override fun openDishDetails(dish: Dish) {
        val action = RestaurantDetailsFragmentDirections.actionRestaurantDishToDishDetailsFragment(
            dish
        )

        findNavController().navigate(action)
    }
}