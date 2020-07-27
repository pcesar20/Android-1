package br.com.pauloc.maxApp.API


import br.com.pauloc.maxApp.modelos.Cliente
import br.com.pauloc.maxApp.modelos.Pedido
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {
    var URL: String
        get() = "http://maximatech.free.beeceptor.com/android/"
        set(value) = TODO()


    @GET("cliente")
    fun getClientInfo(): Call<Cliente>

    @GET("pedido")
    fun getAllRequests(): Call<Pedido>


}