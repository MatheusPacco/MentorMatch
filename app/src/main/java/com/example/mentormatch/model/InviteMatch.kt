package com.example.mentormatch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_invite_match")
data class InviteMatch (
    @PrimaryKey( autoGenerate = true ) var inviteMatchId: Long = 0,
    val aprendizId: Long,
    val mentorId: Long,
    val inviteStatus: String,
    val aprendizConfirmado: Boolean,
    val mentorConfirmado: Boolean,
)