package com.trab.desafiodois

import java.io.Serializable

data class Restaurant(val name: String, val address: String, val closingTime: String,
                      val repImg: Int, val dishes: ArrayList<Dish>) : Serializable {

    companion object {
        fun generateRestaurants() : ArrayList<Restaurant> {
            val names = arrayListOf(
                "Tony Roma's",
                "Aoyama - Moema",
                "Outback - Moema",
                "Si Sẽnor!"
            )

            val addresses = arrayListOf (
                "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                "Alameda dos Arapanés, 532 - Moema",
                "Av. Moaci, 187, 187 - Moema, São Paulo",
                "Alameda Jauaperi, 626 - Moema",
            )

            val closingTimes = arrayListOf(
                "22:00",
                "00:00",
                "00:00",
                "01:00"
            )

            val repImgs = arrayListOf(
                R.drawable.image1,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image3
            )

            val dishes = arrayListOf(
                Dish.generateTemplate("Salada com molho Gengibre"),
                Dish.generateTemplate("Algo muito delicioso"),
                Dish.generateTemplate("Lasanha bolonhesa"),
                Dish.generateTemplate("Sushi ao conhaque")
            )

            val restaurantes = arrayListOf<Restaurant>()

            for (i in 0 until names.size) {
                restaurantes.add(
                    Restaurant(
                        names[i],
                        addresses[i],
                        closingTimes[i],
                        repImgs[i],
                        dishes[i]
                    )
                )
            }

            return restaurantes
        }
    }
}