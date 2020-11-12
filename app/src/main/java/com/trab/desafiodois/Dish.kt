package com.trab.desafiodois

import java.io.Serializable

data class Dish(val repImg: Int, val name: String, val desc: String): Serializable {
    companion object {
        fun generateTemplate(nomePrato: String): ArrayList<Dish> {
            val pratos = arrayListOf<Dish>()
            val defaultText = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem " +
                              "accusantium doloremque laudantium, totam rem aperiam, eaque ipsa " +
                              "quae ab illo inventore veritatis"

            var image = R.drawable.image3
            when(nomePrato) {
                "Salada com molho Gengibre" -> image = R.drawable.image4
                "Lasanha bolonhesa" -> image = R.drawable.image1
                "Sushi ao conhaque" -> image = R.drawable.image5
            }

            for (i in 0..9) {
                pratos.add(Dish(image, nomePrato, defaultText))
            }

            return pratos
        }
    }
}