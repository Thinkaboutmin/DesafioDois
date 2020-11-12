package com.trab.desafiodois

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_dish_details.*

class DishDetailsFragment : Fragment() {
    private val args: DishDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dish_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailNavBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        val dish = args.dish
        detailNavBar.setBackgroundResource(dish.repImg)
        appbarTitle.text = dish.name
        dishContent.text = dish.desc
    }
}