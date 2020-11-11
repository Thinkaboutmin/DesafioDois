package com.trab.desafiodois

data class Dish(val repImg: Int, val name: String) {
    companion object {
        fun generateTemplate(nomePrato: String): ArrayList<Dish> {
            val pratos = arrayListOf<Dish>()

            for (i in 0..9) {
                pratos.add(Dish(R.drawable.image3, nomePrato))
            }

            return pratos
        }
    }
}