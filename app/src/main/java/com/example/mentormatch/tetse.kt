package com.example.mentormatch

enum class TecnologiaDois {
    JAVA,
    KOTLIN,
    PYTHON,
}

fun main(args: Array<String>){

    // Tecnologias para lista mutável
    val tecnologias = "JS,Python,C#";
    println("tecnologias: " + tecnologias)
    var listaTecnologias = tecnologias.split(",");
    println("listaTecnologias: " + listaTecnologias)
    var listaMutavelTecnologias = listaTecnologias.toMutableList();
    println("listaMutavelTecnologias: " + listaMutavelTecnologias)

    // Lista mutável para String
    println("Lista de tecnologias em texto: " + listaMutavelTecnologias.joinToString(","));
}