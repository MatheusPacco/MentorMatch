package com.example.mentormatch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey( autoGenerate = true ) var id : Long = 0,
    var name: String = "",
    var age: Int = 0,
    var gender: Boolean = false,
    var typeUser: Int = 0,
    var description : String = "",
    var goal : String = "",
    var technologies : MutableList<String> = mutableListOf<String>(),
    var softSkills : MutableList<String> = mutableListOf<String>(),
    var active : Boolean = true
)

//    áreasDeExperiência: Lista das áreas em que o mentor tem experiência ou expertise.
//    listaDeCursos: Lista de cursos com os quais o mentor está associado.
//    imagemPerfil: URL ou referência para a imagem de perfil do mentor.
//    listaDeMatches: Lista de aprendizes que deram match com o mentor.
//    listaDeCandidatos: Lista de aprendizes que estão interessados no mentor, mas ainda não houve um match.
//    Redes sociais