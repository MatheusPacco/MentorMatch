package com.example.mentormatch

enum class TecnologiaDois {
    JAVA,
    KOTLIN,
    PYTHON,
}

fun main(args: Array<String>){
    TecnologiaDois.values().forEach{tecnologi ->
        println(tecnologi.name)
        println(tecnologi.ordinal)
        println("----------------------------------------------")
    }

//    val arrayTecnology:Array<TecnologiaDois> = TecnologiaDois.values()
//    var arrayindexTecnology = arrayOf<Int>()
//    TecnologiaDois.values().forEach { tecnologi ->
//        println(tecnologi.)
//    }
}