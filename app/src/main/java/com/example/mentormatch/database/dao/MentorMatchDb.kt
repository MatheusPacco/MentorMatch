package com.example.mentormatch.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mentormatch.model.InviteMatch
import com.example.mentormatch.model.User
import com.example.mentormatch.util.Converters

@Database(entities = [User::class, InviteMatch::class], version = 1)
@TypeConverters(Converters::class)
abstract class MentorMatchDb : RoomDatabase(){
    // Instância da Interface
    abstract fun usuarioDao(): UserDao

    abstract fun inviteMatchDao(): InviteMatchDao

    // Instânciar o BD (Singlentom)
    companion object {

        private lateinit var instance: MentorMatchDb

        fun getDatabase(context: Context): MentorMatchDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        MentorMatchDb::class.java,
                        "mentor_match_db"
                    )
                    .allowMainThreadQueries()
                    // .fallbackToDestructiveMigration() // Destruir o BD a cada instância
                    .build()
            }
            return instance
        }
    }
}