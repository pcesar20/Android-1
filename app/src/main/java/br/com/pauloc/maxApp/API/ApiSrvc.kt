package br.com.pauloc.maxApp.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiSrvc {

    var URL = "http://maximatech.free.beeceptor.com/android/"

    @GET("cliente")

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getEndPoints(): EndPoint {
        return getRetrofit().create(EndPoint::class.java)
    }
}