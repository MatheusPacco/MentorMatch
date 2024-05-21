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
    fun buscarInviteMatch(usuarioId : Long): InviteMatch {
        return db.buscarInviteMatch(usuarioId);
    }

    fun buscarInviteMatchPorMentorId(mentorId : Long):List<InviteMatch>{
        return db.buscarInviteMatchPorMentorId(mentorId);
    }

    fun buscarInviteMatchPorAprendizId(aprendizId : Long):List<InviteMatch>{
        return db.buscarInviteMatchPorAprendizId(aprendizId);
    }

}