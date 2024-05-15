package com.example.mentormatch.repository

import com.example.mentormatch.model.User

fun getAllUsers(): List<User> {
    val user1 = User(
        name = "Anderso Gaveta",
        age = 32,
        gender = true, // false para feminino, true para masculino
        typeUser = 0,
        description = "Estudante de engenharia interessada em aprender programação.",
        goal = "Aprender desenvolvimento web e mobile.",
        technologies = mutableListOf<String>("HTML", "JAVA", "JAVASCRIPT"),
        softSkills = mutableListOf<String>("COMUNICACAO", "TRABALHO_EM_EQUIPE"),
        active = true
    )

    val user2 = User(
        name = "João",
        age = 20,
        gender = true,
        typeUser = 0,
        description = "Estudante de design gráfico buscando conhecimento em UX/UI.",
        goal = "Dominar ferramentas de design e desenvolvimento de interfaces.",
        technologies = mutableListOf<String>("Adobe Illustrator", "Figma"),
        softSkills = mutableListOf<String>("Criatividade", "TRABALHO_EM_EQUIPE"),
        active = true
    )

    val user3 = User(
        name = "Maria",
        age = 25,
        gender = false,
        typeUser = 0,
        description = "Professora de história interessada em aprender programação para criar recursos educacionais interativos.",
        goal = "Desenvolver aplicativos e jogos educacionais.",
        technologies = mutableListOf<String>("PYTHON", "Unity"),
        softSkills = mutableListOf<String>("TRABALHO_EM_EQUIPE", "RESOLUCAO_DE_PROBLEMAS"),
        active = true
    )

    val user4 = User(
        name = "Pedro",
        age = 18,
        gender = true,
        typeUser = 0,
        description = "Estudante do ensino médio com interesse em ciência de dados.",
        goal = "Aplicar análise de dados em projetos de pesquisa.",
        technologies = mutableListOf<String>("KOTLIN", "JAVA"),
        softSkills = mutableListOf<String>("RESOLUCAO_DE_PROBLEMAS", "Pensamento analítico"),
        active = true
    )

    val user5 = User(
        name = "Carla",
        age = 30,
        gender = false,
        typeUser = 0,
        description = "Profissional de marketing buscando habilidades em marketing digital.",
        goal = "Dominar estratégias de marketing online.",
        technologies = mutableListOf<String>("KOTLIN", "SEO"),
        softSkills = mutableListOf<String>("RESOLUCAO_DE_PROBLEMAS", "Comunicação persuasiva"),
        active = true
    )

    val mentor1 = User(
        name = "Carlos",
        age = 35,
        gender = true,
        typeUser = 1, // Tipo 1 para mentor
        description = "Desenvolvedor full-stack com mais de 10 anos de experiência.",
        goal = "Compartilhar conhecimento e ajudar outros a crescer na carreira de programação.",
        technologies = mutableListOf<String>("Java", "Kotlin", "Spring Boot", "Angular"),
        softSkills = mutableListOf<String>("Liderança", "Mentoria"),
        active = true
    )

    val mentor2 = User(
        name = "Juliana",
        age = 28,
        gender = false,
        typeUser = 1,
        description = "Designer de experiência do usuário com foco em acessibilidade e usabilidade.",
        goal = "Auxiliar designers iniciantes a melhorar suas habilidades e entender os princípios de UX/UI.",
        technologies = mutableListOf<String>("Adobe XD", "Sketch", "InVision"),
        softSkills = mutableListOf<String>("Empatia", "Comunicação clara"),
        active = true
    )

    val mentor3 = User(
        name = "Rafael",
        age = 40,
        gender = true,
        typeUser = 1,
        description = "Engenheiro de dados especializado em big data e análise preditiva.",
        goal = "Orientar profissionais interessados em entrar no campo de ciência de dados e big data.",
        technologies = mutableListOf<String>("Hadoop", "Spark", "Python", "SQL"),
        softSkills = mutableListOf<String>("Resolução de problemas", "Comunicação eficaz"),
        active = true
    )

    val mentor4 = User(
        name = "Camila",
        age = 32,
        gender = false,
        typeUser = 1,
        description = "Especialista em marketing digital com experiência em estratégias de SEO e mídias sociais.",
        goal = "Ajudar empreendedores e profissionais de marketing a desenvolver estratégias digitais eficazes.",
        technologies = mutableListOf<String>("Google Ads", "Facebook Ads", "SEO"),
        softSkills = mutableListOf<String>("Criatividade", "Análise de mercado"),
        active = true
    )

    val mentor5 = User(
        name = "Fernando",
        age = 45,
        gender = true,
        typeUser = 1,
        description = "Gestor de projetos com vasta experiência em liderança de equipes de desenvolvimento de software.",
        goal = "Guiar jovens gerentes de projeto no caminho do sucesso e eficácia na entrega de projetos.",
        technologies = mutableListOf<String>("Scrum", "Kanban", "Jira"),
        softSkills = mutableListOf<String>("Liderança", "Gestão de conflitos"),
        active = true
    )

    println("Mentor 1: $mentor1")
    println("Mentor 2: $mentor2")
    println("Mentor 3: $mentor3")
    println("Mentor 4: $mentor4")
    println("Mentor 5: $mentor5")

    return listOf(
        user1, user2, user3, user4, user5, mentor1, mentor2, mentor3, mentor4, mentor5
    )
}