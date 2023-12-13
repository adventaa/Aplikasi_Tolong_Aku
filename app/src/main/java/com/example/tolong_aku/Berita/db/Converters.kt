package com.example.tolong_aku.Berita.db

import androidx.room.TypeConverter
import com.example.tolong_aku.Berita.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String): Source {
        return Source(name, name)
    }
}