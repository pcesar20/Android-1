package br.com.pauloc.maxApp.modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TempCliente (
    @SerializedName("cliente")
    val cliente: Cliente
)

@Entity(tableName = "clientes")
data class Cliente (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "codigo")
    val codigo: String,
    @ColumnInfo(name = "razao_social")
    val razao_social: String,
    @ColumnInfo(name = "nomeFantasia")
    val nomeFantasia: String,
    @ColumnInfo(name = "cpf")
    val cpf: String? = null,
    @ColumnInfo(name = "cnpj")
    val cnpj: String? = null,
    @ColumnInfo(name = "ramo_atividade")
    val ramo_atividade: String,
    @ColumnInfo(name = "endereco")
    val endereco: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "contatos")
    var contatos: List<Contato>?
)