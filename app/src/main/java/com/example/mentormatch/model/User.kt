package com.example.mentormatch.model

data class User(
    val name: String = "",
    val age: Int = 0,
    val gender: Boolean = false,
    val typeUser: Int = 0,
    val description : String = "",
    val goal : String = "",
    val technologies : Array<String> = arrayOf<String>(),
    val softSkills : Array<String> = arrayOf<String>(),
    val active : Boolean = true
)

//    áreasDeExperiência: Lista das áreas em que o mentor tem experiência ou expertise.
//    listaDeCursos: Lista de cursos com os quais o mentor está associado.
//    imagemPerfil: URL ou referência para a imagem de perfil do mentor.
//    listaDeMatches: Lista de aprendizes que deram match com o mentor.
//    listaDeCandidatos: Lista de aprendizes que estão interessados no mentor, mas ainda não houve um match.
//    Redes sociais