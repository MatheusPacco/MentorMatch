package com.example.mentormatch.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mentormatch.model.User

@Dao
interface UserDao {

    @Insert
    fun salvar(user: User): Long

    @Update
    fun atualizar(user: User): Int

    @Delete
    fun excluir(user: User): Int

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun buscarUsuarioPeloId(id: Long): User

    @Query("SELECT * FROM tbl_user ORDER BY name ASC")
    fun listarUsuarios(): List<User>
}