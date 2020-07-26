package br.com.pauloc.maxApp.modelos

data class Contato (
    val nome: String,
    val telefone: String,
    val celular: String,
    val conjuge: String,
    val tipo: String,
    val time: String,
    val e_mail: String,
    val data_nascimento: String,
    val dataNascimentoConjuge: String? = null
)