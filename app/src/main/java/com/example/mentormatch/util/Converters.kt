package com.example.mentormatch.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun multableListToString(value: MutableList<String>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun stringToMultableList(value: String): MutableList<String> {
        val tecnologies = value.split(",");
        return tecnologies.toMutableList();
    }
}