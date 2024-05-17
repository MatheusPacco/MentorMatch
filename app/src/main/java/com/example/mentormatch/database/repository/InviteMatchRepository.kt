package com.example.mentormatch.database.repository

import android.content.Context
import com.example.mentormatch.database.dao.MentorMatchDb
import com.example.mentormatch.model.InviteMatch

class InviteMatchRepository (context : Context){

    // Instância do BD
    var db = MentorMatchDb.getDatabase(context).inviteMatchDao()

    fun salvar(inviteMatch: InviteMatch):Long{
        return db.salvar(inviteMatch);
    }
    fun atualizar(inviteMatch: InviteMatch): Int{
        return db.atualizar(inviteMatch);
    }
    fun excluir(inviteMatch: InviteMatch): Int{
        return db.excluir(inviteMatch);
    }
    fun buscarInvateMatch(usuarioId : Long): InviteMatch {
        return db.buscarInvateMatch(usuarioId);
    }
}