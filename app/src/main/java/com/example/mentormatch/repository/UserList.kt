package com.example.mentormatch.repository

import com.example.mentormatch.enums.SoftSkill
import com.example.mentormatch.enums.Technology
import com.example.mentormatch.model.User

fun getAllUsers(): List<User> {
    val user1 = User(
        name = "Anderso Gaveta",
        age = 32,
        gender = "Masculino",
        typeUser = "Aprendiz",
        description = "Estudante de engenharia interessada em aprender programação.",
        goal = "Aprender desenvolvimento web e mobile.",
        technologies = mutableListOf<String>(Technology.JAVA.name, Technology.JAVASCRIPT.name, Technology.PYTHON.name),
        softSkills = mutableListOf<String>(SoftSkill.COMUNICACAO.name,SoftSkill.TRABALHO_EM_EQUIPE.name ),
        active = true
    )

    val user2 = User(
        name = "João",
        age = 20,
        gender = "Masculino",
        typeUser = "Aprendiz",
        description = "Estudante de design gráfico buscando conhecimento em UX/UI.",
        goal = "Dominar ferramentas de design e desenvolvimento de interfaces.",
        technologies = mutableListOf<String>(Technology.JAVASCRIPT.name, Technology.PYTHON.name),
        softSkills = mutableListOf<String>(SoftSkill.RESOLUCAO_DE_PROBLEMAS.name ),
        active = true
    )

    val user3 = User(
        name = "Maria",
        age = 25,
        gender = "Masculino",
        typeUser = "Aprendiz",
        description = "Professora de história interessada em aprender programação para criar recursos educacionais interativos.",
        goal = "Desenvolver aplicativos e jogos educacionais.",
        technologies = mutableListOf<String>(Technology.JAVASCRIPT.name, Technology.PYTHON.name),
        softSkills = mutableListOf<String>(SoftSkill.COMUNICACAO.name,SoftSkill.TRABALHO_EM_EQUIPE.name),
        active = true
    )

    val mentor1 = User(
        name = "Carlos",
        age = 35,
        gender = "true",
        typeUser = "Mentor",
        description = "Desenvolvedor full-stack com mais de 10 anos de experiência.",
        goal = "Compartilhar conhecimento e ajudar outros a crescer na carreira de programação.",
        technologies = mutableListOf<String>(Technology.JAVASCRIPT.name, Technology.PYTHON.name),
        softSkills = mutableListOf<String>(SoftSkill.COMUNICACAO.name,SoftSkill.TRABALHO_EM_EQUIPE.name),
        active = true
    )

    val mentor2 = User(
        name = "Carlos Alberto",
        age = 65,
        gender = "true",
        typeUser = "Mentor",
        description = "Desenvolvedor full-stack com mais de 10 anos de experiência.",
        goal = "Compartilhar conhecimento e ajudar outros a crescer na carreira de programação.",
        technologies = mutableListOf<String>(Technology.JAVASCRIPT.name, Technology.PYTHON.name),
        softSkills = mutableListOf<String>(SoftSkill.COMUNICACAO.name,SoftSkill.TRABALHO_EM_EQUIPE.name),
        active = true
    )

    return listOf(
        user1, user2, user3, mentor1, mentor2
    )
}