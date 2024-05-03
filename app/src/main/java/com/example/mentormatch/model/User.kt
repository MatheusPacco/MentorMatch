package com.example.mentormatch.model

open class User{
    val name: String = ""
    val age: Int = 0
    val image: String = ""
    val gender: Boolean = false
    val description : String = ""
    val overview : String = ""
    val goal : String = ""
    val technologies : Array<String> = TODO()
    val softSkills : Array<String?> = arrayOfNulls<String>(5)
    val active : Boolean = true

//    áreasDeExperiência: Lista das áreas em que o mentor tem experiência ou expertise.
//    listaDeCursos: Lista de cursos com os quais o mentor está associado.
//    imagemPerfil: URL ou referência para a imagem de perfil do mentor.
//    listaDeMatches: Lista de aprendizes que deram match com o mentor.
//    listaDeCandidatos: Lista de aprendizes que estão interessados no mentor, mas ainda não houve um match.
//    Redes sociais
}