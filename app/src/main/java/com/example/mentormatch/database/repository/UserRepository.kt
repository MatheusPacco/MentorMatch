package com.example.mentormatch.database.repository

import android.content.Context
import com.example.mentormatch.database.dao.MentorMatchDb
import com.example.mentormatch.model.User

class UserRepository (context : Context){

    // Instãncia do BD
    var db = MentorMatchDb.getDatabase(context).usuarioDao()

    fun salvar(usuario: User): Long{
        return db.salvar(usuario);
    }

    fun atualizar(usuario : User): Int{
        return db.atualizar(usuario);
    }

    fun excluir(usuario : User): Int{
        return db.excluir(usuario);
    }

    fun buscarUsuarioPeloId(id : Long): User{
        return db.buscarUsuarioPeloId(id);
    }

    fun listarUsuarios(): List<User>{
        return db.listarUsuarios()
    }

}