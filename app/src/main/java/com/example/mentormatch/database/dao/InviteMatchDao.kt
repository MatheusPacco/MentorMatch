package com.example.mentormatch.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mentormatch.model.InviteMatch

@Dao
interface InviteMatchDao {

    @Insert
    fun salvar(inviteMatch: InviteMatch): Long

    @Update
    fun atualizar(inviteMatch: InviteMatch): Int

    @Delete
    fun excluir(inviteMatch: InviteMatch): Int

    @Query("SELECT * FROM tbl_invite_match WHERE aprendizId = :usuarioId OR mentorId = :usuarioId")
    fun buscarInvateMatch(usuarioId : Long):InviteMatch
}