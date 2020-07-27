package br.com.pauloc.maxApp.DB

import androidx.room.TypeConverter
import br.com.pauloc.maxApp.modelos.Contato
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Converters {
    @TypeConverter
    fun listToJson(lista: List<String>?) : String {
        return Gson().toJson(lista)
    }

    @TypeConverter
    fun jsonToList(json: String): List<String>?{
        val lista = Gson().fromJson(json, Array<String>::class.java)
        return lista?.toList()
    }

    @TypeConverter
    fun contatosToJson(lista: List<Contato>) : String {
        val builder = GsonBuilder()
        builder.serializeNulls()
        val gson = builder.setPrettyPrinting().create()
        return gson.toJson(lista)
    }


    @TypeConverter
    fun jsonToContatos(json: String): List<Contato>?{
        val gson = GsonBuilder().serializeNulls().create()
        val lista = gson.fromJson(json, Array<Contato>::class.java)
        return lista?.toList()
    }

}