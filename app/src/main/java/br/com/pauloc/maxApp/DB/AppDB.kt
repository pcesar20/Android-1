package br.com.pauloc.maxApp.DB

import android.content.Context
import androidx.room.*
import br.com.pauloc.maxApp.modelos.Cliente
import br.com.pauloc.maxApp.modelos.Pedido

@Database(entities = [Pedido::class, Cliente::class], version = 13)
@TypeConverters(Converters::class)
abstract class AppDB : RoomDatabase() {

    abstract fun maxAppDao(): maxAppDao

    companion object {
        var INSTANCE: AppDB? = null
        fun getInstance(context: Context): AppDB {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDB::class.java,
                    "database.db"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE as AppDB
            } else {
                INSTANCE as AppDB
            }

        }
    }

}